package com.bookapp.bookApp.controller;

import com.bookapp.bookApp.Repository.BookEntryRepository;
import com.bookapp.bookApp.entity.BookEntry;
import com.bookapp.bookApp.entity.User;
import com.bookapp.bookApp.service.BookEntryService;
import com.bookapp.bookApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/books") /*controller gives only the end point and call the service*/
public class BookEntryControllerv2 {

    private BookEntryService bookEntryService;
    public BookEntryControllerv2(BookEntryService  bookEntryService) {
        this.bookEntryService = bookEntryService;
    }

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<BookEntry>> getAll() {
        List<BookEntry> allBooks=bookEntryService.findAllBookEntries();
        if(allBooks!=null){
            return ResponseEntity.ok(allBooks);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("{username}")
    public ResponseEntity<List<BookEntry>> getBookEntriesByUserName(@PathVariable String username) {
        User user=userService.findUserByUserName(username);
        List<BookEntry> allBooks=user.getBookEntries();
        if(allBooks!=null){
            return ResponseEntity.ok(allBooks);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/add")
    public ResponseEntity<BookEntry> createBookEntry(@RequestBody BookEntry bookEntry) {
        bookEntry.setDate(LocalDate.now());
        bookEntryService.saveEntryBook(bookEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookEntry);
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<String> getBookEntryById(@PathVariable(name = "myid") ObjectId id) {
        Optional<BookEntry> bookEntryById = bookEntryService.findBookEntryById(id);
       if(bookEntryById.isPresent()) {
            return ResponseEntity.ok(bookEntryById.toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Entry with id " + id + " not found");
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<String> updateBookEntry(@PathVariable ObjectId id,@RequestBody BookEntry newBookEntry) {
        BookEntry bookEntry=bookEntryService.findBookEntryById(id).orElse(null);
        if(bookEntry!=null){
        String newAuthor=newBookEntry.getAuthor();
        String oldAuthor=bookEntry.getAuthor();
        String newTitle=newBookEntry.getTitle();
        String oldTitle=bookEntry.getTitle();
        int newPrice=newBookEntry.getPrice();
        int oldPrice=bookEntry.getPrice();
            bookEntry.setAuthor(!newAuthor.equals(" ") ?newAuthor: oldAuthor);
            bookEntry.setTitle(newTitle!=null && !newTitle.equals(" ")?newTitle:oldTitle);
            bookEntry.setPrice(newPrice!=0?newPrice:oldPrice);
            bookEntryService.saveEntryBook(bookEntry);
            return ResponseEntity.accepted().body("Book Entry with ID " + id + " is Updated"+bookEntry.toString());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookEntry(@PathVariable ObjectId id) {
        bookEntryService.deleteBookEntryById(id);
        return ResponseEntity.ok("Book Entry with id " + id + " deleted");
    }
}
