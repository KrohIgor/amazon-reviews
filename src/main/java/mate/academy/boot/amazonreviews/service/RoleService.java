package mate.academy.boot.amazonreviews.service;

import mate.academy.boot.amazonreviews.entity.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String name);
}
