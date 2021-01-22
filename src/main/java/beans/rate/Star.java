package beans.rate;

public class Star {
    private String idProduct;
    private int sumRate;
    private double avgStar;

    public Star(String idProduct, int sumRate, double avgStar) {
        this.idProduct = idProduct;
        this.sumRate = sumRate;
        this.avgStar = avgStar;
    }

    public Star(){

    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getSumRate() {
        return sumRate;
    }

    public void setSumRate(int sumRate) {
        this.sumRate = sumRate;
    }

    public double getAvgStar() {
        return avgStar;
    }

    public void setAvgStar(double avgStar) {
        this.avgStar = avgStar;
    }

    @Override
    public String toString() {
        return "Star{" +
                "idProduct='" + idProduct + '\'' +
                ", sumRate=" + sumRate +
                ", avgStar=" + avgStar +
                '}';
    }
}
