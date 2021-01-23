package worksWithDatabase.checkout;

import beans.account.ConvertDate;
import beans.discountCode.DiscountCode;
import connectionDatabase.DataSource;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PromoPay {

    public PromoPay() {
    }

    public double priceAfter(double giatien,String ma_km){

        DiscountCode code = null;

        double result;

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();


            String sql = "SELECT * from ma_giam_gia WHERE ma_nhap = ? and han_su_dung > CURRENT_TIMESTAMP and ton_tai = 1 and trang_thai_su_dung = 1\n" +
                    "and so_lan_su_dung < so_lan_su_dung_toi_da";


            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ma_km);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
            code = new DiscountCode(rs.getString("ma_mgg"),rs.getString("ma_nhap"), String.valueOf(rs.getInt("kieu_mgg")) ,rs.getInt("gia_tri")
            ,rs.getInt("so_lan_su_dung"),rs.getInt("so_lan_su_dung_toi_da"),rs.getInt("trang_thai_su_dung"),rs.getInt("ton_tai"),
                    ConvertDate.changeDate(rs.getString("ngay_tao")),ConvertDate.changeDate(rs.getString("han_su_dung")));
            }
            rs.close();
            ps.close();

            if(code != null){
                System.out.println("ok");
                // nếu mã là miễn phí vận chuyển thì trừ 70k
                if(code.getType().equals("0")){
                result = giatien - 70000;
                }else if(code.getType().equals("1")){
                    result = giatien - code.getValue();
                }else if (code.getType().equals("2")){

                    result = giatien - giatien*code.getValue()/100;
                }else{
                    result = giatien;
                }
            }else{
                result = giatien;
            }
            DataSource.getInstance().releaseConnection(con);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return giatien;
        }
    }

    public static void main(String[] args) {
        PromoPay promoPay = new PromoPay();

        System.out.println(promoPay.priceAfter(200000,"P2UIDEK3J"));

    }

}
