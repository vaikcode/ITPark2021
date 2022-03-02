package lesson22;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CurrencyRunner {

    private static final String SERVER_URL = "http://data.fixer.io";
    private static final String API_CURRENCY_URL = "/api/latest?symbols=RUB,USD,GBP,JPY&access_key=";
//    private static final String API_ACCESS_KEY = "f9441001ada936baa874d1cb2a83bcff";
    private static final String KEY_PATH = "src/main/resources/lesson22key";

    public static void main(String[] args) throws IOException {

        BigDecimal eurRate;
        BigDecimal rubRate;
        BigDecimal usdRate;
        BigDecimal gbpRate;
        BigDecimal jpyRate;

        String apyAccessKey;
        StringBuilder jsonStringBuilder = new StringBuilder();

        System.out.println("Попытка чтения файла ключа " + KEY_PATH);
        Scanner s = new Scanner(new File(KEY_PATH));
        if (s.hasNextLine()){
            apyAccessKey = s.nextLine();
        } else {
            System.out.println("Ошибка в файле ключа");
            return;
        }
        s.close();
        System.out.println("Из файла ключа прочитан ключ: " + apyAccessKey);

        try {
            URL apiCurrencyUrl = new URL(SERVER_URL + API_CURRENCY_URL + apyAccessKey);
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
            System.out.println("Прочитанная с сервера JSON-строка: " + jsonStringBuilder);
        } catch (MalformedURLException e) {
            System.out.println("Ошибка URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }

        System.out.println("Преобразуем JSON-строку в JSON-объект:");
        ObjectMapper mapper = new ObjectMapper();
        CurrencyPojo currencyPojo = mapper.readValue(jsonStringBuilder.toString(), CurrencyPojo.class);
        System.out.println(currencyPojo.toString());

        rubRate = currencyPojo.getRates().get("RUB");
        usdRate = currencyPojo.getRates().get("USD");
        gbpRate = currencyPojo.getRates().get("GBP");
        jpyRate = currencyPojo.getRates().get("JPY");

        usdRate = rubRate.divide(usdRate, new MathContext(9));
        eurRate = rubRate;
        gbpRate = rubRate.divide(gbpRate, new MathContext(9));
        jpyRate = rubRate.divide(jpyRate, new MathContext(9));

        System.out.println("Проверка текущих курсов RUB:");
        System.out.println("USD: " + usdRate);
        System.out.println("EUR: " + eurRate);
        System.out.println("GBP: " + gbpRate);
        System.out.println("JPY: " + jpyRate);

        String consoleLine;
        EnterString enterString;

        while (true) {
            System.out.println();
            System.out.println("Для отображения курса рубля РФ к требуемой иностранной валюте");
            System.out.println("введите USD, EUR, GBP или JPY. Или введите EXIT для выхода:");
            Scanner console = new Scanner(System.in);
            if (console.hasNextLine()) {
                consoleLine = console.nextLine();
                try {
                    enterString = EnterString.valueOf(consoleLine);
                } catch (IllegalArgumentException e) {
                    enterString = EnterString.INIT;
                }
                switch(enterString) {
                    case USD:
                        System.out.println("Текущий курс рубля РФ к USD = " + usdRate);
                        break;
                    case EUR:
                        System.out.println("Текущий курс рубля РФ к EUR = " + eurRate);
                        break;
                    case GBP:
                        System.out.println("Текущий курс рубля РФ к GBP = " + gbpRate);
                        break;
                    case JPY:
                        System.out.println("Текущий курс рубля РФ к JPY = " + jpyRate);
                        break;
                    case EXIT:
                        return;
                    case INIT:
                        System.out.println("ОШИБКА: Ввод неправильных данных");
                }
            }
        }
    }
}
