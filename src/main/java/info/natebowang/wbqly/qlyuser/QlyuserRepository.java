package info.natebowang.wbqly.qlyuser;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@RepositoryRestResource
public interface QlyuserRepository extends PagingAndSortingRepository<Qlyuser, Long> {

    @Override
    @Secured("ROLE_ADMIN")
    <S extends Qlyuser> S save(S s);

    @Override
    @Secured("ROLE_ADMIN")
    Optional<Qlyuser> findById(Long aLong);

//    @PreAuthorize("#username == authentication.name")
//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Qlyuser findByUsername(@Param("username") String name);

    @Secured("ROLE_ADMIN")
    Iterable<Qlyuser> findByLmt(Iterable<Long> iterable);
}
