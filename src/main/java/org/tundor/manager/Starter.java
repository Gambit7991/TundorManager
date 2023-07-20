package org.tundor.manager;

import org.domain.models.userRoles.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.tundor.manager.services.user_service.AdminService;

@SpringBootApplication(scanBasePackages = {"org.tundor.manager"})
@EnableJpaRepositories(basePackages = { "org.tundor.data.data_interacting"})
@EntityScan(basePackages = {"org.tundor.data"})
public class Starter {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Starter.class, args);
        AdminService service = context.getBean(AdminService.class);
        Admin admin = service.findAll().get(0);
        System.out.println(admin);
        System.out.println("hello world");
    }
}
