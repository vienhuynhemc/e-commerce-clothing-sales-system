package controllerAdmin.quanLyNhapHang;

import beans.manufacturer.Manufacturer;
import com.google.gson.Gson;
import model.nhapHang.DanhSachHangSanXuat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoadManufactor",urlPatterns = "/LoadManufactor")
public class LoadManufactor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DanhSachHangSanXuat danhSachHangSanXuat = DanhSachHangSanXuat.getInstance();

        ArrayList<Manufacturer> list = danhSachHangSanXuat.laodManufacturer();

        String json = new Gson().toJson(list);

        System.out.println(json);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
