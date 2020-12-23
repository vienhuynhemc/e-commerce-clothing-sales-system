package worksWithDatabase;

import connectionDatabase.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryWorksWithDatabase {

    public CategoryWorksWithDatabase() {
    }

    public boolean check(String id) {

        Connection c = DataSource.getInstance().getConnection();

        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM danhmuc WHERE madanhmuc = ?");
            p.setString(1, id);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                DataSource.getInstance().releaseConnection(c);

                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataSource.getInstance().releaseConnection(c);
        return false;
    }

}
