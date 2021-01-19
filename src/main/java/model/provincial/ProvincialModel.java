package model.provincial;

import beans.address.Provincial;
import worksWithDatabase.provincial.ProvincialDataSource;
import worksWithDatabase.provincial.ProvincialWorksWithDatabase;

import java.util.List;

public class ProvincialModel {

    private static ProvincialModel provincialModel;

    public static ProvincialModel getInstance(){
        if(provincialModel == null){
            provincialModel = new ProvincialModel();
        }
        return provincialModel;
    }


    //  Phương thức trả về một list đẩy đủ các tỉnh thành
    public List<Provincial> getListProvincial() {

        ProvincialWorksWithDatabase provincialWorksWithDatabase = ProvincialDataSource.getInstance().getProvincialWorksWithDatabase();
        List<Provincial> provincials = provincialWorksWithDatabase.getListProvincial();
        ProvincialDataSource.getInstance().releaseProvincialWorksWithDatabase(provincialWorksWithDatabase);

        return provincials;

    }

    //  Phuơng thức nhận vô một Provincial điền tên cho nó
    public void fillNameById(Provincial provincial) {
        ProvincialWorksWithDatabase provincialWorksWithDatabase = ProvincialDataSource.getInstance().getProvincialWorksWithDatabase();
        provincialWorksWithDatabase.fillNameById(provincial);
        ProvincialDataSource.getInstance().releaseProvincialWorksWithDatabase(provincialWorksWithDatabase);
    }

}


