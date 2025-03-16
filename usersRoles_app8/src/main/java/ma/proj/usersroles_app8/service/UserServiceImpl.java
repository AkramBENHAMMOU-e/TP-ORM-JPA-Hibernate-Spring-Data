package ma.proj.usersroles_app8.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.proj.usersroles_app8.entities.Role;
import ma.proj.usersroles_app8.entities.User;
import ma.proj.usersroles_app8.repositories.RoleRepository;
import ma.proj.usersroles_app8.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor @Transactional
public class UserServiceImpl implements UserService {
    RoleRepository roleRepository;
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) { // Updated method name
        return roleRepository.findByRoleName(roleName); // Updated repository call
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = findUserByUsername(userName);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles() !=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }


    }

    @Override
    public User authentificate(String userName, String password) {
        User user = userRepository.findUserByUserName(userName);
        if(user ==null) throw  new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
