package beans.product;

import java.util.ArrayList;

public class ProductInfomation {
    private String ma_sp;
    private String thong_tin;

    public ProductInfomation(String ma_sp, String thong_tin) {
        this.ma_sp = ma_sp;
        this.thong_tin = thong_tin;
    }

    public ProductInfomation() {
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getThong_tin() {
        return thong_tin;
    }

    public void setThong_tin(String thong_tin) {
        this.thong_tin = thong_tin;
    }

    @Override
    public String toString() {
        return "ProductInfomation{" +
                "ma_sp='" + ma_sp + '\'' +
                ", thong_tin='" + thong_tin + '\'' +
                '}' + "\n";
    }
}
