package controllerIndex.address;

import beans.address.Commune;
import beans.address.District;
import com.google.gson.Gson;
import model.address2.AddressModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadCommuneController",urlPatterns = "/LoadCommuneController")
public class LoadCommuneController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma_huyen = request.getParameter("ma_huyen");

        AddressModel addressModel = new AddressModel();

        ArrayList<Commune> list = addressModel.listCommuneID(ma_huyen);

        String json = new Gson().toJson(list);

        //System.out.println(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
