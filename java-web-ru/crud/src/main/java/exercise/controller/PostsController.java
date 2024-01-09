package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context context) {
        Long id = context.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        PostPage page = new PostPage(post);
        context.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context context) {
        Integer pageNumber = context.queryParamAsClass("page", Integer.class).get();
        List<Post> posts = PostRepository.getEntities();
        int start = 5 * (pageNumber - 1) + 1;
        int end = Math.min(5 * (pageNumber - 1) + 5, posts.size());
        List<Post> pagedPosts = posts.subList(start, end + 1);
        PostsPage page = new PostsPage(pagedPosts);
        context.render("posts/index.jte", Map.of("page", page, "pageNumber", pageNumber));
    }
    // END
}
