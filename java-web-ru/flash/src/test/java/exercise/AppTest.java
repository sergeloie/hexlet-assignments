package exercise;

import okhttp3.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import exercise.repository.PostRepository;
import exercise.model.Post;

class AppTest {

    private static Javalin app;

    @BeforeEach
    public void setUp() {
        app = App.getApp();
    }

    @Test
    void testMainPage() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            Response response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    void testPostsPage() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            Response response = client.get("/posts");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void testPostPage() {
        Post post = new Post("name", "body");
        PostRepository.save(post);
        JavalinTest.test(app, (server, client) -> {
            Response response = client.get("/posts/" + post.getId());
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void testBuildPostPage() {
        JavalinTest.test(app, (server, client) -> {
            Response response = client.get("/posts/build");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void testCreatePost() {
        JavalinTest.test(app, (server, client) -> {
            String requestBody = "name=test&body=body";
            Response response = client.post("/posts", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("test");
        });
    }

}
