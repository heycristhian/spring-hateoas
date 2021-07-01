package br.com.heycristhian.hateoas.config;

import br.com.heycristhian.hateoas.entity.domain.User;
import br.com.heycristhian.hateoas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserService service;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            service.save(
                    User.builder()
                            .name("Cristhian Dias " + i)
                            .email("heycristhian" + i + "@gmail.com")
                            .build()
            );
        }
    }
}
