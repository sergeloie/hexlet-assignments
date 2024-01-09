@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(content = @`
    @if(page.getErrors() !=null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post" class="row g-3 align-items-center">
        <div class="mb-3">
            <label>
                <p>Название статьи</p>
                <input type="text" required name="title" value="${page.getTitle()}">
            </label>
        </div>
        <div class="mb-3">
            <label>
                <p>Содержание статьи</p>
                <textarea name="content" required rows="15" cols="40" >${page.getContent()}</textarea>
            </label>
        </div>
<%--        <input type="submit" value="Sign up" />--%>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
`)
