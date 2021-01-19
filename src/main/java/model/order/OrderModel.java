package model.order;

import worksWithDatabase.order.OrderDataSource;
import worksWithDatabase.order.OrderWorksWithDatabase;

public class OrderModel {

    private static OrderModel orderModel;

    public static OrderModel getInstance(){
        if(orderModel == null){
            orderModel = new OrderModel();
        }
        return orderModel;
    }

    //  Phương thứcn nhân vô mã admin kiểm tra số đơn hàng đã được admin này duyệt
    public int getOrderApprovalByIdAdmin(String ma_admin){
        OrderWorksWithDatabase orderWorksWithDatabase = OrderDataSource.getInstance().getOrderWorksWithDatabase();
        int result = orderWorksWithDatabase.getOrderApprovalByIdAdmin(ma_admin);
        OrderDataSource.getInstance().releaseOrderWorksWithDatabase(orderWorksWithDatabase);
        return result;
    }

}
