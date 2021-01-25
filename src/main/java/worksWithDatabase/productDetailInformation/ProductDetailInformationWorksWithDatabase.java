package worksWithDatabase.productDetailInformation;

import beans.BeansConfiguration;
import beans.DateTime;
import beans.productAdmin.*;
import connectionDatabase.DataSource;
import model.productAdmin.ProductAdminModel;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;

public class ProductDetailInformationWorksWithDatabase {

    //  Constructor rỗng không có gì hết
    public ProductDetailInformationWorksWithDatabase() {
    }

    //  Phương thức nhận vào hãng sản xuất id , trả về số sản phẩm còn lại của hãng này
    public int getNumberOfProductByManufacturerId(String manufacturerId, Connection connection) {

        //  Khai báo kết quả
        int result = 0;

        try {

            //  Tạo 1 preparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(t.so_luong_con_lai) as tong_so_luong  FROM thong_tin_chi_tiet_sp t JOIN san_pham sp WHERE sp.ma_hsx = ? AND t.ton_tai = ?");

            //  Set where là id hãng sản xuất truyền vào, tồn tại là 0
            preparedStatement.setString(1, manufacturerId);
            preparedStatement.setInt(2, 1);

            //  Lấy result set
            ResultSet resultSet = preparedStatement.executeQuery();

            //  Nếu có kết quả thì gán lại kết quả;
            while (resultSet.next()) {
                result = resultSet.getInt("tong_so_luong");
            }

            //  Đóng resultset và preparedStatement
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

        //  Trả về kết quả
        return result;

    }

    //  Phương thúc lấy ra các màu và size đầu tiên
    public void fillProductAdminFirst(List<ProductAdmin> products, int line_per_page) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statemen = connection.createStatement();
            ResultSet resultSet = statemen.executeQuery("SELECT t.ma_sp,t.ma_mau,t.ma_size,t.so_luong_con_lai,t.hinh_anh_trong_firebase FROM thong_tin_chi_tiet_sp t JOIN san_pham s ON t.ma_sp = s.ma_sp WHERE t.ton_tai = 1 ORDER BY s.ngay_tao DESC LIMIT 0," + line_per_page);

            String ma_sp_hien_tai = "none";
            while(resultSet.next()){
                String ma_sp = resultSet.getString("ma_sp");
                if(!ma_sp.equals(ma_sp_hien_tai)){
                    ProductAdmin productAdmin = new ProductAdmin();
                    productAdmin.setMa_sp(ma_sp);
                    products.add(productAdmin);
                    ma_sp_hien_tai = ma_sp;
                }

                String ma_mau = resultSet.getString("ma_mau");
                String ma_size = resultSet.getString("ma_size");
                int so_luong_con_lai = resultSet.getInt("so_luong_con_lai");
                int hinh_anh_trong_firebase = resultSet.getInt("hinh_anh_trong_firebase");

                for(ProductAdmin productAdmin : products){
                    if(productAdmin.getMa_sp().equals(ma_sp)){

                        boolean check = false;
                        for(ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()){
                            if(productAdminColor.getMa_mau().equals(ma_mau)){
                                check =true;
                                ProductAdminSize productAdminSize = new ProductAdminSize();
                                productAdminSize.setId(ma_size);
                                productAdminSize.setSo_luong_con_lai(so_luong_con_lai);
                                productAdminColor.getDanh_sach_size().add(productAdminSize);
                                break;
                            }
                        }
                        if(!check){
                            ProductAdminColor productAdminColor = new ProductAdminColor();
                            productAdminColor.setMa_mau(ma_mau);
                            productAdminColor.setHinH_anh_trong_firebase(hinh_anh_trong_firebase);
                            ProductAdminSize productAdminSize = new ProductAdminSize();
                            productAdminSize.setId(ma_size);
                            productAdminSize.setSo_luong_con_lai(so_luong_con_lai);
                            productAdminColor.getDanh_sach_size().add(productAdminSize);
                            productAdmin.getDanh_sach_mau().add(productAdminColor);
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }

            resultSet.close();
            statemen.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    //  Phương thức lấy số sản phẩm tối đa đầu tiên
    public int getNumberOfMaxProductFirst(){

        Connection connection = DataSource.getInstance().getConnection();
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_sp) AS so_luong FROM thong_tin_chi_tiet_sp WHERE ton_tai = 1");
            resultSet.next();
            result =resultSet.getInt("so_luong");
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
    return result;
    }

    public int getNumberOfMaxProductFromAll( String selectSearchAndSort, String search){
        Connection connection = DataSource.getInstance().getConnection();
        int result = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(t.ma_sp) AS so_luong FROM (SELECT t.ma_sp, t.ma_mau,t.ma_size, t.so_luong_con_lai,t.hinh_anh_trong_firebase,(SELECT s.gia_sp FROM gia_sp s WHERE s.ma_sp = t.ma_sp ORDER BY s.ngay_cap_nhat DESC LIMIT 0,1) AS gia_sp, d.ten_dm,d.ma_dm,sp.ngay_tao,sp.ten_sp, m.ten_mau,size.ten_size,hsx.ten_hsx,hsx.ma_hsx , sp.gioi_tinh,sp.trang_thai,sp.so_luong_ban_ra,sp.ton_tai,m.link_hinh_anh FROM thong_tin_chi_tiet_sp t JOIN san_pham sp ON t.ma_sp = sp.ma_sp JOIN danh_muc d ON d.ma_dm = sp.ma_dm JOIN mau m ON m.ma_mau = t.ma_mau JOIN size size ON size.ma_size = t.ma_size JOIN hang_san_xuat hsx ON hsx.ma_hsx= sp.ma_hsx WHERE t.ton_tai = ? AND "+selectSearchAndSort+" LIKE ? ) t ");
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"%"+search+"%");
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    public void fillProductAdminFromAll(List<ProductAdmin> products, String selectSearchAndSort, String sort, String search, int lineOfOnPageQuanLySanPham, int nowPage) {

        Connection connection = DataSource.getInstance().getConnection();

        try {

            //  Tọa limit line
            int limitLine = (nowPage - 1) * lineOfOnPageQuanLySanPham;
            if (limitLine < 0) limitLine = 0;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT t.ma_sp, t.ma_mau,t.ma_size, t.so_luong_con_lai,t.hinh_anh_trong_firebase,(SELECT s.gia_sp FROM gia_sp s WHERE s.ma_sp = t.ma_sp ORDER BY s.ngay_cap_nhat DESC LIMIT 0,1) AS gia_sp, d.ten_dm,d.ma_dm,sp.ngay_tao,sp.ten_sp, m.ten_mau,size.ten_size,hsx.ten_hsx,hsx.ma_hsx , sp.gioi_tinh,sp.trang_thai,sp.so_luong_ban_ra,sp.ton_tai,m.link_hinh_anh FROM thong_tin_chi_tiet_sp t JOIN san_pham sp ON t.ma_sp = sp.ma_sp JOIN danh_muc d ON d.ma_dm = sp.ma_dm JOIN mau m ON m.ma_mau = t.ma_mau JOIN size size ON size.ma_size = t.ma_size JOIN hang_san_xuat hsx ON hsx.ma_hsx= sp.ma_hsx WHERE t.ton_tai = ? AND "+selectSearchAndSort+" LIKE ? ORDER BY "+selectSearchAndSort+" "+sort+" LIMIT "+limitLine+","+lineOfOnPageQuanLySanPham);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"%"+search+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            String ma_sp_hien_tai = "none";
            while(resultSet.next()){
                String ma_sp = resultSet.getString("ma_sp");
                if(!ma_sp.equals(ma_sp_hien_tai)){
                    ProductAdmin productAdmin = new ProductAdmin();
                    productAdmin.setMa_sp(ma_sp);
                    productAdmin.setTen_sp(resultSet.getString("ten_sp"));
                    productAdmin.setNgay_tao(new DateTime(resultSet.getString("ngay_tao")));
                    productAdmin.setGioi_tinh(resultSet.getInt("gioi_tinh"));
                    productAdmin.setTon_tai(resultSet.getInt("ton_tai"));
                    productAdmin.setTrang_thai(resultSet.getInt("trang_thai"));
                    ProductAdminManufacturer productAdminManufacturer = new ProductAdminManufacturer();
                    productAdminManufacturer.setId(resultSet.getString("ma_hsx"));
                    productAdminManufacturer.setName(resultSet.getString("ten_hsx"));
                    productAdmin.setHang_san_xuat(productAdminManufacturer);
                    ProductAdminCategory productAdminCategory = new ProductAdminCategory();
                    productAdminCategory.setId(resultSet.getString("ma_dm"));
                    productAdminCategory.setName(resultSet.getString("ten_dm"));
                    productAdmin.setDanh_muc(productAdminCategory);
                    productAdmin.setGia_sp(resultSet.getInt("gia_sp"));
                    ma_sp_hien_tai = ma_sp;
                    products.add(productAdmin);
                }

                String ma_mau = resultSet.getString("ma_mau");
                String ma_size = resultSet.getString("ma_size");
                int so_luong_con_lai = resultSet.getInt("so_luong_con_lai");
                int hinh_anh_trong_firebase = resultSet.getInt("hinh_anh_trong_firebase");

                for(ProductAdmin productAdmin : products){
                    if(productAdmin.getMa_sp().equals(ma_sp)){
                        boolean check = false;
                        for(ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()){
                            if(productAdminColor.getMa_mau().equals(ma_mau) ){
                                check =true;
                                ProductAdminSize productAdminSize = new ProductAdminSize();
                                productAdminSize.setId(ma_size);
                                productAdminSize.setName(resultSet.getString("ten_size"));
                                productAdminSize.setSo_luong_con_lai(so_luong_con_lai);
                                productAdminColor.getDanh_sach_size().add(productAdminSize);
                                break;
                            }
                        }
                        if(!check){
                            ProductAdminColor productAdminColor = new ProductAdminColor();
                            productAdminColor.setMa_mau(ma_mau);
                            productAdminColor.setTen_mau(resultSet.getString("ten_mau"));
                            productAdminColor.setHinh_anh_mau(resultSet.getString("link_hinh_anh"));
                            productAdminColor.setHinH_anh_trong_firebase(hinh_anh_trong_firebase);
                            ProductAdminSize productAdminSize = new ProductAdminSize();
                            productAdminSize.setId(ma_size);
                            productAdminSize.setName(resultSet.getString("ten_size"));
                            productAdminSize.setSo_luong_con_lai(so_luong_con_lai);
                            productAdminColor.getDanh_sach_size().add(productAdminSize);
                            productAdmin.getDanh_sach_mau().add(productAdminColor);
                            break;
                        }else{
                            break;
                        }
                    }
                }
            }
            resultSet.close();
            preparedStatement.close();

       } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void addToDatabae(String ma_sp, List<ProductAdminColorAddProduct> listColor, List<ProductAdminSizeAdd> listSize){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO thong_tin_chi_tiet_sp VALUES(?,?,?,?,?,?)");
            for(ProductAdminColorAddProduct productAdminColorAdd : listColor){
                for(ProductAdminSizeAdd productAdminSize : listSize){
                    preparedStatement.setString(1,ma_sp);
                    preparedStatement.setString(2,productAdminColorAdd.getMa_mau());
                    preparedStatement.setString(3,productAdminSize.getId());
                    preparedStatement.setInt(4,0);
                    preparedStatement.setInt(5,1);
                    preparedStatement.setInt(6,productAdminColorAdd.getList_hinh_anh_sp().size());
                    preparedStatement.executeUpdate();
                }
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

}
