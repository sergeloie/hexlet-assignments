@import exercise.util.NamedRoutes
@import exercise.dto.BasePage
@import gg.jte.Content
@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet" />
    </head>
    <body>
    <header class="d-flex justify-content-center py-3 animate__animated animate__rubberBand">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="${exercise.util.NamedRoutes.postsPath()}" class="nav-link active" aria-current="page">All posts</a></li>
            <li class="nav-item"><a href="${exercise.util.NamedRoutes.buildPostPath()}" class="nav-link">Build post</a></li>
        </ul>
    </header>
    <div>
        @if(page !=null && page.getFlash() != null)
        <p>${page.getFlash()}</p>
        @endif
    </div>
    <div>
        ${content}
    </div>
    </body>
</html>



