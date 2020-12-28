package beans.nextPage;

import java.io.Serializable;

public class NextPageObject implements Serializable {

    //  Giá trị của item nextPage
    private String value;

    //  Kiểu của nextpage
    private int type;

    //  Constructor
    public NextPageObject(String value, int type) {
        this.value = value;
        this.type = type;
    }

    //  Getter and setter
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        return value;
    }

}
