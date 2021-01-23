package model.size;

import beans.productAdmin.ProductAdmin;
import worksWithDatabase.size.SizeDataSource;
import worksWithDatabase.size.SizeWorksWithDatabase;

import java.util.List;

public class SizeModel {

    private static SizeModel sizeModel;

    public static SizeModel getInstance(){
        if(sizeModel == null) sizeModel = new SizeModel();

        return sizeModel;
    }

    public void fillNameSize(List<ProductAdmin> products) {
        SizeWorksWithDatabase sizeWorksWithDatabase = SizeDataSource.getInstance().getSizeWorksWithDatabase();
        sizeWorksWithDatabase.fillNameSize(products);
        SizeDataSource.getInstance().releaseSizeWorksWithDatabase(sizeWorksWithDatabase);
    }

}
