package com.example.Book.Service;

import com.example.Book.Model.book;
import com.example.Book.Repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookService {

    @Autowired
    public bookRepository bookrepo;

    public List<book> getAllbook() {
        return bookrepo.findAll();

    }

    public Optional<book> getBook(String bookid) {

        return bookrepo.findBybookId(bookid);
    }

    public book Addbook(book book) {

        return bookrepo.save(book);
    }

    public String updateBook(book names, String bookid) {
        Optional<book> bookData = bookrepo.findById(bookid);
        if (bookData.isPresent()) {
            book b = bookData.get();
            b.setBookName(names.getBookName());
            b.setBookGenre(names.getBookGenre());
            b.setBookAuthor(names.getBookAuthor());
            b.setBookTitle(names.getBookTitle());
            this.bookrepo.save(b);
            return "Books details are updated";
        } else {
            return "Books detail is not updated";
        }


    }

    public String deleteBook(String bookid) {
        bookrepo.deleteById(bookid);
        return bookid + " was deleted successfully";
    }
}

