package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.dto.posts.EditPostPage;
import exercise.util.NamedRoutes;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        BuildPostPage page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        try {
            String name = ctx.formParamAsClass("name", String.class)
                .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                .get();

            String body = ctx.formParamAsClass("body", String.class)
                .check(value -> value.length() >= 10, "Пост должен быть не короче 10 символов")
                .get();

            Post post = new Post(name, body);
            PostRepository.save(post);
            ctx.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {
            String name = ctx.formParam("name");
            String body = ctx.formParam("body");
            BuildPostPage page = new BuildPostPage(name, body, e.getErrors());
            ctx.render("posts/build.jte", Collections.singletonMap("page", page)).status(422);
        }
    }

    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        PostsPage postPage = new PostsPage(posts);
        ctx.render("posts/index.jte", Collections.singletonMap("page", postPage));
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void update(Context context) {
        Long id = context.pathParamAsClass("id", Long.class).get();
        try {
            String name = context.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();

            String body = context.formParamAsClass("body", String.class)
                    .check(value -> value.length() >= 10, "Пост должен быть не короче 10 символов")
                    .get();

            Post post = PostRepository.find(id).get();
            post.setName(name);
            post.setBody(body);
            context.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {

            String name = context.formParam("name");
            String body = context.formParam("body");
            EditPostPage page = new EditPostPage(id, name, body, e.getErrors());
            context.render("posts/edit.jte", Collections.singletonMap("page", page)).status(422);
        }
    }

    public static void edit(Context context) {
        Long id = context.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));
        String name = post.getName();
        String body = post.getBody();
        EditPostPage page = new EditPostPage(id, name, body, null);
        context.render("posts/edit.jte", Collections.singletonMap("page", page));
    }

    // END
}
