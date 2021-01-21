package model.staff;

import worksWithDatabase.staff.StaffDataSource;
import worksWithDatabase.staff.StaffWorksWithDatabase;

import java.util.List;

public class StaffModel {

    //  Tạo thể hiện cho lớp
    private static StaffModel staffModel;

    //  Phương thức lấy thể hiện
    public static StaffModel getInstance() {

        //  Kiểm tra xem thể hiện có null hay không, null thì tạo mới
        if (staffModel == null) {
            staffModel = new StaffModel();
        }

        //  Trả về thể hiện
        return staffModel;
    }

    //  Phương thức lấy danh sách mã nhân viên có cấp độ là 0 (admin)
    public List<String> getAllAdmin() {
        StaffWorksWithDatabase staffWorksWithDatabase = StaffDataSource.getInstance().getStaffWorksWithDatabase();
        List<String> result = staffWorksWithDatabase.getAllAdmin();
        StaffDataSource.getInstance().releaseStaffWorksWithDatabase(staffWorksWithDatabase);
        return result;
    }

    //  Phương thức nhận vô mã nhân viên và giới thiệu, cập nhập lại
    public void updateIntroductById(String ma_nv,String gioi_thieu){
        StaffWorksWithDatabase staffWorksWithDatabase = StaffDataSource.getInstance().getStaffWorksWithDatabase();
        staffWorksWithDatabase.updateIntroductById(ma_nv,gioi_thieu);
        StaffDataSource.getInstance().releaseStaffWorksWithDatabase(staffWorksWithDatabase);
    }

    //  Phương thức nhận vô mã nhân viên và số hình ảnh trong firebase
    public void updateNumberOfPictureInFirebaseById(String ma_nv,int hinh_anh_trong_firebase){
        StaffWorksWithDatabase staffWorksWithDatabase = StaffDataSource.getInstance().getStaffWorksWithDatabase();
        staffWorksWithDatabase.updateNumberOfPictureInFirebaseById(ma_nv,hinh_anh_trong_firebase);
        StaffDataSource.getInstance().releaseStaffWorksWithDatabase(staffWorksWithDatabase);
    }

}
