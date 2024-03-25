package ma.esnet.hopital.repository;

import ma.esnet.hopital.entities.Role;
import ma.esnet.hopital.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);
}
