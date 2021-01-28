package worksWithDatabase.checkout;

import beans.Address;
import beans.cart.Cart;
import connectionDatabase.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Pay {
    public Pay() {
    }

    public boolean pay(String ma_kh, String ghi_chu, String ma_gg, int trangthai, ArrayList<Cart> carts,double tongtien, String ma_tinh,String ma_huyen,String ma_xa){

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();

            Random rd = new Random();
             int n =  rd.nextInt(1000);
             int n1 = rd.nextInt(1000);

            String ma_dh = "dh_" + n + n1;

            String sqldh = "";


            // check thử 1 lượt coi còn số lượng trong kho k đã, nếu số lượng trong kho hết r` thì return false luôn;
            for (Cart c: carts ) {

                String slspcl = "Select so_luong_con_lai from thong_tin_chi_tiet_sp where ma_sp = ? and ma_mau = ? and ma_size = ? and ton_tai = 1";

                PreparedStatement ps5 = con.prepareStatement(slspcl);
                ps5.setString(1,c.getMa_sp());
                ps5.setString(2,c.getMa_mau());
                ps5.setString(3,c.getMa_size());

                ResultSet rs5 = ps5.executeQuery();

                int soluong = 0;
                if(rs5.next()){
                    soluong  = rs5.getInt(1);
                    rs5.close();
                    ps5.close();
                }else{
                   // System.out.println("ok2");
                    // nếu sp đó k tồn tại (có thể admin xóa sp), thì false
                    rs5.close();
                    ps5.close();
                    DataSource.getInstance().releaseConnection(con);
                    return false;
                }

                if(soluong < c.getSo_luong()) {
                    //System.out.println("ok3");
                    DataSource.getInstance().releaseConnection(con);
                    return false;
                }
            }


            // giảm số lượng sản phẩm xuống, làm cái này trc cho chắc cái đã, lỡ đâu đang tạo đơn hàng mà thằng khác mua thì toang
            for (Cart c: carts ) {

                // lấy số lượng sản phẩm đó còn lại trong database, xử lí trường họp người này chuẩn bị mua, nhưng người khác nhanh tay hơn mua trước
                String slspcl = "Select so_luong_con_lai from thong_tin_chi_tiet_sp where ma_sp = ? and ma_mau = ? and ma_size = ? and ton_tai = 1";

                PreparedStatement ps5 = con.prepareStatement(slspcl);
                ps5.setString(1,c.getMa_sp());
                ps5.setString(2,c.getMa_mau());
                ps5.setString(3,c.getMa_size());

                ResultSet rs5 = ps5.executeQuery();
                int soluong = 0;
                if(rs5.next()){
                   // System.out.println("ok1");
                   soluong  = rs5.getInt(1);
                    rs5.close();
                    ps5.close();
                }else{
                    //System.out.println("ok2");
                    // nếu sp đó k tồn tại (có thể admin xóa sp), thì false
                    rs5.close();
                    ps5.close();
                    DataSource.getInstance().releaseConnection(con);
                    return false;
                }

                // nếu số lượng sp trong giỏ hàng mà nhỏ hơn số lượng mua ?
                if(soluong < c.getSo_luong()){
                   // System.out.println("ok3");
                    DataSource.getInstance().releaseConnection(con);
                    return false;
                }else if (soluong >= c.getSo_luong()){
                    //System.out.println("ok4");
                    // nếu nhỏ hơn thì có thể mua, update lại số lượng
                    String sqlupdate = "Update thong_tin_chi_tiet_sp set so_luong_con_lai = ? where ma_sp = ? and ma_mau = ? and ma_size = ?";
                    PreparedStatement ps6 = con.prepareStatement(sqlupdate);
                    ps6.setInt(1,soluong - c.getSo_luong());
                    ps6.setString(2,c.getMa_sp());
                    ps6.setString(3,c.getMa_mau());
                    ps6.setString(4,c.getMa_size());

                    int n3 = ps6.executeUpdate();
                    if(n3 != 1){
                        DataSource.getInstance().releaseConnection(con);
                        return false;
                    }

                }

            }




            // nếu thanh toán online coi như sản phẩm đã mua rồi, thì phải sét lại giá trị sản phẩm đã mua trong bản sản phâm

            if(trangthai == 1){
                String soluonghientai = "select so_luong_ban_ra from san_pham where ma_sp = ? and trang_thai != 2 and ton_tai = 1";
                for ( Cart c: carts ) {

                    PreparedStatement ps8 = con.prepareStatement(soluonghientai);
                    ps8.setString(1,c.getMa_sp());
                    ResultSet rs8 = ps8.executeQuery();
                    int soluongdaban = 0;
                    if(rs8.next()){
                       soluongdaban = rs8.getInt(1);
                    }else{
                        DataSource.getInstance().releaseConnection(con);
                        return false;
                    }
                    rs8.close();
                    ps8.close();

                    String updatesp = "Update san_pham set so_luong_ban_ra = ? where ma_sp = ?";

                    PreparedStatement ps7 = con.prepareStatement(updatesp);
                    ps7.setInt(1,soluongdaban + c.getSo_luong());
                    ps7.setString(2,c.getMa_sp());

                  int c1 =  ps7.executeUpdate();

                  ps7.close();

                    if(c1 != 1){
                        DataSource.getInstance().releaseConnection(con);
                        return false;
                    }

                }
            }


            // nếu trang thái vận chuyển là online thì thanh toán luôn
            if (trangthai == 1) {
                sqldh = "INSERT INTO don_hang VALUES (?,?,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,70000,null,null,null,null,null,null,?,0,?,1,?)";

            }else {
                // nếu trạng thái vận chuyển là thanh toán khi nhận hàng
                sqldh = "INSERT INTO don_hang VALUES (?,?,CURRENT_TIMESTAMP, null,70000,null,null,null,null,null,null,?,0,?,0,?)";
            }

                PreparedStatement ps = con.prepareStatement(sqldh);
                ps.setString(1,ma_dh);
                ps.setString(2,ma_kh);
                ps.setString(3,ghi_chu);
                ps.setString(4,ma_gg);
                ps.setInt(5,(int)tongtien);

                int r1 = ps.executeUpdate();
                ps.close();

                // nếu thêm đơn hàng thành công
                if (r1 == 1){

                    // thì thêm vào bảng chi tiết đơn hàng các thông tin cần thiết

                String sqlct = "INSERT INTO chi_tiet_don_hang ";
                    Statement sm = con.createStatement();
                    String value = "VALUES ";
                    int count = 0;
                    for (Cart c: carts) {

                        if (count < carts.size() - 1){
                            value += " (\"" + ma_dh +"\",\""+c.getMa_sp() + "\",\"" + c.getMa_mau() + "\",\"" +c.getMa_size() + "\"," + c.getSo_luong()+ "),";
                        }else{
                            value += " (\"" + ma_dh +"\",\""+c.getMa_sp() + "\",\"" + c.getMa_mau() + "\",\"" +c.getMa_size() + "\"," + c.getSo_luong()+ ")";
                        }

                        count++;
                    }
//                    System.out.println(sqlct + value);
                    sm.executeUpdate(sqlct + value);

                    sm.close();

                    // sau khi thêm thành công thì thêm địa chỉ nhận hàng nữa

                    String sqldc = "INSERT INTO dia_chi_nhan_hang VALUES (?,?,?,?)";

                    PreparedStatement ps4 = con.prepareStatement(sqldc);
                    ps4.setString(1,ma_dh);
                    ps4.setString(2,ma_tinh);
                    ps4.setString(3,ma_huyen);
                    ps4.setString(4,ma_xa);
                    ps4.executeUpdate();
                    ps4.close();
                }else{
                    DataSource.getInstance().releaseConnection(con);
                    return false;
                }

                // tiếp theo là check mã giảm giá

            String sqlmm = "select * from ma_giam_gia where ma_nhap = ?";
            PreparedStatement ps10 = con.prepareStatement(sqlmm);

            ps10.setString(1,ma_gg);

            ResultSet rs10 = ps10.executeQuery();


            if (rs10.next()){

                int solansd = rs10.getInt("so_lan_su_dung");
                int solantoida = rs10.getInt("so_lan_su_dung_toi_da");

                rs10.close();
                ps10.close();

                String sqlmgg1 = "update ma_giam_gia set so_lan_su_dung = ? where ma_nhap = ?";

                if (solansd < solantoida){
                    PreparedStatement ps11 = con.prepareStatement(sqlmgg1);
                    ps11.setInt(1,solansd+1);
                    ps11.setString(2,ma_gg);
                    ps11.executeUpdate();
                    ps11.close();
                }


            }
            // tiếp theo là update lại tình trạng của sản phẩm
            String upsp = "select sum(so_luong_con_lai) from thong_tin_chi_tiet_sp where ";

            Statement sm1 = con.createStatement();

            for (Cart c: carts) {

                String up2 = "ma_sp = \"" +c.getMa_sp()+ "\" group by ma_sp";

                ResultSet rs2 = sm1.executeQuery(upsp+up2);

                rs2.next();
                int soluongup = rs2.getInt(1);

                // = 0 chứng tỏ hết hàng , thì set trang thái 2: hết hàng. để tránh ng khác zô mua nhầm
                if(soluongup == 0){
                    String sql = "update san_pham set trang_thai = 2 where ma_sp = ?";
                        PreparedStatement ps12 = con.prepareStatement(sql);
                        ps12.setString(1,c.getMa_sp());
                        ps12.executeUpdate();
                }
            }
            DataSource.getInstance().releaseConnection(con);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return false;
        }
    }

    public static void main(String[] args) {
        Pay pay = new Pay();

        Cart c = new Cart("sp_1","KH001","mau_1","size_1","ads","ao thun đẹp","S","DO",1,20000,30000);

        ArrayList<Cart> carts = new ArrayList<>();
        carts.add(c);

        System.out.println(pay.pay("KH001","Giao nhanh nha","KF12ADBVD",1,carts,200000,"dsd","sdDS","KHI"));

    }
}
