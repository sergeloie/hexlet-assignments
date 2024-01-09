@import exercise.dto.posts.PostsPage
@import exercise.repository.PostRepository
@import exercise.util.NamedRoutes
@param PostsPage page
@param int pageNumber


@template.layout.page(content = @`
    @for(var post : page.getPosts())
        <div>
            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
        </div>
    @endfor
    <nav aria-label="Page navigation">
        <ul class="pagination">
            @if(pageNumber == 1)
                <li class="page-item disabled"><a class="page-link" href="${NamedRoutes.postsPath(0)}">Previous</a></li>
            @else
                <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath(pageNumber - 1)}">Previous</a></li>
            @endif
            @if(pageNumber >= Math.ceil((double) PostRepository.getEntities().size() / 5))
                <li class="page-item disabled"><a class="page-link" href="${NamedRoutes.postsPath(pageNumber + 1)}">Next</a></li>
            @else
                <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath(pageNumber + 1)}">Next</a></li>
            @endif
        </ul>
    </nav>
`)