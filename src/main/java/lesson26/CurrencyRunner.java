package lesson26;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Scanner;

@Configuration
@ComponentScan("lesson26")
public class CurrencyRunner {

    final static String EXIT_WORD = "EXIT";
    final static String PROMPT_MESSAGE = "Введите код валюты (USD, EUR, GBP и т.п.) или " + EXIT_WORD + " для выхода:";

    public static void main(String[] args) {

        final AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(CurrencyRunner.class);
        final CurrencyGrabber currencyGrabber = annotationConfigApplicationContext.getBean(CurrencyGrabber.class);
        System.out.println(currencyGrabber.getCurrency("USD"));
        System.out.println(currencyGrabber.getCurrency("GBP"));

        System.out.println(PROMPT_MESSAGE);
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String console = scanner.nextLine();
            if (console.equalsIgnoreCase(EXIT_WORD)){
                return;
            }
            BigDecimal currency = currencyGrabber.getCurrency(console.toUpperCase());
            System.out.printf("Текущий курс %s равен %.2f рублей\n", console.toUpperCase(), currency);
            System.out.println(PROMPT_MESSAGE);
        }
    }
}
