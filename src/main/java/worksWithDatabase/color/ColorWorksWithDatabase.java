package worksWithDatabase.color;

import beans.BeansConfiguration;
import beans.DateTime;
import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import beans.productAdmin.*;
import beans.quanLyDonHang.KhachHangDatHang;
import beans.quanLyDonHang.NguoiXuLyQuanLyDonHang;
import beans.quanLyDonHang.QuanLyDonHang;
import beans.quanLyDonHang.SanPhamDatHang;
import connectionDatabase.DataSource;
import model.commune.CommuneModel;
import model.district.DistrictModel;
import model.provincial.ProvincialModel;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColorWorksWithDatabase {

    public ColorWorksWithDatabase() {

    }

    public void fillNameAndImgColorListProductAdmin(List<ProductAdmin> products) {

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mau WHERE ma_mau = ?");
            for (ProductAdmin productAdmin : products) {
                for (ProductAdminColor productAdminColor : productAdmin.getDanh_sach_mau()) {
                    preparedStatement.setString(1, productAdminColor.getMa_mau());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    productAdminColor.setTen_mau(resultSet.getString("ten_mau"));
                    productAdminColor.setHinh_anh_mau(resultSet.getString("link_hinh_anh"));
                    resultSet.close();
                }
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public List<ProductAdminColorAdd> getAllColor() {

        List<ProductAdminColorAdd> result = new ArrayList<ProductAdminColorAdd>();

        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mau");
            while (resultSet.next()) {
                ProductAdminColorAdd productAdminColorAdd = new ProductAdminColorAdd();
                productAdminColorAdd.setHinh_anh_mau(resultSet.getString("link_hinh_anh"));
                productAdminColorAdd.setMa_mau(resultSet.getString("ma_mau"));
                productAdminColorAdd.setTen_mau(resultSet.getString("ten_mau"));
                result.add(productAdminColorAdd);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phương thức lấy mã màu tiéptheo
    public String getNextId() {

        String result = "";
        Connection connection = DataSource.getInstance().getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(ma_mau) AS so_luong FROM mau");
            resultSet.next();
            result = "mau_" + (resultSet.getInt("so_luong") + 1);
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;

    }

    //   phuong thuc them vo csdl
    public boolean addToDatabase(String ma_mau, String ten_mau, String link_hinh_anh) {

        boolean result = false;
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mau VALUES (?,?,?)");
            preparedStatement.setString(1, ma_mau);
            preparedStatement.setString(2, ten_mau);
            preparedStatement.setString(3, link_hinh_anh);
            int row = preparedStatement.executeUpdate();
            if (row == 1) result = true;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return result;
    }

    //  Phuowng thuc tra ve productadmincoloradd
    public ProductAdminColorAdd getProductAdminColorAddById(String ma_mau){

        ProductAdminColorAdd productAdminColorAdd = new ProductAdminColorAdd();
        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mau WHERE ma_mau = ?");
            preparedStatement.setString(1,ma_mau);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            productAdminColorAdd.setTen_mau(resultSet.getString("ten_mau"));
            productAdminColorAdd.setMa_mau(resultSet.getString("ma_mau"));
            productAdminColorAdd.setHinh_anh_mau(resultSet.getString("link_hinh_anh"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return productAdminColorAdd;

    }

    public void fillNameColorForProductAdminSingle(ProductAdminEditSingle productAdminEditSingle){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_mau FROM mau WHERE ma_mau = ?");
            preparedStatement.setString(1,productAdminEditSingle.getMa_mau());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            productAdminEditSingle.setTen_mau(resultSet.getString("ten_mau"));
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillDataProductAdminEditGroup(ProductAdminAdd productAdminAdd){

        Connection connection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ten_mau,link_hinh_anh FROM mau WHERE ma_mau = ?");
            for(ProductAdminColorAddProduct productAdminColorAddProduct : productAdminAdd.getList_mau_kem_hinh_anh()){
                preparedStatement.setString(1,productAdminColorAddProduct.getMa_mau());
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                productAdminColorAddProduct.setTen_mau(resultSet.getString("ten_mau"));
                productAdminColorAddProduct.setLink_hinh_anh(resultSet.getString("link_hinh_anh"));
                resultSet.close();
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillDonHangNVK(List<QuanLyDonHang> list,String selectSearchAndSort,String search,String sort,int nowPage,String ma_nvk){

        Connection connection = DataSource.getInstance().getConnection();

        int limitLine = (nowPage-1)* 6;
        if(limitLine<0) limitLine = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM don_hang WHERE "+selectSearchAndSort+" LIKE ? AND ma_nvk = ? ORDER BY "+selectSearchAndSort+" "+sort+" LIMIT "+ limitLine+",6");
            preparedStatement.setString(1,"%"+search+"%");
            preparedStatement.setString(2,ma_nvk);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                QuanLyDonHang quanLyDonHang = new QuanLyDonHang();
                quanLyDonHang.setMa_dh(resultSet.getString("ma_don_hang"));
                KhachHangDatHang kh = new KhachHangDatHang();
                kh.setMa_kh(resultSet.getString("ma_khach_hang"));
                quanLyDonHang.setNguoi_dat(kh);
                quanLyDonHang.setNgay_dat(new DateTime(resultSet.getString("ngay_tao")));
                String ngay_giao = resultSet.getString("ngay_giao_hang");
                if(ngay_giao != null){
                    quanLyDonHang.setNgay_gui(new DateTime(ngay_giao));
                }
                String ma_admin = resultSet.getString("ma_admin");
                if(ma_admin != null){
                    KhachHangDatHang admin = new KhachHangDatHang();
                    admin.setMa_kh(ma_admin);
                    quanLyDonHang.setNguoi_duyet(admin);
                    quanLyDonHang.setNgay_duyet(new DateTime(resultSet.getString("admin_duyet_don_hang")));
                }
                String nvk_dong_goi = resultSet.getString("nvK_dong_goi");
                if(nvk_dong_goi != null){
                    KhachHangDatHang nvk = new KhachHangDatHang();
                    nvk.setMa_kh(resultSet.getString("ma_nvk"));
                    quanLyDonHang.setNguoi_dong_goi(nvk);
                    quanLyDonHang.setNgay_dong_goi(new DateTime(nvk_dong_goi));
                }
                String nvgh_van_chuyen = resultSet.getString("nvgh_van_chuyen");
                if(nvgh_van_chuyen != null){
                    KhachHangDatHang nvgh = new KhachHangDatHang();
                    nvgh.setMa_kh(resultSet.getString("ma_nvgh"));
                    quanLyDonHang.setNguoi_van_chuyen(nvgh);
                    quanLyDonHang.setNgay_van_chuyen(new DateTime(nvgh_van_chuyen));
                }
                quanLyDonHang.setTrang_thai_van_chuyen(resultSet.getInt("trang_thai_van_chuyen"));
                quanLyDonHang.setTrang_thai_thanh_toan(resultSet.getInt("trang_thai_thanh_toan"));
                quanLyDonHang.setTong_tien(resultSet.getInt("tong_tien"));

                PreparedStatement p = connection.prepareStatement("SELECT * FROM tai_khoan WHERE ma_tai_khoan = ?");
                p.setString(1,quanLyDonHang.getNguoi_dat().getMa_kh());
                ResultSet r = p.executeQuery();
                r.next();
                quanLyDonHang.getNguoi_dat().setEmail(r.getString("email"));
                quanLyDonHang.getNguoi_dat().setLink_hinh(r.getString("link_hinh_dai_dien"));
                quanLyDonHang.getNguoi_dat().setTen_kh(r.getString("ten_hien_thi"));
                quanLyDonHang.getNguoi_dat().setSo_dien_thoai(r.getString("so_dien_thoai"));
                r.close();
                PreparedStatement dc = connection.prepareStatement("SELECT * FROM dia_chi_nhan_hang WHERE ma_don_hang = ?");
                dc.setString(1,quanLyDonHang.getMa_dh());
                ResultSet r3 = dc.executeQuery();
                r3.next();
                Provincial provincial = ProvincialModel.getInstance().getProvincialById(r3.getString("ma_tinh"));
                District district = DistrictModel.getInstance().getDistrictById(r3.getString("ma_huyen"));
                Commune commune = CommuneModel.getInstance().getCommuneById(r3.getString("ma_xa"));
                quanLyDonHang.getNguoi_dat().setDia_chi(provincial.getProvincialName()+", "+district.getDistrictName()+", "+commune.getCommuneName());
                r3.close();
                dc.close();

                if(quanLyDonHang.getNguoi_duyet() != null){
                    p.setString(1,quanLyDonHang.getNguoi_duyet().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_duyet().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_duyet().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_duyet().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_duyet().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_duyet().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_duyet().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                if(quanLyDonHang.getNguoi_dong_goi() != null){
                    p.setString(1,quanLyDonHang.getNguoi_dong_goi().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_dong_goi().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_dong_goi().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_dong_goi().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_dong_goi().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_dong_goi().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_dong_goi().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                if(quanLyDonHang.getNguoi_van_chuyen() != null){
                    p.setString(1,quanLyDonHang.getNguoi_van_chuyen().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_van_chuyen().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_van_chuyen().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_van_chuyen().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_van_chuyen().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_van_chuyen().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_van_chuyen().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                p = connection.prepareStatement("SELECT * FROM chi_tiet_don_hang WHERE ma_don_hang = ?");
                p.setString(1,quanLyDonHang.getMa_dh());
                r = p.executeQuery();
                List<SanPhamDatHang> listsp = new ArrayList<SanPhamDatHang>();
                while(r.next()){
                    SanPhamDatHang sanPhamDatHang = new SanPhamDatHang();
                    sanPhamDatHang.setMa_sp(r.getString("ma_san_pham"));
                    sanPhamDatHang.setMa_mau(r.getString("ma_mau"));
                    sanPhamDatHang.setSo_luong(r.getInt("so_luong_san_pham"));

                    PreparedStatement p1 = connection.prepareStatement("SELECT * FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ? LIMIT 0,1");
                    p1.setString(1,sanPhamDatHang.getMa_sp());
                    p1.setString(2,sanPhamDatHang.getMa_mau());
                    ResultSet r2 = p1.executeQuery();
                    r2.next();
                    sanPhamDatHang.setHinh_anh(r2.getString("link_hinh_anh"));
                    r2.close();
                    p1 = connection.prepareStatement("SELECT g.gia_km,s.ten_sp FROM gia_sp_khuyen_mai g JOIN san_pham s ON g.ma_sp = s.ma_sp WHERE g.ma_sp = ? ORDER BY g.ngay_cap_nhat DESC LIMIT 0,1");
                    p1.setString(1,sanPhamDatHang.getMa_sp());
                    r2 = p1.executeQuery();
                    r2.next();
                    sanPhamDatHang.setTen_sp(r2.getString("ten_sp"));
                    int gia_km = r2.getInt("gia_km");
                    r2.close();
                    if(gia_km == 0){
                        p1 = connection.prepareStatement("SELECT * FROM gia_sp WHERE ma_sp = ? ORDER BY ngay_cap_nhat DESC LIMIT 0,1");
                        p1.setString(1,sanPhamDatHang.getMa_sp());
                        r2 = p1.executeQuery();
                        r2.next();
                        int gia_sp = r2.getInt("gia_sp");
                        sanPhamDatHang.setGia_le(gia_sp);
                        sanPhamDatHang.setTong_gia(gia_sp*sanPhamDatHang.getSo_luong());
                    }else{
                        sanPhamDatHang.setGia_le(gia_km);
                        sanPhamDatHang.setTong_gia(gia_km*sanPhamDatHang.getSo_luong());
                    }
                    listsp.add(sanPhamDatHang);
                }
                quanLyDonHang.setList_sp(listsp);
                r.close();
                list.add(quanLyDonHang);
            }
            resultSet.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillDonHangNVGH(List<QuanLyDonHang> list,String selectSearchAndSort,String search,String sort,int nowPage,String ma_nvgh){

        Connection connection = DataSource.getInstance().getConnection();

        int limitLine = (nowPage-1)* 6;
        if(limitLine<0) limitLine = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM don_hang WHERE "+selectSearchAndSort+" LIKE ? AND ma_nvgh = ? ORDER BY "+selectSearchAndSort+" "+sort+" LIMIT "+ limitLine+",6");
            preparedStatement.setString(1,"%"+search+"%");
            preparedStatement.setString(2,ma_nvgh);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                QuanLyDonHang quanLyDonHang = new QuanLyDonHang();
                quanLyDonHang.setMa_dh(resultSet.getString("ma_don_hang"));
                KhachHangDatHang kh = new KhachHangDatHang();
                kh.setMa_kh(resultSet.getString("ma_khach_hang"));
                quanLyDonHang.setNguoi_dat(kh);
                quanLyDonHang.setNgay_dat(new DateTime(resultSet.getString("ngay_tao")));
                String ngay_giao = resultSet.getString("ngay_giao_hang");
                if(ngay_giao != null){
                    quanLyDonHang.setNgay_gui(new DateTime(ngay_giao));
                }
                String ma_admin = resultSet.getString("ma_admin");
                if(ma_admin != null){
                    KhachHangDatHang admin = new KhachHangDatHang();
                    admin.setMa_kh(ma_admin);
                    quanLyDonHang.setNguoi_duyet(admin);
                    quanLyDonHang.setNgay_duyet(new DateTime(resultSet.getString("admin_duyet_don_hang")));
                }
                String nvk_dong_goi = resultSet.getString("nvK_dong_goi");
                if(nvk_dong_goi != null){
                    KhachHangDatHang nvk = new KhachHangDatHang();
                    nvk.setMa_kh(resultSet.getString("ma_nvk"));
                    quanLyDonHang.setNguoi_dong_goi(nvk);
                    quanLyDonHang.setNgay_dong_goi(new DateTime(nvk_dong_goi));
                }
                String nvgh_van_chuyen = resultSet.getString("nvgh_van_chuyen");
                if(nvgh_van_chuyen != null){
                    KhachHangDatHang nvgh = new KhachHangDatHang();
                    nvgh.setMa_kh(resultSet.getString("ma_nvgh"));
                    quanLyDonHang.setNguoi_van_chuyen(nvgh);
                    quanLyDonHang.setNgay_van_chuyen(new DateTime(nvgh_van_chuyen));
                }
                quanLyDonHang.setTrang_thai_van_chuyen(resultSet.getInt("trang_thai_van_chuyen"));
                quanLyDonHang.setTrang_thai_thanh_toan(resultSet.getInt("trang_thai_thanh_toan"));
                quanLyDonHang.setTong_tien(resultSet.getInt("tong_tien"));

                PreparedStatement p = connection.prepareStatement("SELECT * FROM tai_khoan WHERE ma_tai_khoan = ?");
                p.setString(1,quanLyDonHang.getNguoi_dat().getMa_kh());
                ResultSet r = p.executeQuery();
                r.next();
                quanLyDonHang.getNguoi_dat().setEmail(r.getString("email"));
                quanLyDonHang.getNguoi_dat().setLink_hinh(r.getString("link_hinh_dai_dien"));
                quanLyDonHang.getNguoi_dat().setTen_kh(r.getString("ten_hien_thi"));
                quanLyDonHang.getNguoi_dat().setSo_dien_thoai(r.getString("so_dien_thoai"));
                r.close();
                PreparedStatement dc = connection.prepareStatement("SELECT * FROM dia_chi_nhan_hang WHERE ma_don_hang = ?");
                dc.setString(1,quanLyDonHang.getMa_dh());
                ResultSet r3 = dc.executeQuery();
                r3.next();
                Provincial provincial = ProvincialModel.getInstance().getProvincialById(r3.getString("ma_tinh"));
                District district = DistrictModel.getInstance().getDistrictById(r3.getString("ma_huyen"));
                Commune commune = CommuneModel.getInstance().getCommuneById(r3.getString("ma_xa"));
                quanLyDonHang.getNguoi_dat().setDia_chi(provincial.getProvincialName()+", "+district.getDistrictName()+", "+commune.getCommuneName());
                r3.close();
                dc.close();

                if(quanLyDonHang.getNguoi_duyet() != null){
                    p.setString(1,quanLyDonHang.getNguoi_duyet().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_duyet().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_duyet().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_duyet().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_duyet().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_duyet().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_duyet().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                if(quanLyDonHang.getNguoi_dong_goi() != null){
                    p.setString(1,quanLyDonHang.getNguoi_dong_goi().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_dong_goi().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_dong_goi().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_dong_goi().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_dong_goi().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_dong_goi().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_dong_goi().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                if(quanLyDonHang.getNguoi_van_chuyen() != null){
                    p.setString(1,quanLyDonHang.getNguoi_van_chuyen().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_van_chuyen().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_van_chuyen().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_van_chuyen().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_van_chuyen().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_van_chuyen().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_van_chuyen().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                p = connection.prepareStatement("SELECT * FROM chi_tiet_don_hang WHERE ma_don_hang = ?");
                p.setString(1,quanLyDonHang.getMa_dh());
                r = p.executeQuery();
                List<SanPhamDatHang> listsp = new ArrayList<SanPhamDatHang>();
                while(r.next()){
                    SanPhamDatHang sanPhamDatHang = new SanPhamDatHang();
                    sanPhamDatHang.setMa_sp(r.getString("ma_san_pham"));
                    sanPhamDatHang.setMa_mau(r.getString("ma_mau"));
                    sanPhamDatHang.setSo_luong(r.getInt("so_luong_san_pham"));

                    PreparedStatement p1 = connection.prepareStatement("SELECT * FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ? LIMIT 0,1");
                    p1.setString(1,sanPhamDatHang.getMa_sp());
                    p1.setString(2,sanPhamDatHang.getMa_mau());
                    ResultSet r2 = p1.executeQuery();
                    r2.next();
                    sanPhamDatHang.setHinh_anh(r2.getString("link_hinh_anh"));
                    r2.close();
                    p1 = connection.prepareStatement("SELECT g.gia_km,s.ten_sp FROM gia_sp_khuyen_mai g JOIN san_pham s ON g.ma_sp = s.ma_sp WHERE g.ma_sp = ? ORDER BY g.ngay_cap_nhat DESC LIMIT 0,1");
                    p1.setString(1,sanPhamDatHang.getMa_sp());
                    r2 = p1.executeQuery();
                    r2.next();
                    sanPhamDatHang.setTen_sp(r2.getString("ten_sp"));
                    int gia_km = r2.getInt("gia_km");
                    r2.close();
                    if(gia_km == 0){
                        p1 = connection.prepareStatement("SELECT * FROM gia_sp WHERE ma_sp = ? ORDER BY ngay_cap_nhat DESC LIMIT 0,1");
                        p1.setString(1,sanPhamDatHang.getMa_sp());
                        r2 = p1.executeQuery();
                        r2.next();
                        int gia_sp = r2.getInt("gia_sp");
                        sanPhamDatHang.setGia_le(gia_sp);
                        sanPhamDatHang.setTong_gia(gia_sp*sanPhamDatHang.getSo_luong());
                    }else{
                        sanPhamDatHang.setGia_le(gia_km);
                        sanPhamDatHang.setTong_gia(gia_km*sanPhamDatHang.getSo_luong());
                    }
                    listsp.add(sanPhamDatHang);
                }
                quanLyDonHang.setList_sp(listsp);
                r.close();
                list.add(quanLyDonHang);
            }
            resultSet.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public void fillDonHang(List<QuanLyDonHang> list,String selectSearchAndSort,String search,String sort,int nowPage){

        Connection connection = DataSource.getInstance().getConnection();

        int limitLine = (nowPage-1)* 6;
        if(limitLine<0) limitLine = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM don_hang WHERE "+selectSearchAndSort+" LIKE ? ORDER BY "+selectSearchAndSort+" "+sort+" LIMIT "+ limitLine+",6");
            preparedStatement.setString(1,"%"+search+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                QuanLyDonHang quanLyDonHang = new QuanLyDonHang();
                quanLyDonHang.setMa_dh(resultSet.getString("ma_don_hang"));
                KhachHangDatHang kh = new KhachHangDatHang();
                kh.setMa_kh(resultSet.getString("ma_khach_hang"));
                quanLyDonHang.setNguoi_dat(kh);
                quanLyDonHang.setNgay_dat(new DateTime(resultSet.getString("ngay_tao")));
                String ngay_giao = resultSet.getString("ngay_giao_hang");
                if(ngay_giao != null){
                    quanLyDonHang.setNgay_gui(new DateTime(ngay_giao));
                }
                String ma_admin = resultSet.getString("ma_admin");
                if(ma_admin != null){
                    KhachHangDatHang admin = new KhachHangDatHang();
                    admin.setMa_kh(ma_admin);
                    quanLyDonHang.setNguoi_duyet(admin);
                    quanLyDonHang.setNgay_duyet(new DateTime(resultSet.getString("admin_duyet_don_hang")));
                }
                String nvk_dong_goi = resultSet.getString("nvK_dong_goi");
                if(nvk_dong_goi != null){
                    KhachHangDatHang nvk = new KhachHangDatHang();
                    nvk.setMa_kh(resultSet.getString("ma_nvk"));
                    quanLyDonHang.setNguoi_dong_goi(nvk);
                    quanLyDonHang.setNgay_dong_goi(new DateTime(nvk_dong_goi));
                }
                String nvgh_van_chuyen = resultSet.getString("nvgh_van_chuyen");
                if(nvgh_van_chuyen != null){
                    KhachHangDatHang nvgh = new KhachHangDatHang();
                    nvgh.setMa_kh(resultSet.getString("ma_nvgh"));
                    quanLyDonHang.setNguoi_van_chuyen(nvgh);
                    quanLyDonHang.setNgay_van_chuyen(new DateTime(nvgh_van_chuyen));
                }
                quanLyDonHang.setTrang_thai_van_chuyen(resultSet.getInt("trang_thai_van_chuyen"));
                quanLyDonHang.setTrang_thai_thanh_toan(resultSet.getInt("trang_thai_thanh_toan"));
                quanLyDonHang.setTong_tien(resultSet.getInt("tong_tien"));

                PreparedStatement p = connection.prepareStatement("SELECT * FROM tai_khoan WHERE ma_tai_khoan = ?");
                p.setString(1,quanLyDonHang.getNguoi_dat().getMa_kh());
                ResultSet r = p.executeQuery();
                r.next();
                quanLyDonHang.getNguoi_dat().setEmail(r.getString("email"));
                quanLyDonHang.getNguoi_dat().setLink_hinh(r.getString("link_hinh_dai_dien"));
                quanLyDonHang.getNguoi_dat().setTen_kh(r.getString("ten_hien_thi"));
                quanLyDonHang.getNguoi_dat().setSo_dien_thoai(r.getString("so_dien_thoai"));
                r.close();
                PreparedStatement dc = connection.prepareStatement("SELECT * FROM dia_chi_nhan_hang WHERE ma_don_hang = ?");
                dc.setString(1,quanLyDonHang.getMa_dh());
                ResultSet r3 = dc.executeQuery();
                r3.next();
                Provincial provincial = ProvincialModel.getInstance().getProvincialById(r3.getString("ma_tinh"));
                District district = DistrictModel.getInstance().getDistrictById(r3.getString("ma_huyen"));
                Commune commune = CommuneModel.getInstance().getCommuneById(r3.getString("ma_xa"));
                quanLyDonHang.getNguoi_dat().setDia_chi(provincial.getProvincialName()+", "+district.getDistrictName()+", "+commune.getCommuneName());
                r3.close();
                dc.close();

                if(quanLyDonHang.getNguoi_duyet() != null){
                    p.setString(1,quanLyDonHang.getNguoi_duyet().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_duyet().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_duyet().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_duyet().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_duyet().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_duyet().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_duyet().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                if(quanLyDonHang.getNguoi_dong_goi() != null){
                    p.setString(1,quanLyDonHang.getNguoi_dong_goi().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_dong_goi().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_dong_goi().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_dong_goi().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_dong_goi().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_dong_goi().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_dong_goi().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                if(quanLyDonHang.getNguoi_van_chuyen() != null){
                    p.setString(1,quanLyDonHang.getNguoi_van_chuyen().getMa_kh());
                    r = p.executeQuery();
                    r.next();
                    quanLyDonHang.getNguoi_van_chuyen().setEmail(r.getString("email"));
                    quanLyDonHang.getNguoi_van_chuyen().setLink_hinh(r.getString("link_hinh_dai_dien"));
                    quanLyDonHang.getNguoi_van_chuyen().setTen_kh(r.getString("ten_hien_thi"));
                    quanLyDonHang.getNguoi_van_chuyen().setSo_dien_thoai(r.getString("so_dien_thoai"));
                    r.close();

                    PreparedStatement cc = connection.prepareStatement("SELECT * FROM dia_chi WHERE ma_nv = ?");
                    cc.setString(1,quanLyDonHang.getNguoi_van_chuyen().getMa_kh());
                    ResultSet r4 = cc.executeQuery();
                    r4.next();
                    Provincial pro = ProvincialModel.getInstance().getProvincialById(r4.getString("ma_tinh"));
                    District dis = DistrictModel.getInstance().getDistrictById(r4.getString("ma_huyen"));
                    Commune com= CommuneModel.getInstance().getCommuneById(r4.getString("ma_xa"));
                    quanLyDonHang.getNguoi_van_chuyen().setDia_chi(pro.getProvincialName()+", "+dis.getDistrictName()+", "+com.getCommuneName());
                    r4.close();
                    cc.close();

                }
                p = connection.prepareStatement("SELECT * FROM chi_tiet_don_hang WHERE ma_don_hang = ?");
                p.setString(1,quanLyDonHang.getMa_dh());
                r = p.executeQuery();
                List<SanPhamDatHang> listsp = new ArrayList<SanPhamDatHang>();
                while(r.next()){
                    SanPhamDatHang sanPhamDatHang = new SanPhamDatHang();
                    sanPhamDatHang.setMa_sp(r.getString("ma_san_pham"));
                    sanPhamDatHang.setMa_mau(r.getString("ma_mau"));
                    sanPhamDatHang.setSo_luong(r.getInt("so_luong_san_pham"));

                    PreparedStatement p1 = connection.prepareStatement("SELECT * FROM hinh_anh_sp WHERE ma_sp = ? AND ma_mau = ? LIMIT 0,1");
                    p1.setString(1,sanPhamDatHang.getMa_sp());
                    p1.setString(2,sanPhamDatHang.getMa_mau());
                    ResultSet r2 = p1.executeQuery();
                    r2.next();
                    sanPhamDatHang.setHinh_anh(r2.getString("link_hinh_anh"));
                    r2.close();
                    p1 = connection.prepareStatement("SELECT g.gia_km,s.ten_sp FROM gia_sp_khuyen_mai g JOIN san_pham s ON g.ma_sp = s.ma_sp WHERE g.ma_sp = ? ORDER BY g.ngay_cap_nhat DESC LIMIT 0,1");
                    p1.setString(1,sanPhamDatHang.getMa_sp());
                    r2 = p1.executeQuery();
                    r2.next();
                    sanPhamDatHang.setTen_sp(r2.getString("ten_sp"));
                    int gia_km = r2.getInt("gia_km");
                    r2.close();
                    if(gia_km == 0){
                        p1 = connection.prepareStatement("SELECT * FROM gia_sp WHERE ma_sp = ? ORDER BY ngay_cap_nhat DESC LIMIT 0,1");
                        p1.setString(1,sanPhamDatHang.getMa_sp());
                        r2 = p1.executeQuery();
                        r2.next();
                        int gia_sp = r2.getInt("gia_sp");
                        sanPhamDatHang.setGia_le(gia_sp);
                        sanPhamDatHang.setTong_gia(gia_sp*sanPhamDatHang.getSo_luong());
                    }else{
                        sanPhamDatHang.setGia_le(gia_km);
                        sanPhamDatHang.setTong_gia(gia_km*sanPhamDatHang.getSo_luong());
                    }
                    listsp.add(sanPhamDatHang);
                }
                quanLyDonHang.setList_sp(listsp);
                r.close();
                list.add(quanLyDonHang);
            }
            resultSet.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);

    }

    public int getDonHangToiDa(String selectSearchAndSort,String search){
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS so_luong FROM don_hang WHERE "+selectSearchAndSort+" LIKE ?");
            preparedStatement.setString(1,"%"+search+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result =resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return  result;
    }

    public int getDonHangToiDaNVK(String selectSearchAndSort,String search,String ma_nvk){
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS so_luong FROM don_hang WHERE "+selectSearchAndSort+" LIKE ? AND ma_nvk = ?");
            preparedStatement.setString(1,"%"+search+"%");
            preparedStatement.setString(2,ma_nvk);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result =resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return  result;
    }

    public int getDonHangToiDaNVGH(String selectSearchAndSort,String search,String ma_nvgh){
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS so_luong FROM don_hang WHERE "+selectSearchAndSort+" LIKE ? AND ma_nvgh = ?");
            preparedStatement.setString(1,"%"+search+"%");
            preparedStatement.setString(2,ma_nvgh);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result =resultSet.getInt("so_luong");
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(connection);
        return  result;
    }

    public List<NguoiXuLyQuanLyDonHang> getListNvk(){
            List<NguoiXuLyQuanLyDonHang> list = new ArrayList<NguoiXuLyQuanLyDonHang>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT n.ma_nv,t.ten_hien_thi FROM nhan_vien n JOIN tai_khoan t ON n.ma_nv = t.ma_tai_khoan WHERE n.cap_do = 1");
            while(resultSet.next()){
                NguoiXuLyQuanLyDonHang n = new NguoiXuLyQuanLyDonHang();
                n.setId(resultSet.getString("ma_nv"));
                n.setName(resultSet.getString("ten_hien_thi"));
                list.add(n);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
    return list;
    }

    public List<NguoiXuLyQuanLyDonHang> getListNvgh(){
        List<NguoiXuLyQuanLyDonHang> list = new ArrayList<NguoiXuLyQuanLyDonHang>();
        Connection connection = DataSource.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT n.ma_nv,t.ten_hien_thi FROM nhan_vien n JOIN tai_khoan t ON n.ma_nv = t.ma_tai_khoan WHERE n.cap_do = 2");
            while(resultSet.next()){
                NguoiXuLyQuanLyDonHang n = new NguoiXuLyQuanLyDonHang();
                n.setId(resultSet.getString("ma_nv"));
                n.setName(resultSet.getString("ten_hien_thi"));
                list.add(n);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataSource.getInstance().releaseConnection(connection);
        return list;
    }

}
