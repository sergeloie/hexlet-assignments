package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    @SneakyThrows
    public static void save(Path path, Car car) {
        String json = car.serialize();
        Files.writeString(path, json);
    }

    @SneakyThrows
    public static Car extract(Path path) {
        String json = Files.readString(path);
        return Car.unserialize(json);
    }
}
// END
