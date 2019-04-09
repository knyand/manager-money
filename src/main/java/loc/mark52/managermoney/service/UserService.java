package loc.mark52.managermoney.service;

import loc.mark52.managermoney.data.entity.User;

public interface UserService {
    void save(User user);
    User findByEmail(String email);
    User findById(Long id);
}
