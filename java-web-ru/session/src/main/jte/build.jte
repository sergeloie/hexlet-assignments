@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(content = @`
    @if(page.getError() != null)
        <div class="alert alert-danger" role="alert">
            Wrong username or password
        </div>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <label>
            <input type="text" placeholder="Nickname" name="name" value="${page.getName()}">
        </label>
        <label>
            <input type="password" placeholder="Password" name="password">
        </label>
        <input type="submit">
    </form>
`)
