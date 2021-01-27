package model.reCAPTCHA;

import beans.reCAPTCHA.ReCAPTCHAConfiguration;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReCAPTCHAModel {

    private static ReCAPTCHAModel reCAPTCHAModel;

    public static ReCAPTCHAModel getInstance() {

        if (reCAPTCHAModel == null) {
            reCAPTCHAModel = new ReCAPTCHAModel();
        }
        return reCAPTCHAModel;
    }

    public boolean verify(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        try {
            URL verifyUrl = new URL(ReCAPTCHAConfiguration.SITE_VERIFY_URL);

            HttpURLConnection conn = (HttpURLConnection) verifyUrl.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "en_US,en;q=0.5");

            String postParams = "secret=" + ReCAPTCHAConfiguration.SECRET_KEY + "&response=" + input;

            conn.setDoOutput(true);

            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());

            outStream.flush();
            outStream.close();

            int responseCode = conn.getResponseCode();
            System.out.println("ResponseCode: " + responseCode);

            InputStream is = conn.getInputStream();

            JsonReader jsonReader = (JsonReader) Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            System.out.println("Response: " + jsonObject);

            boolean success = jsonObject.getBoolean("success");
            return success;
        } catch (Exception e) {
            return false;
        }
    }

}
