package beans.product;

import java.util.ArrayList;

public class ProductIntroduction {
    private String ma_sp;
    private ArrayList<String> gioi_thieu;

    public ProductIntroduction(String ma_sp, ArrayList<String> gioi_thieu) {
        this.ma_sp = ma_sp;
        this.gioi_thieu = gioi_thieu;
    }

    public ProductIntroduction() {
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public ArrayList<String> getGioi_thieu() {
        return gioi_thieu;
    }

    public void setGioi_thieu(ArrayList<String> gioi_thieu) {
        this.gioi_thieu = gioi_thieu;
    }
}
