package exercise.daytime;
import exercise.condition.NightCondition;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Scope("prototype")
@Component
@Conditional(NightCondition.class)
public class Night implements Daytime {
    private final String name = "night";

    // BEGIN
    @PostConstruct
    public void itsAlive() {
        System.out.println("NightTime bean created!!!");
    }
    // END
}
