package beans.address;

import java.util.List;

public class District {

    private String districtId;
    private String districtName;
    private List<Commune> communes;

    public District(String districtId, String districtName, List<Commune> communes) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.communes = communes;
    }

    public String toString(){
        return districtName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

}
