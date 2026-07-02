package com.library;
import org.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/books")
public class BookController {
    private final BookRepository repository;
    public BookController(BookRepository repository) { this.repository = repository; }
    @GetMapping public List<Book> getAll() { return repository.findAll(); }
    @PostMapping public Book add(@RequestBody Book book) { return repository.save(book); }
}
