@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
              crossorigin="anonymous">
        <link
                rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
        />
        <title>Users</title>
    </head>
    <body>
        @for(var user : page.getUsers())
            <div class="mx-auto p-4 py-md-1 animate__animated animate__fadeInLeftBig">
                <p><a href="/users/${user.getId()}">${user.toString()}</a></p>
            </div>
        @endfor
    </body>
</html>
