package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Messages;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void createSession(Context context) {
        String name = context.formParam("name");
        String password = context.formParam("password");
        String hash = Security.encrypt(password);
        User user = UsersRepository.findByName(name);

        if (user != null && user.getPassword().equals(hash)) {
            context.sessionAttribute("currentUser", name);
            context.redirect(NamedRoutes.rootPath());
        } else {
            LoginPage page = new LoginPage(name, Messages.WRONG_CREDENTIALS);
            context.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void deleteSession(Context context) {
        context.sessionAttribute("currentUser", null);
        context.redirect(NamedRoutes.rootPath());
    }

    public static void show(Context context) {
        LoginPage page = new LoginPage();
        context.render("build.jte", Collections.singletonMap("page", page));
    }
    // END
}
