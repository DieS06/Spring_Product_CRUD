package com.project.demo.logic.entity.rol;

import com.project.demo.logic.entity.user.User;
import com.project.demo.logic.entity.user.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSeeder implements ApplicationListener<ContextRefreshedEvent> {
        private final RoleRepository roleRepository;
        private final UserRepository userRepository;

        private final PasswordEncoder passwordEncoder;


        public UserSeeder(
                RoleRepository roleRepository,
                UserRepository  userRepository,
                PasswordEncoder passwordEncoder
        ) {
            this.roleRepository = roleRepository;
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            this.createUser();
        }


        private void createUser() {
            User firstUser = new User();
            firstUser.setName("Adan");
            firstUser.setLastname("Genesis");
            firstUser.setEmail("pecado.original@gmail.com");
            firstUser.setPassword("manzana123");

            Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);
            Optional<User> optionalUser = userRepository.findByEmail(firstUser.getEmail());

            if (optionalRole.isEmpty() || optionalUser.isPresent()) {
                return;
            }

            var user = new User();
            user.setName(firstUser.getName());
            user.setLastname(firstUser.getLastname());
            user.setEmail(firstUser.getEmail());
            user.setPassword(passwordEncoder.encode(firstUser.getPassword()));
            user.setRole(optionalRole.get());

            userRepository.save(user);
        }
}

