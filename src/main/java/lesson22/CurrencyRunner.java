package lesson22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyRunner {

    private static final String SERVER_URL = "http://data.fixer.io";
    private static final String API_CURRENCY_URL = "/api/latest?symbols=RUB,USD,GBP,JPY&access_key=";
    private static final String API_ACCESS_KEY = "f9441001ada936baa874d1cb2a83bcff";
    //private static String fullApiCurrencyUrl = API_CURRENCY_URL + API_ACCESS_KEY;

    public static void main(String[] args) throws IOException {

        StringBuilder jsonStringBuilder = new StringBuilder();

        try {
            URL apiCurrencyUrl = new URL(SERVER_URL + API_CURRENCY_URL + API_ACCESS_KEY);
            System.out.println("Пытаемся соединиться с сервером " + SERVER_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) apiCurrencyUrl.openConnection();
            httpURLConnection.connect();
            System.out.println("Статус ответа сервера: " + httpURLConnection.getResponseCode ());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonStringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            System.out.println("Прочитанный JSON: " + jsonStringBuilder);
        } catch (MalformedURLException e) {
            System.out.println("Ошибка URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }






    }
}
