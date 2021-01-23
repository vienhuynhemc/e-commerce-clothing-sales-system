package controllerIndex.address;

import beans.address.District;
import beans.address.Provincial;
import com.google.gson.Gson;
import model.address2.AddressModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadDistricController",urlPatterns = "/LoadDistricController")
public class LoadDistricController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma_tinh = request.getParameter("ma_tinh");

        AddressModel addressModel = new AddressModel();

        ArrayList<District> list = addressModel.listDistrictByID(ma_tinh);

        String json = new Gson().toJson(list);

        //System.out.println(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
