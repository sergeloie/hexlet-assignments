package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPath(String pageNumber) {
        return "/posts/" + pageNumber;
    }

    public static String postsPath(Long pageNumber) {
        return postsPath(String.valueOf(pageNumber));
    }

    public static String postPath(String id) {
        return "/post/" + id;
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }
    // END
}
