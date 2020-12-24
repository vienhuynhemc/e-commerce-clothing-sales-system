package category;

import java.util.Date;

public class Category {
    private String maDM;
    private String tenDM;
    private Date ngayTao;

    public Category(String maDM, String tenDM, Date ngayTao) {
        setMaDM(maDM);
        this.tenDM = tenDM;
        this.ngayTao = ngayTao;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    public String toString(){
        return maDM + " " + tenDM +" " + ngayTao;
    }
}
