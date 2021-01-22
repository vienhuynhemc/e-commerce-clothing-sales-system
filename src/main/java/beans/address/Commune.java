package beans.address;

public class Commune {

    private String communeName;
    private String communeId;

    public Commune(String communeName, String communeId) {
        this.communeName = communeName;
        this.communeId = communeId;
    }

    public Commune(){

    }

    public String toString(){
        return communeName;
    }

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }

    public String getCommuneId() {
        return communeId;
    }

    public void setCommuneId(String communeId) {
        this.communeId = communeId;
    }


}
