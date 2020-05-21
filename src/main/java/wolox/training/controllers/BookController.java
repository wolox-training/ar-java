package wolox.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import wolox.training.models.Book;
import wolox.training.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public final Iterable findAll() {
        return bookService.findAll();
    }

    @GetMapping("/title/{bookAuthor}")
    public final Book findOneByAuthor(@PathVariable final String bookAuthor) {
        return bookService.findOneByAuthor(bookAuthor);
    }

    @GetMapping("/{id}")
    public final Book findOne(@PathVariable final Long id) {
        return bookService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public final Book create(@RequestBody final Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/{id}")
    public final void delete(@PathVariable final Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    public final Book updateBook(@RequestBody final Book book, @PathVariable final Long id) {
        return bookService.update(book, id);
    }
}
