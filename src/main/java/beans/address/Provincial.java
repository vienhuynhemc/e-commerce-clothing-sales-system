package beans.address;

import java.util.List;

public class Provincial {

    private String provincialId;
    private String provincialName;

    public Provincial(String provincialId, String provincialName) {
        this.provincialId = provincialId;
        this.provincialName = provincialName;
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

    public String toString() {
        return provincialName;
    }

}
