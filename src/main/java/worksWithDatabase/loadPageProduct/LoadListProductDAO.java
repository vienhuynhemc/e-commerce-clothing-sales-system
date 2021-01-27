package worksWithDatabase.loadPageProduct;

import beans.DateTime;
import beans.account.ConvertDate;
import beans.product.*;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoadListProductDAO {

    private int sumProduct;
    private int numPage;
    private ArrayList<Product> listProduct;


    public LoadListProductDAO() {
        listProduct = new ArrayList<Product>();

    }

    public void loadProduct(int trang,int xem,String type,String xeptheo,String danhmuc,String mau
    , double gia,String size,String search){

//        System.out.println(trang);
//        System.out.println(xem);
//        System.out.println(type);
//        System.out.println(xeptheo);
//        System.out.println(danhmuc);
//        System.out.println(mau);
//        System.out.println(gia);
//        System.out.println(size);
//        System.out.println("s " + search);



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
            String sql = "SELECT DISTINCT sp.ma_sp,sp.ten_sp,sp.ma_hsx,sp.ma_dm,sp.ngay_tao,sp.gioi_tinh,sp.trang_thai,sp.so_luong_ban_ra,sp.ton_tai,dm.ten_dm FROM san_pham sp, gia_sp gia, thong_tin_chi_tiet_sp tt, hang_san_xuat hsx,danh_muc dm\n" +
                    " WHERE sp.ma_sp = tt.ma_sp and sp.ma_hsx = hsx.ma_hsx and sp.ma_dm = dm.ma_dm and sp.ma_sp = gia.ma_sp and sp.gioi_tinh = ? and tt.ton_tai = 1 and sp.ton_tai = 1";


            if(!danhmuc.equals("nocategory")){
                sql += " and sp.ma_dm = \"" + danhmuc +"\" ";
            }

            if(!mau.equals("nocolor")){
                sql += " and tt.ma_mau = \"" + mau +"\" ";

            }

            if (!size.equals("nosize")){
                sql += " and tt.ma_size = \"" + size + "\" ";
            }

            if(gia == 0){
                sql += " and gia.gia_sp > 0";
            }else{

                sql += " and gia.gia_sp > 0 and gia.gia_sp < " + gia +" ";
            }

            boolean check = false;
            if (!search.equals("")){
                sql += " and (sp.ten_sp LIKE ? " +
                        " or hsx.ten_hsx Like ? " +
                        " or dm.ten_dm like ? " +
                        " or gia.gia_sp > ? )";
                check = true;
            }
            if (!xeptheo.equals("mac-dinh")){
                switch (xeptheo){
                    case "ten_sp":
                        sql += " Order By sp." + xeptheo + " ASC ";
                        break;
                    case "ngay_tao":
                        sql += " Order By sp." + xeptheo + " ASC ";
                        break;
                    case "gia":
                        sql += " ORDER BY gia.gia_sp ASC ";
                        break;
                    default:
                        sql += " Order By sp." + xeptheo + " ASC ";
                        break;
                }
            }


            String sql1 = new String(sql);

            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1,sex);

            if(check){
                ps1.setString(2, "%" + search + "%");
                ps1.setString(3, "%" + search + "%");
                ps1.setString(4, "%" + search + "%");

                try {
                    double giapsp = Double.parseDouble(search);
                    ps1.setDouble(5, giapsp);
                }catch (Exception e){
                    ps1.setDouble(5, Integer.MAX_VALUE);
                }


            }

            ResultSet rs1 = ps1.executeQuery();

            rs1.last();
            sumProduct = rs1.getRow();
            rs1.close();
            ps1.close();


            if(sumProduct%xem != 0){
                setNumPage((int) (sumProduct/xem) +1);
            }else{
                setNumPage( sumProduct/xem);
            }


            sql += " limit ?,? ";


            int start = (trang-1)*xem;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,sex);

            if(check){
                ps.setString(2, "%" + search + "%");
                ps.setString(3, "%" + search + "%");
                ps.setString(4, "%" + search + "%");
                try {
                    double giapsp = Double.parseDouble(search);
                    ps.setDouble(5, giapsp);
                }catch (Exception e){

                    ps.setDouble(5, Integer.MAX_VALUE);
                }
                ps.setInt(6,start);
                ps.setInt(7,xem);

            }else{
                ps.setInt(2,start);
                ps.setInt(3,xem);
            }


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
                p.setCategoryName(rs.getString(10));
               listProduct.add(p);
            }
            rs.close();
            ps.close();



            String sqlImg = "SELECT DISTINCT hinh.ma_sp,hinh.ma_mau,hinh.link_hinh_anh,hinh.mac_dinh FROM " +
                    "hinh_anh_sp hinh, san_pham sp, thong_tin_chi_tiet_sp tt" +
                    " WHERE hinh.ma_sp = sp.ma_sp and sp.ma_sp = tt.ma_sp " +
                    "and tt.ma_mau = hinh.ma_mau and sp.ma_sp = ? and tt.ton_tai = 1 and sp.ton_tai = 1";

            for (int i = 0; i < listProduct.size(); i++) {
                PreparedStatement ps2 = con.prepareStatement(sqlImg);
                ps2.setString(1,listProduct.get(i).getMa_sp());

                ResultSet rs2 = ps2.executeQuery();

                ArrayList<ProductImage> listI = new ArrayList<ProductImage>();
                while (rs2.next()){
                    listI.add(new ProductImage(rs2.getString(1),rs2.getString(2)
                    ,rs2.getString(3),rs2.getInt(4)));
                }
               listProduct.get(i).setListIMG(listI);
                rs2.close();
                ps2.close();
            }

            String sqlInfo = "SELECT * from thong_tin_sp tt WHERE tt.ma_sp = ?";
            for (int i = 0; i < listProduct.size(); i++) {
                PreparedStatement ps2 = con.prepareStatement(sqlInfo);
                ps2.setString(1,listProduct.get(i).getMa_sp());

                ResultSet rs2 = ps2.executeQuery();

                ArrayList<ProductInfomation> listInfo = new ArrayList<ProductInfomation>();
                while (rs2.next()){
                    listInfo.add(new ProductInfomation(rs2.getString(1),rs2.getString(2)));
                }
                listProduct.get(i).setListInfo(listInfo);
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

            String sqlsoluongconlai = "SELECT SUM(tt.so_luong_con_lai) FROM thong_tin_chi_tiet_sp tt WHERE tt.ma_sp = ? and tt.ton_tai = 1 GROUP BY tt.ma_sp";
            for (int i = 0; i < listProduct.size(); i++) {
                PreparedStatement ps2 = con.prepareStatement(sqlsoluongconlai);
                ps2.setString(1,listProduct.get(i).getMa_sp());

                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()){
                    listProduct.get(i).setSo_luong_con_lai(rs2.getInt(1));
                }
                rs2.close();
                ps2.close();
            }

            DataSource.getInstance().releaseConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
        }
    }

    public int getSumProduct() {
        return sumProduct;
    }

    public void setSumProduct(int sumProduct) {
        this.sumProduct = sumProduct;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }


    public static void main(String[] args) {
        LoadListProductDAO loadListProductDAO = new LoadListProductDAO();
        loadListProductDAO.loadProduct(1,6,"Nu","mac-dinh","nocategory",
                "nocolor",0,"nosize","");

        for (int i = 0; i < loadListProductDAO.getListProduct().size(); i++) {
            System.out.println(loadListProductDAO.getListProduct().get(i));
            System.out.println(loadListProductDAO.getListProduct().get(i).getListIMG());
            System.out.println(loadListProductDAO.getListProduct().get(i).getListInfo());
            System.out.println( "slcl" +  loadListProductDAO.getListProduct().get(i).getSo_luong_con_lai());

        }
//
//        System.out.println(loadListProductDAO.sumProduct);
//        System.out.println(loadListProductDAO.getNumPage());
//        System.out.println(loadListProductDAO.getListProduct().get(1).getListInfo().get(0).getThong_tin());
    }
}
