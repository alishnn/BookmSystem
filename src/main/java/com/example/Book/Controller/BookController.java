package com.example.Book.Controller;

import com.example.Book.Model.book;
import com.example.Book.Service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    public bookService bookService;

    @GetMapping("/list")
    public ResponseEntity<List<book>> getAllbook()
    {
        try {
            return new ResponseEntity<>(bookService.getAllbook(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<book>> getbook(@PathVariable("id") String bookid)
    {
        try {
            return new ResponseEntity<>(bookService.getBook(bookid),HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }



    @PostMapping("/list/add")
    public ResponseEntity<book> Addnames(@RequestBody book book)
    {
        try
        {
            return new ResponseEntity<>(bookService.Addbook(book),HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/list/{id}")
    public ResponseEntity<String> updateNames(@RequestBody book book, @PathVariable("id") String bookid)
    {
        try
        {
            return new ResponseEntity<>(bookService.updateBook(book,bookid),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") String bookid)
    {
        try
        {
            bookService.deleteBook(bookid);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookid+" was deleted",HttpStatus.OK);
    }
}
