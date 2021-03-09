package main;

import controller.RatingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import persistence.entity.Rating;
import persistence.repository.RatingRepository;
import service.RatingService;

@ComponentScan(basePackageClasses = {RatingController.class, RatingService.class})
@EnableJpaRepositories(basePackageClasses = RatingRepository.class)
@EntityScan(basePackageClasses = Rating.class)
@SpringBootApplication
public class RatingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingServiceApplication.class, args);
    }

}
