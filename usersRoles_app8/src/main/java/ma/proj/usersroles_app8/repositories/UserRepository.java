package ma.proj.usersroles_app8.repositories;

import ma.proj.usersroles_app8.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUserName(String username);
}
