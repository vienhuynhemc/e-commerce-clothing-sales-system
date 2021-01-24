package model.loadPay;


import beans.order.Order;
import worksWithDatabase.loadPageHistory.LoadListPayDAO;

import java.util.ArrayList;

public class LoadPayModel {
    private static LoadPayModel loadPay;
    private int numpage;
    public static  LoadPayModel getInstance(){

        if (loadPay == null){
            loadPay = new LoadPayModel();
        }
        return loadPay;

    }

    public int getNumpage() {
        return numpage;
    }

    public void setNumpage(int numpage) {
        this.numpage = numpage;
    }

    public ArrayList<Order> loadListPay(String ma_kh, int page, String search){

        LoadListPayDAO loadListPayDAO = new LoadListPayDAO();

        ArrayList<Order> list =  loadListPayDAO.listOrder(ma_kh,page,search);

        setNumpage(loadListPayDAO.getNumPage());
        return list;
    }

}
