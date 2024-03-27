package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;
import exercise.Data;
import org.springframework.web.bind.annotation.*;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private final List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> indexUserPosts(@PathVariable int id) {
        List<Post> result = posts.stream()
                .filter(post -> post.getUserId() == id)
                .toList();
        int statusCode = result.isEmpty() ? 204 : 200;
        return ResponseEntity.status(statusCode)
                .body(result);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createUserPost(@PathVariable int id, @RequestBody Post data) {
        data.setUserId(id);
        posts.add(data);
        return ResponseEntity.status(201)
                .body(data);
    }
}
// END
