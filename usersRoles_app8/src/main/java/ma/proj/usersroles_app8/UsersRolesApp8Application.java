    package ma.proj.usersroles_app8;

    import ma.proj.usersroles_app8.entities.Role;
    import ma.proj.usersroles_app8.entities.User;
    import ma.proj.usersroles_app8.service.UserService;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.context.annotation.Bean;

    import java.util.stream.Stream;

    @SpringBootApplication
    public class UsersRolesApp8Application {

        public static void main(String[] args) {
            SpringApplication.run(UsersRolesApp8Application.class, args);
        }
        @Bean
        CommandLineRunner start(UserService userService) {
            return args -> {
                User user = new User();
                user.setUserName("user1");
                user.setPassword("password1");
                userService.saveUser(user);
                User user2 = new User();
                user2.setUserName("user2");
                user2.setPassword("password2");
                userService.saveUser(user2);
                Stream.of("STUDENT", "TEACHER", "ADMIN").forEach(roleName -> {
                    Role role = new Role();
                    role.setRoleName(roleName);
                    userService.saveRole(role);
                });
                userService.addRoleToUser("user1", "ADMIN");
                userService.addRoleToUser("user1", "TEACHER");

                try{
                    User u = userService.authentificate("user1", "password1");
                    System.out.println(u.getUserId());
                    System.out.println(u.getUserName());
                    u.getRoles().forEach(role -> {
                        System.out.println(role.getRoleName());
                    });

                }catch (Exception e){

                }
            };

    }
    }
