package beans.address;

import java.util.List;

public class Provincial {

    private String provincialId;
    private String provincialName;
    private List<District> districts;

    public Provincial(String provincialId, String provincialName, List<District> districts) {
        this.provincialId = provincialId;
        this.provincialName = provincialName;
        this.districts = districts;
    }

    public String getProvincialId() {
        return provincialId;
    }

    public void setProvincialId(String provincialId) {
        this.provincialId = provincialId;
    }

    public String getProvincialName() {
        return provincialName;
    }

    public void setProvincialName(String provincialName) {
        this.provincialName = provincialName;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public String toString() {
        return provincialName;
    }

}
