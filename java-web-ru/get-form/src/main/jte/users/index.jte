@import exercise.dto.users.UsersPage
@import org.apache.commons.lang3.StringUtils
@param UsersPage page


@template.layout.page(content = @`
    <form action="/users" method="get">
        <label>
            <input type="search" required name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Search">
    </form>
<%--    @for (var user : page.getUsers())--%>
<%--        @if (StringUtils.startsWithIgnoreCase(user.getFirstName(), page.getTerm()))--%>
<%--            <div>--%>
<%--                <p>${user.toString()}</p>--%>
<%--            </div>--%>
<%--        @endif--%>
<%--    @endfor--%>


    @if (page.getTerm() == null)
        @for (var user : page.getUsers())
            <div>
                <p>${user.toString()}</p>
            </div>
        @endfor
    @else
        @for (var user : page.getUsers())
            @if (StringUtils.startsWithIgnoreCase(user.getFirstName(), page.getTerm()))
                <div>
                    <p>${user.toString()}</p>
                </div>
            @endif
        @endfor
    @endif
`)