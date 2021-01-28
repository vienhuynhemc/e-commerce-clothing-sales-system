package model.nhapHang;

import beans.manufacturer.Manufacturer;
import worksWithDatabase.nhap_hang.DanhsachHSX;

import java.util.ArrayList;

public class DanhSachHangSanXuat {

    private static DanhSachHangSanXuat logOutModel;

    public static DanhSachHangSanXuat getInstance(){
        if(logOutModel == null){
            return new DanhSachHangSanXuat();
        }
        return logOutModel;
    }

    public ArrayList<Manufacturer> laodManufacturer(){
        return new DanhsachHSX().laodManufacturer();

    }

}
