package mate.academy.boot.amazonreviews.service.impl;

import mate.academy.boot.amazonreviews.entity.Role;
import mate.academy.boot.amazonreviews.repository.RoleRepository;
import mate.academy.boot.amazonreviews.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.getRoleByName(Role.RoleName.valueOf(name));
    }
}
