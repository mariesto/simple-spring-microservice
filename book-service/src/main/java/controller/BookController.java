package controller;

import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import persistence.entity.Book;
import service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    private List<Book> findAllBook(){
        return service.findAllBook();
    }

    @GetMapping("/{bookId}")
    private Book findBookById(@PathVariable String bookId) throws NotFoundException {
        return service.findById(bookId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private void createBook(@RequestBody Book book){
        service.createBook(book);
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    private void updateBook(@RequestBody Book book, @PathVariable String bookId) {
        service.updateBook(book, bookId);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteBook(@PathVariable String bookId){
        service.deleteBook(bookId);
    }
}
