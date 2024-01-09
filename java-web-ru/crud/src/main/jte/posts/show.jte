@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(content = @`
    <h1>Post number ${page.getPost().getId()}</h1>
    <h1>Post name ${page.getPost().getName()}</h1>
    <p>Post body</p>
    <p>${page.getPost().getBody()}</p>
    <p></p>
    <a href="${NamedRoutes.postsPath(1)}">Back to posts page</a>
`)
