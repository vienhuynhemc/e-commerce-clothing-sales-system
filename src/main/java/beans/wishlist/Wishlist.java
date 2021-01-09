package beans.wishlist;

public class Wishlist {

    private String name;
    private int price;
    private int size;
    private int quantity;
    private int color;
    private String img;

    public Wishlist(String name, int price, int size, int quantity, int color, String img) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.color = color;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", quantity=" + quantity +
                ", color=" + color +
                ", img='" + img + '\'' +
                '}';
    }
}
