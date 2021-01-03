package beans.account;

import java.util.ArrayList;

public class ConvertArrayString {


    public static ArrayList<String> convertString(String s) {
        ArrayList<String> result = new ArrayList<>();

        String[] sp = s.split(",");

        String[] s1 = sp[0].split("\"");
        result.add(s1[1]);
        String[] s2 = sp[sp.length-1].split("\"");
        result.add(s2[1]);
        for (int i = 1; i <sp.length-1 ; i++) {
            result.add(sp[i].split("\"")[1]);
        }

        return result;
    }

    public static void main(String[] args) {


    }
}
