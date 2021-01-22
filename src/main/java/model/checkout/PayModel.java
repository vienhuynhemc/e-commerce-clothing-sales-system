package model.checkout;

import beans.cart.Cart;
import worksWithDatabase.checkout.Pay;
import worksWithDatabase.checkout.PaySource;

import java.util.ArrayList;

public class PayModel {
    private static PayModel pay;

    public static PayModel getInstance(){
        if (pay == null){
            pay = new PayModel();
        }
        return pay;
    }


    public boolean pay(String ma_kh, String ghi_chu, String ma_gg, int trangthai, ArrayList<Cart> carts, String ma_tinh, String ma_huyen, String ma_xa){

    Pay pay = PaySource.getInstance().getPay();

    boolean check = pay.pay(ma_kh,ghi_chu,ma_gg,trangthai,carts,ma_tinh,ma_huyen,ma_xa);

    PaySource.getInstance().releasePay(pay);

        return check;
    }

}
