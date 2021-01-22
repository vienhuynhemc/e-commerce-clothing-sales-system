package model.checkout;


import worksWithDatabase.checkout.PromoPay;

public class PromoPayModel {
    private static PromoPayModel pay;

    public static PromoPayModel getInstance(){
        if (pay == null){
            pay = new PromoPayModel();
        }
        return pay;
    }

    public double priceAfter(double total, String promo){
        return new PromoPay().priceAfter(total,promo);
    }

}
