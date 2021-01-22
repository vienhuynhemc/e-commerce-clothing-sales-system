package worksWithDatabase.address2;

import beans.address.Commune;
import beans.address.District;
import beans.address.Provincial;
import connectionDatabase.DataSource;

import java.sql.*;
import java.util.ArrayList;

public class LoadAddressDAO {
    public LoadAddressDAO() {
    }

    public ArrayList<Provincial> listProvincial(){

        ArrayList<Provincial> result = new ArrayList<Provincial>();
        
        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();

            
            String sql = "select * from tinh_thanh ";

            Statement sm = con.createStatement();

            ResultSet rs = sm.executeQuery(sql);

            while (rs.next()){
                result.add(new Provincial(rs.getString(1), rs.getString(2)));
            }
            
            rs.close();
            sm.close();

            DataSource.getInstance().releaseConnection(con);
            return result;
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return result;
        }
    }
    public ArrayList<District> listDistrictByID(String ma_tinh){
        ArrayList<District> result = new ArrayList<District>();

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();


            String sql = "select * from quan_huyen where ma_tinh_thanh = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ma_tinh);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                result.add(new District(rs.getString(1), rs.getString(2)));
            }

            rs.close();
            ps.close();

            DataSource.getInstance().releaseConnection(con);
            return result;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return result;
        }
    }
    public ArrayList<Commune> listCommuneID(String ma_quan_huyen){
        ArrayList<Commune> result = new ArrayList<Commune>();

        Connection con = null;
        try {
            con = DataSource.getInstance().getConnection();


            String sql = "select * from phuong_xa where ma_quan_huyen = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,ma_quan_huyen);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                result.add(new Commune(rs.getString(2), rs.getString(1)));
            }

            rs.close();
            ps.close();

            DataSource.getInstance().releaseConnection(con);
            return result;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return result;
        }
    }

    public static void main(String[] args) {
        LoadAddressDAO loadAddressDAO = new LoadAddressDAO();

      //  System.out.println(loadAddressDAO.listProvincial());
       // System.out.println(loadAddressDAO.listDistrictByID("01TTT"));
        System.out.println(loadAddressDAO.listCommuneID("001HH"));

    }

}
