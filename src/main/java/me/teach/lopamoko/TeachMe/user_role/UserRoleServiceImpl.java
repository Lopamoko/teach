package me.teach.lopamoko.TeachMe.user_role;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole createRole(UserRoleDictionary userRole) {
        return userRoleRepository.findDistinctFirstByUserRoleName(userRole.name())
                .orElseThrow(() -> new RuntimeException("User role with name " + userRole.name() + " not found"));
    }
}
