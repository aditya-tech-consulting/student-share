package org.open.library.service;

import org.open.library.data.Book;
import org.open.library.data.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    Logger log = LoggerFactory.getLogger(BookController.class);


    @GetMapping
    public ResponseEntity list(){
        Iterable<Book> books = bookRepository.findAll();
        log.info("INFO:LIST: Finding All Books");
        return new ResponseEntity(books, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity get(Long id){
        Optional<Book> book= null;
        log.info("INFO:GET: Finding  Book by ID");
        try{
           book =  bookRepository.findById(id);

        }catch (Exception e){
            log.info("INFO:GET: Exception in Finding  Book by ID");
            return new ResponseEntity("Book Not Found", HttpStatus.NO_CONTENT);
        }

        if(!book.isEmpty()){
            log.info("INFO:GET: Found  Book by ID");
            return new ResponseEntity(book, HttpStatus.OK);
        }else{
            log.info("INFO:GET: No Books Found  by ID");
            return new ResponseEntity("No Books Found", HttpStatus.NO_CONTENT);
        }


    }

    @PostMapping
    public ResponseEntity create(@RequestBody  Book book){
        book = bookRepository.save(book);
        log.info("INFO:CREATE: Successfully Created the Book Object");
        return new ResponseEntity(book,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody  Book book,Long id){
        if(bookRepository.existsById(id)){
            book = bookRepository.save(book);
            log.info("INFO:CREATE: Successfully Updated the Book Object");
            return new ResponseEntity(book,HttpStatus.OK);
        }else{
            log.info("INFO:CREATE: No Book Found for Update");
            return new ResponseEntity("No Books Found",HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(Long id){
        bookRepository.deleteById(id);
        log.info("INFO:DELETE: Book is Deleted");
        return new ResponseEntity("Book Entry Deleted",HttpStatus.OK);
    }

}
