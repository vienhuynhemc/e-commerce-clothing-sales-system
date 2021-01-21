package model.informationAccountNVK;

import model.informationAccountNVGH.InformationAccountNVGHModel;
import model.order.OrderModel;

public class InformationAccountNVKModel {
    private static InformationAccountNVKModel informationAccountNVKModel;

    public static InformationAccountNVKModel getInstance(){
        if(informationAccountNVKModel == null){
            informationAccountNVKModel = new InformationAccountNVKModel();
        }
        return informationAccountNVKModel;
    }

    // Phương thức nhận vô ma_nvk kiểm tra số đơn ahfng đã được nvgh này duyệt
    public int getOrderApprovalByIdNVK(String ma_nvk){
        return OrderModel.getInstance().getOrderApprovalByIdNVK(ma_nvk);
    }
}
