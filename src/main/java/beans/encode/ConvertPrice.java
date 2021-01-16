package beans.encode;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ConvertPrice {

    public static String convertPrice(double price){

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(price);
        return str1.substring(0,str1.length()-2);
    }

    public static void main(String[] args) {
        System.out.println(ConvertPrice.convertPrice(20000000));
    }
}
