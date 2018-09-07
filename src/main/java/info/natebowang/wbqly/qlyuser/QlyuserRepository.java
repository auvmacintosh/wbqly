package info.natebowang.wbqly.qlyuser;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

@RepositoryRestResource
public interface QlyuserRepository extends PagingAndSortingRepository<Qlyuser, Long> {

    Qlyuser findByUsername(@Param("username") String name);

    @Override
    @Secured("ROLE_ADMIN")
    <S extends Qlyuser> S save(S s);
}