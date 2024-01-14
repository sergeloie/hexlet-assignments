@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`
    @if(page.getName() == null)
        <div>
            <a href="${NamedRoutes.buildSessionPath()}">Войти></a>
        </div>
    @else
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <div>
                ${page.getName().toString()}
            </div>
            <input type="submit" value="Выйти">
        </form>
    @endif

`)
