package worksWithDatabase.loadPageHistory;

import beans.product.ProductImage;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductImageByIDOrderDAO {

    public ProductImageByIDOrderDAO() {
    }

    public ArrayList<ProductImage> listDetail(String ma_don_hang){
        Connection con = null;
        ArrayList<ProductImage> result = new ArrayList<ProductImage>();
        try {

            con = DataSource.getInstance().getConnection();


            String sql = "SELECT hinh.ma_sp,hinh.ma_mau,hinh.link_hinh_anh,hinh.mac_dinh FROM \n" +
                    "hinh_anh_sp hinh, chi_tiet_don_hang ct\n" +
                    " WHERE hinh.ma_sp = ct.ma_san_pham\n" +
                    "and ct.ma_mau = hinh.ma_mau\n" +
                    "and ct.ma_don_hang = ? GROUP BY hinh.ma_sp, hinh.ma_mau";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,ma_don_hang);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                result.add(new ProductImage(rs.getString(1),
                rs.getString(2), rs.getString(3),rs.getInt(4) ));

            }

            rs.close();
            ps.close();

            DataSource.getInstance().releaseConnection(con);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return result;
        }

    }

    public static void main(String[] args) {
        ProductImageByIDOrderDAO detailOrderDAO = new ProductImageByIDOrderDAO();

        System.out.println(detailOrderDAO.listDetail("donhang_KH0018255961140"));

    }

}
