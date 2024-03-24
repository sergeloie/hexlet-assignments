@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <div class="animate__animated animate__backInLeft">${page.getUser().toString()}</div>
`)
