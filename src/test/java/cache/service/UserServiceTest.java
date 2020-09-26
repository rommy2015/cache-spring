package cache.service;

import cache.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void create() {
    }

    @Test
    void get() {

        User user1 = service.create(new User("Ann", "ann@mail.ru"));
        User user2 = service.create(new User("Petr", "petr@mail.ru"));

        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
    }

    private void getAndPrint(Long id) {
        log.info("user found: {}", service.get(id));
    }

    @Test
    void testCreate() {

        createAndPrint("Ivan", "ivan@mail.ru");
        createAndPrint("Ivan", "ivan1122@mail.ru");
        createAndPrint("Sergey", "ivan@mail.ru");

        log.info("all entries are below:");

        service
                .getAll()
                .forEach(u -> log.info("{}", u.toString()));
    }

    private void createAndPrint(String name, String email) {

        User user = service.create(name, email);

        log.info("created user: {}", user);
    }

    @Test
    void createOrReturnCached() {
    }

    @Test
    void createAndRefreshCache() {

        User user1 = service.createOrReturnCached(new User("Lany", "ann@mail.ru"));
        log.info("created user1: {}", user1);

        User user2 = service.createOrReturnCached(new User("Lany", "misha@mail.ru"));
        log.info("created user2: {}", user2);

        User user3 = service.createAndRefreshCache(new User("Lany", "kolya@mail.ru"));
        log.info("created user3: {}", user3);

        User user4 = service.createOrReturnCached(new User("Lany", "petya@mail.ru"));
        log.info("created user4: {}", user4);

    }
}