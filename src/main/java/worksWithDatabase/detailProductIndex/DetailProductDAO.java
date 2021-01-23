package worksWithDatabase.detailProductIndex;

import beans.DateTime;
import beans.product.*;
import connectionDatabase.DataSource;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
                        "h.link_hinh_anh from san_pham s,hinh_anh_sp h WHERE s.ma_sp = h.ma_sp AND s.ma_sp = ?" +
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
                        "san_pham s, gia_sp g WHERE g.ma_sp = s.ma_sp AND s.ton_tai = 1" +
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
//            lấy số lượng size và danh sách hình ảnh của size đó
            String sql1 = "SELECT s.ma_sp, t.ma_mau, t.ma_size,si.ten_size, h.link_hinh_anh,count(h.link_hinh_anh) " +
                    "as sl,t.so_luong_con_lai, t.ton_tai from thong_tin_chi_tiet_sp\n" +
                    "t, san_pham s,size si, hinh_anh_sp h where t.ma_sp = s.ma_sp AND si.ma_size = t.ma_size AND" +
                    " s.ton_tai = 1 AND s.ma_sp = ? AND t.ma_mau = ? AND h.ma_sp = s.ma_sp AND h.ma_mau" +
                    " = t.ma_mau GROUP BY s.ma_sp,h.ma_mau,t.ma_size,si.ten_size";
            PreparedStatement size = connection.prepareStatement(sql1);
            size.setString(1,id);
            size.setString(2,color);

            ResultSet rSize = size.executeQuery();
            // hashmap<size,sl>
            HashMap<String,Integer> mapSize = new HashMap<>();
            ArrayList<ProductDetailInformation> info = new ArrayList<>();
            ProductDetailInformation p = null;
            while(rSize.next()){
                p = new ProductDetailInformation();
                p.setMa_sp(rSize.getString("ma_sp"));
                p.setMa_mau(rSize.getString("ma_mau"));
                p.setMa_size(rSize.getString("ma_size"));
                p.setSo_luong_con_lai(rSize.getInt("so_luong_con_lai"));
                p.setTon_tai(rSize.getInt("ton_tai"));
                p.setTen_size(rSize.getString("ten_size"));
                info.add(p);
            }

            rSize.beforeFirst();
            while(rSize.next()){
                mapSize.put(rSize.getString(4),rSize.getInt(6));
            }

            rSize.close();
            size.close();



            String sql = "SELECT s.ma_sp, t.ma_mau, t.ma_size,t.so_luong_con_lai,t.ton_tai,si.ten_size, h.link_hinh_anh from thong_tin_chi_tiet_sp\n" +
                    "t, san_pham s,size si, hinh_anh_sp h where t.ma_sp = s.ma_sp AND si.ma_size = t.ma_size AND s.ton_tai = 1 AND\n" +
                    "s.ma_sp = ? AND t.ma_mau = ? AND h.ma_sp = s.ma_sp AND h.ma_mau = t.ma_mau";
            PreparedStatement s = connection.prepareStatement(sql);
            s.setString(1,id);
            s.setString(2,color);
            ResultSet rs = s.executeQuery();

            for(ProductDetailInformation pp : info){
                for(Map.Entry<String,Integer> m : mapSize.entrySet()){
                    if(rs.next()) {
                        ArrayList<String> imgs = new ArrayList<>();
                        for (int i = 0; i < m.getValue(); i++) {
                            imgs.add(rs.getString("link_hinh_anh"));
                            if (i != m.getValue() - 1) {
                                rs.next();
                            }
                        }
                    pp.setListIMG(imgs);
                    rs.beforeFirst();
                    }
                    }
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
    public ArrayList<String> loadImgById(String id, String color){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("SELECT h.link_hinh_anh from " +
                    "san_pham s, hinh_anh_sp h WHERE h.ma_sp = s.ma_sp and s.ma_sp = ? AND h.ma_mau = ?");

            ArrayList<String> list = new ArrayList<>();
            s.setString(1,id);
            s.setString(2,color);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
                list.add(rs.getString(1));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    public ArrayList<String> loadColorById(String id){
        Connection connection = DataSource.getInstance().getConnection();
        try{
            PreparedStatement s = connection.prepareStatement("SELECT DISTINCT h.ma_mau FROM san_pham s, " +
                    "hinh_anh_sp h  WHERE h.ma_sp = s.ma_sp AND s.ma_sp = ?");

            ArrayList<String> list = new ArrayList<>();
            s.setString(1,id);

            ResultSet rs = s.executeQuery();
            while(rs.next()){
                list.add(rs.getString(1));
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return new ArrayList<>();
    }
    // hiển thị số lượng còn lại
    public int getRestNumber(String id, String color, String size){
        Connection connection = DataSource.getInstance().getConnection();
        int a = 0;
        try{
            PreparedStatement s = connection.prepareStatement("select so_luong_con_lai from thong_tin_chi_tiet_sp " +
                    "WHERE ma_sp = ? AND ma_mau = ? AND ma_size = ?");
            s.setString(1,id);
            s.setString(2,color);
            s.setString(3,size);
            ResultSet rs = s.executeQuery();
            if (rs.next()){
                a = rs.getInt(1);
            }
            rs.close();
            s.close();
            DataSource.getInstance().releaseConnection(connection);
            return a;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return a;

    }

    public static void main(String[] args) {
        DetailProductDAO test = new DetailProductDAO();
//       for(ProductDetailInformation s : test.getInfoDetailProduct("sp_2", "mau_1")){
//           System.out.println(s);
//       }
       System.out.println(test.getInfoDetailProduct("sp_1","mau_1"));
    }

}
