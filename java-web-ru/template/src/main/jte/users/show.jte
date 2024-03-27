@import exercise.dto.users.UserPage
@param UserPage page

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

    <title>Single User</title>
</head>
<body>

    <div class="mx-auto p-4 py-md-5 animate__animated animate__fadeInLeftBig">
        <p>${page.getUser().toString()}</p>
    </div>

</body>
</html>