package info.natebowang.wbqly.qlyuser;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QlyuserRepository extends PagingAndSortingRepository<Qlyuser, Long> {

    Qlyuser findByUsername(@Param("username") String name);

}