package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context context) {
        String firstName = context.formParam("firstName");
        String lastName = context.formParam("lastName");
        String email = context.formParam("email");
        String password = context.formParam("password");
        String token = Security.generateToken();
        User user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        Long id = user.getId();
        context.cookie("token", token);
        context.redirect(NamedRoutes.userPath(id));
    }

    public static void show(Context context) {
        Long id = context.pathParamAsClass("id", Long.class).get();
        User user = null;
        if (UserRepository.find(id).isPresent()) {
            user = UserRepository.find(id).get();
        } else {
            context.redirect(NamedRoutes.buildUserPath());
        }

        String userToken = user.getToken();
        String cookieToken = context.cookie("token");
        if (userToken.equals(cookieToken)) {
            context.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            context.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
