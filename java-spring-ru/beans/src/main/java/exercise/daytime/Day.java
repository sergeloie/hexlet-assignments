package exercise.daytime;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Scope("prototype")
@Component
public class Day implements Daytime {
    private final String name = "day";

    // BEGIN
    @PostConstruct
    public void itsAlive() {
        System.out.println("DatTime bean created!!!");
    }
    // END
}
