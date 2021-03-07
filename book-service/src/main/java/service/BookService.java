package service;

import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.entity.Book;
import persistence.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAllBook(){
        return repository.findAll();
    }

    public Book findById(String bookId) throws NotFoundException {
        return repository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book Not Found with ID : " + bookId));
    }

    public void createBook(Book book){
        repository.save(book);
    }

    public void updateBook(Book book, String bookId) {
        repository.findById(bookId)
                .map(request -> {
                    request.setTitle(book.getTitle());
                    request.setAuthor(book.getAuthor());

                    return repository.save(request);
                });
    }

    public void deleteBook(String bookId){
        repository.deleteById(bookId);
    }

}
