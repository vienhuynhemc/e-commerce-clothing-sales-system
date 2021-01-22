package beans.product;

import java.util.ArrayList;

public class ProductStructure {
    private String ma_sp;
    private ArrayList<String> cau_tao;

    public ProductStructure(String ma_sp, ArrayList<String> cau_tao) {
        this.ma_sp = ma_sp;
        this.cau_tao = cau_tao;
    }

    public ProductStructure() {
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public ArrayList<String> getCau_tao() {
        return cau_tao;
    }

    public void setCau_tao(ArrayList<String> cau_tao) {
        this.cau_tao = cau_tao;
    }

    @Override
    public String toString() {
        return "ProductStructure{" +
                "ma_sp='" + ma_sp + '\'' +
                ", cau_tao=" + cau_tao +
                '}';
    }
}
