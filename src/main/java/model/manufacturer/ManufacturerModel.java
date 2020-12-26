package model.manufacturer;

import beans.manufacturer.Manufacturer;
import connectionDatabase.DataSource;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerModel {

    //  Tạo thể hiện cho lớp
    private static ManufacturerModel manufacturerModel;

    //  Phương thức lấy thể hiện
    public static ManufacturerModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (manufacturerModel == null) {
            manufacturerModel = new ManufacturerModel();
        }

        //  Trả về thể hiện
        return manufacturerModel;

    }

    //  Phương ứng nhận vào 2 số , 1 là số trang hiện tại, 2 là số dòng trên 1 trang trả về 1 list hãng sản xuất
    public List<Manufacturer> getListManufacturer(int lineNumberPerPage, int numberOfPage) {

        //  Khởi tạo list kết quả để trả về
        List<Manufacturer> resultList = new ArrayList<Manufacturer>();



        //  Trả về list kết quả
        return resultList;

    }

    public static void main(String[] args) {


    }
}