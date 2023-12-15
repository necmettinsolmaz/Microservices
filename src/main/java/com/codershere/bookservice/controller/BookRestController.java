package com.codershere.bookservice.controller;

import com.codershere.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    Environment environment;

    @GetMapping("/data")
    public String getBookData(){
        return "data of BOOK-SERVICE, running on port:" +
                environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return new Book(id, "Saatleri Ayarlama Enstitüsü", 120.0);
    }

    @GetMapping("/all")
    public List<Book> getAll(){
        return List.of(
                new Book(66, "Dorian Gray'in Portresi", 75.3),
                new Book(67, "İrade Terbiyesi", 80.05),
                new Book(68, "Masumiyet Müzesi", 66.0)
        );
    }
    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData(){
        return new ResponseEntity<String>(
                "Hello from BookRestController", HttpStatus.OK
        );
    }
}
