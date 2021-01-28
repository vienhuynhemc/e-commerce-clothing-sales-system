package worksWithDatabase.nhap_hang;

import beans.manufacturer.Manufacturer;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DanhsachHSX {

    public DanhsachHSX() {
    }

    public ArrayList<Manufacturer> laodManufacturer(){
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        Connection con = null;

        try {
            con = DataSource.getInstance().getConnection();

            String sql = "select * from hang_san_xuat";

            Statement sm = con.createStatement();

            ResultSet rs = sm.executeQuery(sql);

            while (rs.next()){

                Manufacturer m = new Manufacturer();

                m.setManufacturerId(rs.getString(1));
                m.setManufacturerName(rs.getString(2));

                manufacturers.add(m);


            }
            rs.close();
            sm.close();

            DataSource.getInstance().releaseConnection(con);
            return manufacturers;
        } catch (Exception e) {
            e.printStackTrace();
            DataSource.getInstance().releaseConnection(con);
            return manufacturers;
        }

    }

    public static void main(String[] args) {

        DanhsachHSX danhsachHSX = new DanhsachHSX();

        System.out.println(danhsachHSX.laodManufacturer());

    }


}
