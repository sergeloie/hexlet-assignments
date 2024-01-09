package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts?page=1";
    }

    public static String postsPath(String pageNumber) {
        return "/posts?page=" + pageNumber;
    }

    public static String postsPath(int pageNumber) {
        return postsPath(String.valueOf(pageNumber));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }
    // END
}
