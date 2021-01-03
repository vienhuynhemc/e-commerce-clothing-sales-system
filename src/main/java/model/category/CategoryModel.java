package model.category;

import beans.category.Category;

import connectionDatabase.DataSource;
import worksWithDatabase.category.CategoryDataSource;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        System.out.println("successful");
        return true;
    }
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return false;
    }
    // số kết quả truy vấn


//    public static int getNumberOfPage(int numCategory){
//        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
//        int sum = CategoryWorksWithDatabase.numberOfPage();
//        int numPage = 0;
//        if(sum % numCategory == 0){
//            numPage = sum % numCategory;
//            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
//            return numPage;
//        }
//        else{
//            numPage = (sum % numCategory) +1;
//            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
//            return numPage;
//        }
//
//    }
    public static int getNumberOfPage(ArrayList<Category> list, int numCategory){
        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        int numPage = 0;
        if(list.size() % numCategory == 0){
            numPage = list.size() / numCategory;
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            return numPage;
        }
        else{
            numPage = (list.size() / numCategory) +1;
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            return numPage;
        }
    }
    public static ArrayList<Category> getAllList(){
        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        ArrayList<Category> list = CategoryWorksWithDatabase.getAllCategories();
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return list;
    }
    public static ArrayList<Category> getCategoriesBySearch(String keyword){
        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        ArrayList<Category> categories = categoryDAO.search(keyword);
        ArrayList<Category> notFound = new ArrayList<Category>();
        if(categories != null) {
            CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
            return categories;
        }
        notFound.add(new Category("","Không tìm thấy danh mục!",null,0));
        return notFound;
    }
    public static ArrayList<Category> getCategoriesByIndex(int index, int number) {
        CategoryWorksWithDatabase categoryDAO = CategoryDataSource.getInstance().getCategoryWorksWithDatabase();
        ArrayList<Category> categories = categoryDAO.getCategoriesByIndex(index, number);
        CategoryDataSource.getInstance().releaseCategoryWorksWithDatabase(categoryDAO);
        return categories;
    }


    public static void main(String[] args) {
        //System.out.println(CategoryWorksWithDatabase.numberOfPage());
       // System.out.println(getNumberOfPage(getAllList(), 3));
        System.out.print(checkRemoveCategory("dm_11"));
    }


}
