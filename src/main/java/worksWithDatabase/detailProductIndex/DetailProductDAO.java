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
                PreparedStatement img = connection.prepareStatement("SELECT s.ma_sp, h.ma_mau, h.hinh_anh, " +
                        "h.link_hinh_anh from san_pham s,hinh_anh_sp h WHERE s.ma_sp = ? AND s.ma_sp = h.ma_sp" +
                        " AND s.ton_tai = 1 ");
                img.setString(1,id);
                ResultSet rImg = img.executeQuery();
                ArrayList<ProductImage> imgs = new ArrayList<>();
                while(rImg.next()){
                    ProductImage pi = new ProductImage();
                    pi.setMa_sp(rImg.getString(1));
                    pi.setMa_mau(rImg.getString(2));
                    pi.setHinh_anh(rImg.getString(3));
                    pi.setLink_hinh(rImg.getString(4));
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
                    pc.setHinh_anh_mau(rColor.getString(3));
                    pc.setLink_hinh(rColor.getString(4));
                    colors.add(pc);
                }
                p.setListColor(colors);
                rColor.close();
                color.close();


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

    public static void main(String[] args) {
        DetailProductDAO test = new DetailProductDAO();
        System.out.println(test.getProductById("sp_1").getListColor());
    }

}
