package main;

import controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import persistence.entity.Book;
import persistence.repository.BookRepository;
import service.BookService;

@ComponentScan(basePackageClasses = {BookController.class, BookService.class})
@EntityScan(basePackageClasses = Book.class)
@EnableJpaRepositories(basePackageClasses = BookRepository.class)
@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

}
