package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import persistence.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
