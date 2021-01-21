package beans.wishlist;

import beans.DateTime;

import java.time.LocalDate;
import java.time.LocalTime;

public class Wishlist {

    private String name;
    private double price;
    private String size;
    private int quantity;
    private String color;
//    private String img;
    private DateTime dateAdded;
    private int restNumber;

    public Wishlist(String name, double price, String size, int quantity, String color,DateTime dateAdded,int restNumber) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.color = color;
//        this.img = img;
//        this.status = status;
        this.dateAdded = dateAdded;
        this.restNumber = restNumber;
    }
    public Wishlist(){

    }

    public int getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(int restNumber) {
        this.restNumber = restNumber;
    }
    //    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }

    public DateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(DateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
//
//    public String getImg() {
//        return img;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }


    @Override
    public String toString() {
        return "Wishlist{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                ", dateAdded=" + dateAdded +
                ", restNumber=" + restNumber +
                '}';
    }
}
