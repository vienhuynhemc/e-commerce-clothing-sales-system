package model.category;

import worksWithDatabase.category.CategoryDataSource;
import worksWithDatabase.category.CategoryWorksWithDatabase;

public class CategoryModel {
    private static CategoryModel categoryModel;

    public static CategoryModel getInstance(){
        if (categoryModel == null){
            categoryModel = new CategoryModel();
        }
        return categoryModel;
    }
    public static boolean checkAddCategory(String name){
        CategoryWorksWithDatabase  categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        if(name != null){
            categoryDAO.addCategory(name);
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            return true;
        }
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return false;
    }
    public static boolean checkUpdateCategory(String name, String id){
        CategoryWorksWithDatabase  categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        if(name != null){
            categoryDAO.updateCategory(id, name);
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            return true;
        }
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return false;
    }
    public static boolean checkRemoveCategory(String id){
    CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        if(id != null){
        categoryDAO.removeCategory(id);
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return true;
    }
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return false;
}

}
