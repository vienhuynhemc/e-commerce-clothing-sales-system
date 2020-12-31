package controllerAdmin.category;

import beans.category.Category;

import model.category.CategoryModel;
import worksWithDatabase.category.CategoryWorksWithDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;


@WebServlet(name = "CategoryController", urlPatterns = "/CategoryController")
public class CategoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        try{
            //String input = request.getParameter("keyword");
            // mỗi trang hiển thị 3 danh mục

            //lấy vị trí 1,2,3...4,5,6
            ArrayList<Category> categories = null;
            int index = 1;
            if(request.getAttribute("index") == null) {
                categories = CategoryWorksWithDatabase.getCategoriesByIndex(index, 3);
            }
            else{
                index = (int)request.getAttribute("index");
                categories = CategoryWorksWithDatabase.getCategoriesByIndex(index, 3);
            }
            //lấy sô lượng trang
            ArrayList<Category> categories1 = CategoryModel.getAllList();
            int numPage = CategoryModel.getNumberOfPage(categories1, 3);
            request.setAttribute("numberOfPage", numPage);
            request.setAttribute("list", categories);
            System.out.println(categories.size());
            request.getRequestDispatcher("admin/home/quanLyDanhMuc.jsp").forward(request, response);

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("loi:" +e);
        }
    }
}
