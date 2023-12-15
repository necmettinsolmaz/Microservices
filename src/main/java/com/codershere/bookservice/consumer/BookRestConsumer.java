package com.codershere.bookservice.consumer;


import com.codershere.bookservice.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BookRestConsumer {
    @GetMapping("/book/data")
    public String getBookData();
    @GetMapping("/book/{id}")
    public String getBookById(@PathVariable Integer id);

    @GetMapping("/book/all")
    public List<Book> getall();
}
