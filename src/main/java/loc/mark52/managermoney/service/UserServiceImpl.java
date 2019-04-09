package loc.mark52.managermoney.service;

import loc.mark52.managermoney.data.entity.Role;
import loc.mark52.managermoney.data.entity.User;
import loc.mark52.managermoney.data.repository.RoleRepository;
import loc.mark52.managermoney.data.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @SneakyThrows
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>(Collections.singleton(roleRepository.findById(1L).orElseThrow(Exception::new)));
        user.setRoles(roles);

        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @SneakyThrows
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }
}
