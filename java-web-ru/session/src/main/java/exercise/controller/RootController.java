package exercise.controller;

import exercise.dto.MainPage;
import io.javalin.http.Context;

import java.util.Collections;

public class RootController {

    public static void index(Context context) {
        var page = new MainPage(context.sessionAttribute("currentUser"));
        context.render("index.jte", Collections.singletonMap("page", page));
    }
}
