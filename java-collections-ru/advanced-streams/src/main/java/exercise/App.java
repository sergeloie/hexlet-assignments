package exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;


// BEGIN
class App {

    public static String getForwardedVariables(String file) {
        return Stream.of(file.split("\n"))
                .filter(str1 -> str1.startsWith("environment"))
                .map(str2 -> str2.replaceAll("environment=", ""))
                .map(str3 -> str3.replaceAll("\"", ""))
                .flatMap(str4 -> Stream.of(str4.split(",")))
                .filter(str5 -> str5.startsWith("X_FORWARDED_"))
                .map(str6 -> str6.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
