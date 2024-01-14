package exercise;

import exercise.controller.RootController;
import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;


public final class App {

    public static Javalin getApp() {

        Javalin app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), RootController::index);

        app.get(NamedRoutes.buildSessionPath(), SessionsController::show);
        app.post(NamedRoutes.loginPath(), SessionsController::createSession);
        app.post(NamedRoutes.logoutPath(), SessionsController::deleteSession);

        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
