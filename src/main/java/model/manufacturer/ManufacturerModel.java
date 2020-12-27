package model.manufacturer;

import beans.manufacturer.Manufacturer;

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

    //  Phương thức trả về list manufacturer ban đầu để đổ dữ liêu ra, lúc khởi tạo trang
    public List<Manufacturer> getListManufacturerFirst(int numberOfPage) {

        //  Khởi tạo list kết quả để trả về
        List<Manufacturer> resultList = new ArrayList<Manufacturer>();


        //  Trả về list kết quả
        return resultList;

    }


}