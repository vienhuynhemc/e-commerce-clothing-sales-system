package model.informationAccountNVGH;

import model.informationAccountAdmin.InformationAccountAdminModel;
import model.order.OrderModel;

public class InformationAccountNVGHModel {

    private static InformationAccountNVGHModel informationAccountNVGHModel;

    public static InformationAccountNVGHModel getInstance(){
        if(informationAccountNVGHModel == null){
            informationAccountNVGHModel = new InformationAccountNVGHModel();
        }
        return informationAccountNVGHModel;
    }

    // Phương thức nhận vô ma_nvgh kiểm tra số đơn ahfng đã được nvgh này duyệt
    public int getOrderApprovalByIdNVGH(String ma_nvgh){
        return OrderModel.getInstance().getOrderApprovalByIdNVGH(ma_nvgh);
    }


}
