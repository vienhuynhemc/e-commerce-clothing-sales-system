package model.editAccountAdmin;


import worksWithDatabase.editAccountAdmin.EditAccountKHDAO;
import worksWithDatabase.editAccountAdmin.EditAccountKHSource;

public class EditAccountKHModel {
    private static EditAccountKHModel editAccountModel;

    public static EditAccountKHModel getInstance(){

        if(editAccountModel == null){
            editAccountModel = new EditAccountKHModel();
        }
        return editAccountModel;

    }
    public boolean editAccount(String userName,String fullName,String displayName,String activeStatus,String activeEvaluate,String passWord){
        EditAccountKHDAO editAccountDAO = EditAccountKHSource.getInstance().getEditAccount();

       boolean check = editAccountDAO.updateAccountKH(userName,fullName,displayName,activeStatus,activeEvaluate,passWord);

        EditAccountKHSource.getInstance().releaseEditAccount(editAccountDAO);
        return check;
    }
}
