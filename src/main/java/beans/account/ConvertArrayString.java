package beans.account;

import java.util.ArrayList;

public class ConvertArrayString {


    public static ArrayList<String> convertString(String s) {
        ArrayList<String> result = new ArrayList<>();

        String ss = s.replaceAll("[\\[\"\\]]","");

        System.out.println(ss);

        String[] sss = ss.split(",");

        for (String ssss: sss) {
            result.add(ssss);
        }


        return result;
    }
    // ["KH053","KH043"]

    public static void main(String[] args) {

      // System.out.println(ConvertArrayString.convertString("[\"KH053\",\"KH043\"]"));
        System.out.println(ConvertArrayString.convertString("KH053"));
    }
}
