package worksWithDatabase.loadPageHistory;

import beans.account.ConvertDate;
import beans.order.DetailOrder;
import beans.order.Order;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadListPayDAO {

    private int numPage;
    private int sumPage;

    public LoadListPayDAO() {
    }

    public ArrayList<Order> listOrder(String ma_kh,int page,String search){
        Connection con = null;
        ArrayList<Order> result = new ArrayList<Order>();
        try {
            con = DataSource.getInstance().getConnection();

            String sql = "select * from don_hang where ma_khach_hang = ? and ma_don_hang like ?";

            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setString(1,ma_kh);
            ps1.setString(2,"%"+search+"%");

            ResultSet rs1 = ps1.executeQuery();

            rs1.last();
            sumPage = rs1.getRow();
            rs1.close();
            ps1.close();

            if(sumPage%6 != 0){
                setNumPage((int) (sumPage/6) +1);
            }else{
                setNumPage(sumPage/6);
            }


            sql += " limit ?,?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ma_kh);
            ps.setString(2,"%"+search+"%");
            ps.setInt(3,(page-1)*6);
            ps.setInt(4,6);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){


                Order order = new Order();

                order.setMa_don_hang(rs.getString("ma_don_hang"));
                order.setMa_khach_hang(rs.getString("ma_khach_hang"));
                order.setNgay_tao(ConvertDate.changeDate(rs.getString("ngay_tao")));
                order.setNgay_giao_hang(ConvertDate.changeDate(rs.getString("ngay_giao_hang")));
                order.setPhi_van_chuyen((double) rs.getInt("phi_van_chuyen"));
                order.setNgay_admin_duyet(ConvertDate.changeDate(rs.getString("admin_duyet_don_hang")));
                order.setNgay_nvk_duyet(ConvertDate.changeDate(rs.getString("nvk_dong_goi")));
                order.setNgay_nvvc_duyet(ConvertDate.changeDate(rs.getString("nvgh_van_chuyen")));
                order.setMa_nvk(rs.getString("ma_nvk"));
                order.setMa_nvvc(rs.getString("ma_nvgh"));
                order.setMa_admin(rs.getString("ma_admin"));
                order.setGhi_chu(rs.getString("ghi_chu_don_hang"));
                order.setTrang_thai_van_chuyen(rs.getInt("trang_thai_van_chuyen"));
                order.setMa_giam_gia(rs.getString("ma_giam_gia"));
                order.setTrang_thai_thanh_toan(rs.getInt("trang_thai_thanh_toan"));
                order.setTong_tien(rs.getInt("tong_tien"));

                result.add(order);

            }

            rs.close();
            ps.close();


            String sql1 = "select * from chi_tiet_don_hang where ma_don_hang = ?";


            for (Order o: result ) {
                PreparedStatement ps2 = con.prepareStatement(sql1);
                ps2.setString(1,o.getMa_don_hang());

                ResultSet rs2 = ps2.executeQuery();

                while (rs2.next()){
                    DetailOrder detailOrder = new DetailOrder();

                    detailOrder.setMa_don_hang(rs2.getString("ma_don_hang"));
                    detailOrder.setMa_san_pham(rs2.getString("ma_san_pham"));
                    detailOrder.setMa_mau(rs2.getString("ma_mau"));
                    detailOrder.setMa_size(rs2.getString("ma_size"));
                    detailOrder.setSo_luong_san_pham(rs2.getInt("so_luong_san_pham"));
                    o.getListDetail().add(detailOrder);
                }
                rs2.close();
                ps2.close();

            }


            for (Order o: result ) {

                for ( DetailOrder d : o.getListDetail()) {

                }

                String sqlI = "SELECT DISTINCT hinh.ma_sp,hinh.ma_mau,hinh.link_hinh_anh,hinh.mac_dinh FROM \n" +
                        "hinh_anh_sp hinh,  thong_tin_chi_tiet_sp tt,chi_tiet_don_hang ct\n" +
                        " WHERE hinh.ma_sp = tt.ma_sp \n" +
                        "and tt.ma_mau = hinh.ma_mau and ct.ma_san_pham = tt.ma_sp \n" +
                        "and ct.ma_mau = tt.ma_mau and tt.ma_size = ct.ma_size\n" +
                        "and  tt.ma_sp = ? and tt.ma_mau = ? and tt.ma_size = ? and ct.ma_don_hang = ?";


            }

            DataSource.getInstance().releaseConnection(con);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return result;
        }

    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public int getSumPage() {
        return sumPage;
    }

    public void setSumPage(int sumPage) {
        this.sumPage = sumPage;
    }

    public static void main(String[] args) {
        LoadListPayDAO loadListPayDAO = new LoadListPayDAO();

//        System.out.println(loadListPayDAO.getSumPage());
//        System.out.println(loadListPayDAO.getNumPage());
        for (Order d: loadListPayDAO.listOrder("KH001",1,"don")) {

            System.out.println(d.getListDetail());

        }
    }
}
