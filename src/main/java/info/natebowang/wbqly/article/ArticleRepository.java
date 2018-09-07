package info.natebowang.wbqly.article;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
}
