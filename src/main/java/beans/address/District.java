package beans.address;

import java.util.List;

public class District {

    private String districtId;
    private String districtName;

    public District(String districtId, String districtName) {
        this.districtId = districtId;
        this.districtName = districtName;
    }

    public District(){

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

}
