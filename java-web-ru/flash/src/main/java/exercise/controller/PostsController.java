package exercise.controller;

import java.util.Collections;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        BuildPostPage page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        var page = new PostsPage(PostRepository.getEntities());
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        var body = ctx.formParamAsClass("body", String.class).get();

        try {
            name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 1, "Имя поста должно быть не короче 2 символов.")
                    .get();
            var post = new Post(name, body);
            PostRepository.save(post);
            ctx.sessionAttribute("flash", "Пост был успешно создан!");
            ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            var page = new BuildPostPage(name, body, e.getErrors());
            page.setFlash("Пост не был создан!");
//            ctx.sessionAttribute("flash", "Пост не был создан!");
            ctx.render("posts/build.jte", Collections.singletonMap("page", page));
        }
    }
    // END

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
