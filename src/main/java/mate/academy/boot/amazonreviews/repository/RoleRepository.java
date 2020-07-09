package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(Role.RoleName name);
}
