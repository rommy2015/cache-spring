package cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching  /*подключение Spring Cache*/
@SpringBootApplication
public class CacheSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheSpringApplication.class, args);
    }

}
