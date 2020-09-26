package cache.service;

import cache.domain.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User create(String name, String email);

    List<User> getAll();

    User get(Long id);

    User createOrReturnCached(User user);

    User createAndRefreshCache(User user);

    void delete(Long id);

    void deleteAndEvict(Long id);
}
