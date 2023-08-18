package com.example.Book.Repository;

import com.example.Book.Model.book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface bookRepository extends MongoRepository<book, String> {

    public Optional<book> findBybookId(String bookid);

    public void delete(book foundbook);
}