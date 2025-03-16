package ma.proj.usersroles_app8.service;

import ma.proj.usersroles_app8.entities.Role;
import ma.proj.usersroles_app8.entities.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    User findUserByUsername(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);
    User authentificate(String userName, String password);
}
