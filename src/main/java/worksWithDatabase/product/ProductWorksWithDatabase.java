package worksWithDatabase.product;

import beans.DateTime;
import beans.productAdmin.*;
import connectionDatabase.DataSource;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    public ProductWorksWithDatabase() {
    }

    //  Phương thúc cập nhật lại hàng mới về khi mở trang quản lý sản phẩm
    public void update() {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT s.ma_sp,s.ngay_tao,g.gia_km,SUM(t.so_luong_con_lai) AS so_luong_con_lai FROM san_pham s JOIN  thong_tin_chi_tiet_sp t ON s.ma_sp = t.ma_sp JOIN gia_sp_khuyen_mai g ON g.ma_sp = s.ma_sp WHERE s.trang_thai = ? GROUP BY s.ma_sp,s.ngay_tao,g.gia_km");
            preparedStatement.setInt(1, ProductAdminConfiguration.HANG_MOI_NHAP);
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<String, Integer> mapNeedUpdate = new HashMap<String, Integer>();
            Date nowDate = new Date();
            while (resultSet.next()) {
                DateTime dateTime = new DateTime(resultSet.getString("ngay_tao"));
                if (nowDate.getTime() > dateTime.getTime(7)) {
                    String id = resultSet.getString("ma_sp");
                    int gia_km = resultSet.getInt("gia_km");
                    int so_luong_con_lai = resultSet.getInt("so_luong_con_lai");
                    if (so_luong_con_lai == 0) {
                        mapNeedUpdate.put(id, ProductAdminConfiguration.HET_HANG);
                    } else if (gia_km != 0) {
                        mapNeedUpdate.put(id, ProductAdminConfiguration.DANG_GIAM_GIA);
                    } else {
                        mapNeedUpdate.put(id, ProductAdminConfiguration.BINH_THUONG);
                    }
                }
            }
            resultSet.close();

            preparedStatement = connection.prepareStatement("UPDATE san_pham SET trang_thai = ? WHERE ma_sp = ?");
            for (Map.Entry<String, Integer> entry : mapNeedUpdate.entrySet()) {
                preparedStatement.setInt(1, entry.getValue());
                preparedStatement.setString(2, entry.getKey());
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phương thức nhận vô List productAdmin điền thông tin cho nó
    public void fillDataProduct(List<ProductAdmin> products){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM san_pham WHERE ma_sp = ?");
            for(ProductAdmin productAdmin :products){
                preparedStatement.setString(1,productAdmin.getMa_sp());
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                productAdmin.setTen_sp(resultSet.getString("ten_sp"));
                ProductAdminManufacturer productAdminManufacturer = new ProductAdminManufacturer();
                productAdminManufacturer.setId(resultSet.getString("ma_hsx"));
                productAdmin.setHang_san_xuat(productAdminManufacturer);
                ProductAdminCategory productAdminCategory = new ProductAdminCategory();
                productAdminCategory.setId(resultSet.getString("ma_dm"));
                productAdmin.setDanh_muc(productAdminCategory);
                productAdmin.setNgay_tao(new DateTime(resultSet.getString("ngay_tao")));
                productAdmin.setGioi_tinh(resultSet.getInt("gioi_tinh"));
                productAdmin.setTrang_thai(resultSet.getInt("trang_thai"));
                productAdmin.setSo_luong_ban_ra(resultSet.getInt("so_luong_ban_ra"));
                productAdmin.setTon_tai(resultSet.getInt("ton_tai"));
                resultSet.close();
            }
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phuơng thức lấy mã sản phẩm tiếp theo
    public String getNextId(){

        String result = null;
        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_sp) AS so_luong FROM san_pham");
            resultSet.next();
            result = "sp_"+(resultSet.getInt("so_luong")+1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phương thức thêm một sản phẩm vô csdl
    public void addSpToDatabase(String ma_sp,String ten_sp,String ma_hsx,String ma_dm,DateTime ngay_tao,int gioi_tinh,int trang_thai,int so_luong_ban_ra,int ton_tai){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO san_pham VALUES(?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,ma_sp);
            preparedStatement.setString(2,ten_sp);
            preparedStatement.setString(3,ma_hsx);
            preparedStatement.setString(4,ma_dm);
            preparedStatement.setString(5,ngay_tao.toString());
            preparedStatement.setInt(6,gioi_tinh);
            preparedStatement.setInt(7,trang_thai);
            preparedStatement.setInt(8,so_luong_ban_ra);
            preparedStatement.setInt(9,ton_tai);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phương thức thêm một sản phẩm vô csdl
        public void editSpToDatabase(String ma_sp,String ten_sp,String ma_hsx,String ma_dm,int gioi_tinh){
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE san_pham SET ten_sp = ?, ma_hsx = ?,ma_dm=?,gioi_tinh=? WHERE ma_sp = ?");
            preparedStatement.setString(1,ten_sp);
            preparedStatement.setString(2,ma_hsx);
            preparedStatement.setString(3,ma_dm);
            preparedStatement.setInt(4,gioi_tinh);
            preparedStatement.setString(5,ma_sp);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }


    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminEditGroup){
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM san_pham WHERE ma_sp = ?");
            preparedStatement.setString(1, productAdminEditGroup.getMa_sp());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            productAdminEditGroup.setTen_sp(resultSet.getString("ten_sp"));
            ProductAdminManufacturer productAdminManufacturer = new ProductAdminManufacturer();
            productAdminManufacturer.setId(resultSet.getString("ma_hsx"));
            productAdminEditGroup.setHang_san_xuat(productAdminManufacturer);
            ProductAdminCategory productAdminCategory = new ProductAdminCategory();
            productAdminCategory.setId(resultSet.getString("ma_dm"));
            productAdminEditGroup.setDanh_muc(productAdminCategory);
            productAdminEditGroup.setGioi_tinh(resultSet.getInt("gioi_tinh")==0?"nu":"nam");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
    }


}
