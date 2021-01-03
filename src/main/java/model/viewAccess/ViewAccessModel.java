package model.viewAccess;

import connectionDatabase.DataSource;
import worksWithDatabase.viewAccess.ViewAccessDAO;
import worksWithDatabase.viewAccess.ViewAccessDataSource;

public class ViewAccessModel {
    private static ViewAccessModel viewAccessModel;

    private static ViewAccessModel getInstance(){
        if(viewAccessModel == null){
            return new ViewAccessModel();
        }
        return viewAccessModel;
    }
    public static int getViews(){
        ViewAccessDAO viewAccessDAO = ViewAccessDataSource.getInstance().getViewAccessDAO();
        int views = viewAccessDAO.getViews();
        ViewAccessDataSource.getInstance().releaseViewAccessDAO(viewAccessDAO);
        return views;
    }
    public static void updateView(){
        ViewAccessDAO viewAccessDAO = ViewAccessDataSource.getInstance().getViewAccessDAO();
        viewAccessDAO.updateViews();
        ViewAccessDataSource.getInstance().releaseViewAccessDAO(viewAccessDAO);
    }

    public static void main(String[] args) {

    }

}
