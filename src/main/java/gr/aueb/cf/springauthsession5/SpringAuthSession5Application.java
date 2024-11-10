package gr.aueb.cf.springauthsession5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringAuthSession5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAuthSession5Application.class, args);
    }

}
