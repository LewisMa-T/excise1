package com.galvanize.tmo.paspringstarter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {

    private List<Book> books = new ArrayList<Book>();

    @GetMapping("/health")
    public void health() {

    }

    @PostMapping (value = "/api/books")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        book.setId(books.size() + 1);
        books.add(book);

        return book;
    }

    @GetMapping(value = "/api/books")
    public Map<String, List<Book>> getBooks () {
        Map<String, List<Book>> map = new HashMap<>();
        map.put("books", books);

        return map;
    }

    @DeleteMapping(value = "/api/books")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBooks() {
        books = new ArrayList<>();
    }
}
