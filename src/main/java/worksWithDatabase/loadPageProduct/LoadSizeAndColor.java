package worksWithDatabase.loadPageProduct;

import beans.product.ProductColor;
import beans.product.Size;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoadSizeAndColor {



    public LoadSizeAndColor() {

    }

    public ArrayList<ProductColor> laodColorByproduct(String ma_sp){
        ArrayList<ProductColor> result = new ArrayList<>();

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();

            String sql = "SELECT DISTINCT m.ma_mau,m.ten_mau,m.hinh_anh_mau,m.link_hinh_anh  FROM thong_tin_chi_tiet_sp tt, mau m WHERE tt.ma_mau = m.ma_mau and tt.ma_sp = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,ma_sp);

            ResultSet rs1 = ps.executeQuery();

            while (rs1.next()){
                result.add(new ProductColor(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4)));
            }

            rs1.close();
            ps.close();


            DataSource.getInstance().releaseConnection(con);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return result;
        }
    }


    public ArrayList<Size> loadSizeByIDProduct(String ma_sp){
        ArrayList<Size> result = new ArrayList<Size>();

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();

            // load danh sach size dựa vào id sản phẩm
            String sqlSize = "SELECT DISTINCT s.ma_size, s.ten_size  FROM thong_tin_chi_tiet_sp tt, size s WHERE tt.ma_size = s.ma_size and tt.ma_sp = ?";

            PreparedStatement ps1 = con.prepareStatement(sqlSize);
            ps1.setString(1,ma_sp);

                    ResultSet rs1 = ps1.executeQuery();

            while(rs1.next()){
                result.add(new Size(rs1.getString(1),rs1.getString(2)));
            }
            rs1.close();
            ps1.close();

            DataSource.getInstance().releaseConnection(con);
            return result;

            //-----------------
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return result;
        }
    }

    public ArrayList<ProductColor> loadColorBySize(String ma_sp,String ma_zise){
        ArrayList<ProductColor> result = new ArrayList<ProductColor>();
        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();

            String sqlcolor = "SELECT DISTINCT m.ma_mau,m.ten_mau,m.hinh_anh_mau,m.link_hinh_anh  FROM thong_tin_chi_tiet_sp tt, mau m WHERE tt.ma_mau = m.ma_mau and tt.ma_sp = ? and tt.ma_size = ?";

            PreparedStatement ps = con.prepareStatement(sqlcolor);

            ps.setString(1,ma_sp);
            ps.setString(2,ma_zise);

            ResultSet rs1 = ps.executeQuery();

            while(rs1.next()){
                result.add(new ProductColor(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4)));
            }
            rs1.close();
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
        LoadSizeAndColor loadSizeAndColor = new LoadSizeAndColor();
        System.out.println(loadSizeAndColor.loadColorBySize("sp_1","size_1"));
        System.out.println(loadSizeAndColor.loadSizeByIDProduct("sp_1"));
    }
}
