package beans.product;

public class Size {
    private String ma_size;
    private String ten_size;

    public Size(String ma_size, String ten_size) {
        this.ma_size = ma_size;
        this.ten_size = ten_size;
    }

    public Size() {
    }

    public String getMa_size() {
        return ma_size;
    }

    public void setMa_size(String ma_size) {
        this.ma_size = ma_size;
    }

    public String getTen_size() {
        return ten_size;
    }

    public void setTen_size(String ten_size) {
        this.ten_size = ten_size;
    }

    @Override
    public String toString() {
        return "Size{" +
                "ma_size='" + ma_size + '\'' +
                ", ten_size='" + ten_size + '\'' +
                '}' +"\n";
    }
}
