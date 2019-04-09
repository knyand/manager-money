package loc.mark52.managermoney.data.repository;

import loc.mark52.managermoney.data.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
