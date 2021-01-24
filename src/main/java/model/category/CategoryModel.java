package model.category;

import beans.productAdmin.ProductAdmin;
import beans.productAdmin.ProductAdminCategory;
import worksWithDatabase.category.CategoryDataSource;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import java.util.List;

public class CategoryModel {
    private static CategoryModel categoryModel;

    public static CategoryModel getInstance() {
        if (categoryModel == null) {
            categoryModel = new CategoryModel();
        }
        return categoryModel;
    }

    public static boolean checkAddCategory(String name) {
        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        if (name != null) {
            categoryDAO.addCategory(name);
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            return true;
        }
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return false;
    }

    public static boolean checkUpdateCategory(String id, String name) {
        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        if (categoryDAO.updateCategory(id, name)) {
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            System.out.println("cap nhat ok nha");
            return true;
        }
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return false;
    }

    public static boolean checkRemoveCategory(String id) {
        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        if (categoryDAO.removeCategory(id)) {
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            System.out.println("successful");
            return true;
        }
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);

        return false;
    }

    //  Phuơng thức nhận vô list product admin, điền tên danh mục cho nó
    public void fillNameForProductAdmin(List<ProductAdmin> products) {

        CategoryWorksWithDatabase categoryWorksWithDatabase = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        categoryWorksWithDatabase.fillNameForProductAdmin(products);
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryWorksWithDatabase);

    }

    //  Phuownmg thuwc laya all dm
    public List<ProductAdminCategory> getAllCategory() {
        CategoryWorksWithDatabase categoryWorksWithDatabase = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        List<ProductAdminCategory> result = categoryWorksWithDatabase.getAllCategory();
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryWorksWithDatabase);
        return result;
    }


    public static void main(String[] args) {
        //System.out.println(CategoryWorksWithDatabase.numberOfPage());
        // System.out.println(getNumberOfPage(getAllList(), 3));
        System.out.print(checkUpdateCategory("dm_9", "AO MOI NA"));
    }


}
