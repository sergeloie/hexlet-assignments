package exercise;

import java.util.List;

// BEGIN
public class App {

    public static int getCountOfFreeEmails(List<String> emailsList) {
        return (int) emailsList.stream()
                .filter(email -> email.endsWith("gmail.com") || email.endsWith("yandex.ru") || email.endsWith("hotmail.com"))
                .count();
    }
}
// END
