package worksWithDatabase.detailProductIndex;

import beans.DateTime;
import beans.product.*;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DetailProductDAO {
    public Product getProductById(String id){
        Product p = new Product();
        Connection connection = DataSource.getInstance().getConnection();
        try{
            String sql ="SELECT s.ma_sp, s.ten_sp, s.ma_hsx, s.ngay_tao, s.gioi_tinh, s.trang_thai," +
                    "s.so_luong_ban_ra, s.ton_tai, g.gia_sp, gk.gia_km, d.ten_dm from san_pham s,gia_sp g," +
                    "gia_sp_khuyen_mai gk,danh_muc d WHERE s.ma_sp = g.ma_sp AND d.ma_dm = s.ma_dm AND s.ma_sp = ? \n" +
                    "GROUP BY s.ma_sp, s.ten_sp, s.ma_hsx";
//            masp tensp mahsx ngaytao gioitinh trangthai soluongbanra tontai giasp giakm tendm
            PreparedStatement s = connection.prepareStatement(sql);
            s.setString(1,id);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
                p.setMa_sp(rs.getString(1));
                p.setTen_sp(rs.getString(2));
                p.setMa_hsx(rs.getString(3));

                String dateTime = rs.getString(4);

                String[] dayTime = dateTime.split(" ");
                String[] date = dayTime[0].split("-");
                String[] time = dayTime[1].split(":");
                int year = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int day = Integer.parseInt(date[2]);

                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);
                double secon = Double.parseDouble(time[2]);
                int second = (int)secon;

                DateTime d = new DateTime(year,month,day,hour,minute,second);

                p.setNgay_tao(d);
                p.setGioi_tinh(rs.getInt(5));
                p.setTrang_thai(rs.getInt(6));
                p.setSo_luong_ban_ra(rs.getInt(7));
                p.setTon_tai(rs.getInt(8));

                p.setCategoryName(rs.getString(11));

                rs.close();
                s.close();

//                lấy danh sách ảnh
                PreparedStatement img = connection.prepareStatement("SELECT s.ma_sp, h.ma_mau, " +
                        "h.link_hinh_anh from san_pham s,hinh_anh_sp h WHERE s.ma_sp = ? AND s.ma_sp = h.ma_sp" +
                        " AND s.ton_tai = 1 ");
                img.setString(1,id);
                ResultSet rImg = img.executeQuery();
                ArrayList<ProductImage> imgs = new ArrayList<>();
                while(rImg.next()){
                    ProductImage pi = new ProductImage();
                    pi.setMa_sp(rImg.getString(1));
                    pi.setMa_mau(rImg.getString(2));
                    pi.setLink_hinh(rImg.getString(3));
                    imgs.add(pi);
                }
                p.setListIMG(imgs);
                rImg.close();
                img.close();

                PreparedStatement size = connection.prepareStatement("select si.ma_size,si.ten_size from san_pham s," +
                        "size si, thong_tin_chi_tiet_sp t WHERE s.ma_sp = ? AND s.ton_tai = 1 AND" +
                        " si.ma_size = t.ma_size AND t.ma_sp = s.ma_sp GROUP BY t.ma_size, si.ten_size");
                size.setString(1,id);
                ResultSet rSize = size.executeQuery();
                ArrayList<Size> sizes = new ArrayList<>();
                while(rSize.next()){
                    Size si = new Size();
                    si.setMa_size(rSize.getString(1));
                    si.setTen_size(rSize.getString(2));
                    sizes.add(si);
                }
                p.setListSize(sizes);
                size.close();
                rSize.close();


//                lấy giá sản phẩm
                PreparedStatement price = connection.prepareStatement("SELECT s.ma_sp,g.gia_sp,g.ngay_cap_nhat from " +
                        "san_pham s, gia_sp g WHERE g.ma_sp = s.ma_sp AND s.ton_tai = 1\n" +
                        " AND s.ma_sp = ?");
                price.setString(1,id);
                ResultSet rPrice = price.executeQuery();
                ProductPrice pr = new ProductPrice();
                if(rPrice.next()){
                    pr.setMa_sp(rPrice.getString(1));
                    pr.setGia_sp(rPrice.getDouble(2));

                    String dateTim = rPrice.getString(3);

                    DateTime dt = changrDateTime(dateTim);

                    pr.setNgay_cap_nhat(dt);
                }
                p.setPrice(pr);
                rPrice.close();
                price.close();

//                lấy giá sản phẩm khuyến mãi
                PreparedStatement priceS = connection.prepareStatement("SELECT s.ma_sp,g.gia_km,g.ngay_cap_nhat from " +
                        "san_pham s, gia_sp_khuyen_mai g WHERE g.ma_sp = s.ma_sp AND s.ton_tai = 1\n" +
                        " AND s.ma_sp = ?");
                priceS.setString(1,id);
                ResultSet rPriceS = priceS.executeQuery();
                ProductPriceSale prs = new ProductPriceSale();
                if(rPriceS.next()){
                    prs.setMa_sp(rPriceS.getString(1));
                    prs.setGia_sp_km(rPriceS.getDouble(2));

                    String dateTim = rPriceS.getString(3);

                    DateTime dt = changrDateTime(dateTim);

                    prs.setNgay_cap_nhat(dt);
                }
                p.setPriceSale(prs);
                rPriceS.close();
                priceS.close();


                // lấy danh sách màu sản phẩm
                PreparedStatement color = connection.prepareStatement("SELECT * from mau m, thong_tin_chi_tiet_sp t," +
                        " san_pham s where m.ma_mau = t.ma_mau AND t.ma_sp = s.ma_sp AND s.ton_tai = 1 AND s.ma_sp = ?" +
                        " GROUP BY m.ma_mau, m.ten_mau");
                color.setString(1,id);
                ResultSet rColor = color.executeQuery();
                ArrayList<ProductColor> colors = new ArrayList<>();
                while(rColor.next()){
                    ProductColor pc = new ProductColor();
                    pc.setMa_mau(rColor.getString(1));
                    pc.setTen_mau(rColor.getString(2));
                    pc.setLink_hinh(rColor.getString(3));
                    colors.add(pc);
                }
                p.setListColor(colors);
                rColor.close();
                color.close();
                // lấy cấu tạo sản phẩm
                PreparedStatement material = connection.prepareStatement("SELECT cau_tao FROM `cau_tao_sp` WHERE ma_sp = ?");
                material.setString(1,id);
                ResultSet rMaterials = material.executeQuery();
                ArrayList<String> materials = new ArrayList<>();
                ProductStructure pc = new ProductStructure();
                pc.setMa_sp(id);
                    while (rMaterials.next()) {
                        materials.add(rMaterials.getString(1));
                    }
                pc.setCau_tao(materials);
                p.setCau_tao_sp(pc);
                rMaterials.close();
                material.close();

                //lấy thông tin sản phẩm
                PreparedStatement info = connection.prepareStatement("SELECT * FROM `thong_tin_sp` WHERE ma_sp = ?");
                info.setString(1,id);
                ResultSet rInfo = info.executeQuery();

                ArrayList<ProductInfomation> pis = new ArrayList<>();
                while (rInfo.next()) {
                    ProductInfomation pi = new ProductInfomation();
                    pi.setMa_sp(rInfo.getString(1));
                    pi.setThong_tin(rInfo.getString(2));
                    pis.add(pi);
                }
                p.setListInfo(pis);
                rInfo.close();
                info.close();
                // lấy giới thiệu sản phẩm
                PreparedStatement intro = connection.prepareStatement("SELECT gioi_thieu FROM `gioi_thieu_sp` WHERE ma_sp = ?");
                intro.setString(1,id);
                ResultSet rIntro = intro.executeQuery();
                ArrayList<String> piss = new ArrayList<>();
                ProductIntroduction pi = new ProductIntroduction();
                pi.setMa_sp(id);
                while (rIntro.next()) {
                    piss.add(rIntro.getString(1));
                }
                pi.setGioi_thieu(piss);
                p.setGioi_thieu_sp(pi);
                rIntro.close();
                intro.close();

//                lấy hãng sản xuất
                PreparedStatement manuf = connection.prepareStatement("SELECT s.ma_hsx,h.ten_hsx, c.chi_tiet FROM san_pham " +
                        "s, chi_tiet_hsx c, hang_san_xuat h WHERE s.ma_hsx = c.ma_hsx AND h.ma_hsx = c.ma_hsx " +
                        "AND s.ma_sp = ?");
                manuf.setString(1,id);
                ResultSet rMa = manuf.executeQuery();
                ArrayList<String> manufactutrer = new ArrayList<>();
                Manufacturer manu = new Manufacturer();
                if(rMa.next()) {
                    manu.setMa_hsx(rMa.getString(1));
                    manu.setTen_hsx(rMa.getString(2));
                    rMa.beforeFirst();
                    while (rMa.next()) {
                        manufactutrer.add(rMa.getString(3));
                    }
                }
//
                manu.setThong_tin(manufactutrer);

                p.setHang_san_xuat(manu);
                rMa.close();
                manuf.close();



                DataSource.getInstance().releaseConnection(connection);
                return p;



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return p;

    }
    public DateTime changrDateTime(String dateTime){
        String[] dayTime = dateTime.split(" ");
        String[] date = dayTime[0].split("-");
        String[] time = dayTime[1].split(":");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        double secon = Double.parseDouble(time[2]);
        int second = (int)secon;

        DateTime sd = new DateTime(year,month,day,hour,minute,second);
        return sd;
    }
//    lấy mã size và số lượng còn lại thông qua masp và ma_mau
    public ArrayList<ProductDetailInformation> getInfoDetailProduct(String id, String color){
        Connection connection = DataSource.getInstance().getConnection();
        try{


            String sql = "SELECT s.ma_sp, t.ma_mau, t.ma_size,t.so_luong_con_lai,t.ton_tai,si.ten_size from thong_tin_chi_tiet_sp" +
                    " t, san_pham s,size si where t.ma_sp = s.ma_sp AND si.ma_size = t.ma_size AND s.ton_tai = 1 AND " +
                    "s.ma_sp = ? AND t.ma_mau = ?";
            PreparedStatement s = connection.prepareStatement(sql);
            s.setString(1,id);
            s.setString(2,color);
            ResultSet rs = s.executeQuery();
            ArrayList<ProductDetailInformation> info = new ArrayList<>();
            while(rs.next()){
                ProductDetailInformation p = new ProductDetailInformation();
                p.setMa_sp(rs.getString(1));
                p.setMa_mau(rs.getString(2));
                p.setMa_size(rs.getString(3));
                p.setSo_luong_con_lai(rs.getInt(4));
                p.setTon_tai(rs.getInt(5));
                p.setTen_size(rs.getString(6));

                info.add(p);

            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return info;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        DetailProductDAO test = new DetailProductDAO();
//       for(ProductColor s : test.getProductById("sp_1").getListColor()){
//           System.out.println(s.getLink_hinh());
//       }
        System.out.println(test.getProductById("sp_1").getListColor());
    }

}
