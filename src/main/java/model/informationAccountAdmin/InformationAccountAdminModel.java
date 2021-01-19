package model.informationAccountAdmin;

import model.importProduct.ImportProductModel;
import model.importProductInformation.ImportProductInformationModel;
import model.order.OrderModel;

import java.util.List;

public class InformationAccountAdminModel {

    private static InformationAccountAdminModel informationAccountAdminModel;

    public static InformationAccountAdminModel getInstance() {
        if (informationAccountAdminModel == null) {
            informationAccountAdminModel = new InformationAccountAdminModel();
        }
        return informationAccountAdminModel;
    }

    //  Phương thứcn nhân vô mã admin kiểm tra số đơn hàng đã được admin này duyệt
    public int getOrderApprovalByIdAdmin(String ma_admin){
        return OrderModel.getInstance().getOrderApprovalByIdAdmin(ma_admin);
    }

    //  Phương thức nhận vô mã nhân viên. trả về số lượng hàng đã nhập của nhân viên này
    public int getSumImportProductByListId(String ma_nv) {
        List<String> listIdImportProduct = ImportProductModel.getInstance().getAllImportProductByIdAdmin(ma_nv);
        int result = ImportProductInformationModel.getInstance().getSumImportProductByListId(listIdImportProduct);
        return result;
    }


    // phương thứuc nhận vào mã admin, kiểm tra xem admin này nhập mấy đơn hàng rồi
    public int getNumberOfImportProductByIdAmin(String ma_nv){
        return ImportProductModel.getInstance().getNumberOfImportProductByIdAmin(ma_nv);
    }

}
