package info.natebowang.wbqly.category;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
