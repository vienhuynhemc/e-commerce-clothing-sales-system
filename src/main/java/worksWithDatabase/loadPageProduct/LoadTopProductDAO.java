package worksWithDatabase.loadPageProduct;

import beans.account.ConvertDate;
import beans.product.*;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoadTopProductDAO {
    public LoadTopProductDAO() {
    }

    public ArrayList<Product> loadTopProduct(String type) {
        ArrayList<Product> listProduct = new ArrayList<>();

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();
            int sex;

            switch (type){
                case "Nam":
                    sex = 1;
                    break;
                case "Nu":
                    sex = 0;
                    break;
                default:
                    sex = 0;
                    break;
            }
            String sql = "SELECT * FROM san_pham sp where gioi_tinh = ? and sp.ton_tai = 1 " +
                    " and sp.trang_thai = 1 ORDER BY so_luong_ban_ra DESC LIMIT 3";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,sex);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Product p = new Product();
                p.setMa_sp(rs.getString(1));
                p.setTen_sp(rs.getString(2));
                p.setMa_hsx(rs.getString(3));
                p.setMa_dm(rs.getString(4));
                p.setNgay_tao(ConvertDate.changeDate(rs.getString(5)));
                p.setGioi_tinh(rs.getInt(6));
                p.setTrang_thai(rs.getInt(7));
                p.setSo_luong_ban_ra(rs.getInt(8));
                p.setTon_tai(rs.getInt(9));
                listProduct.add(p);

            }
            rs.close();
            ps.close();


            String sqlImg = "SELECT DISTINCT hinh.ma_sp,hinh.ma_mau,hinh.hinh_anh,hinh.link_hinh_anh FROM " +
                    "hinh_anh_sp hinh, san_pham sp, thong_tin_chi_tiet_sp tt" +
                    " WHERE hinh.ma_sp = sp.ma_sp and sp.ma_sp = tt.ma_sp " +
                    "and tt.ma_mau = hinh.ma_mau and sp.ma_sp = ? and tt.ton_tai = 1";

            for (int i = 0; i < listProduct.size(); i++) {
                PreparedStatement ps2 = con.prepareStatement(sqlImg);
                ps2.setString(1,listProduct.get(i).getMa_sp());

                ResultSet rs2 = ps2.executeQuery();

                ArrayList<ProductImage> listI = new ArrayList<ProductImage>();
                while (rs2.next()){
                    listI.add(new ProductImage(rs2.getString(1),rs2.getString(2)
                            ,rs2.getString(3)));
                }
                listProduct.get(i).setListIMG(listI);
                rs2.close();
                ps2.close();
            }



            String sqlPrice = "SELECT * from gia_sp gia WHERE gia.ma_sp = ?";
            for (int i = 0; i < listProduct.size(); i++) {
                PreparedStatement ps2 = con.prepareStatement(sqlPrice);
                ps2.setString(1,listProduct.get(i).getMa_sp());

                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()){
                    listProduct.get(i).setPrice(new ProductPrice(rs2.getString(1),rs2.getDouble(2),ConvertDate.changeDate(rs2.getString(3))));
                }
                rs2.close();
                ps2.close();
            }


            String sqlPriceSale = "SELECT * from gia_sp_khuyen_mai gia WHERE gia.ma_sp = ?";
            for (int i = 0; i < listProduct.size(); i++) {
                PreparedStatement ps2 = con.prepareStatement(sqlPriceSale);
                ps2.setString(1,listProduct.get(i).getMa_sp());

                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()){
                    listProduct.get(i).setPriceSale(new ProductPriceSale(rs2.getString(1),rs2.getDouble(2),ConvertDate.changeDate(rs2.getString(3))));
                }
                rs2.close();
                ps2.close();
            }




            DataSource.getInstance().releaseConnection(con);
            return listProduct;

        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return listProduct;
        }
    }

    public static void main(String[] args) {
        LoadTopProductDAO dao = new LoadTopProductDAO();

        System.out.println(dao.loadTopProduct("Nu"));
       // System.out.println(dao.loadTopProduct("Nu").get(0).getListIMG().get(0));
    }
}
