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
}
