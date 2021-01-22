package beans.wishlist;

public class WishlistToCart {
    private String idProduct;
    private String color;
    private String size;
    private int quantity;

    public WishlistToCart(){

    }

    public WishlistToCart(String idProduct, String color, String size, int quantity) {
        this.idProduct = idProduct;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "WishlistToCart{" +
                "idProduct='" + idProduct + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
