/*
package com.bookapp.bookApp.controller;

import com.bookapp.bookApp.entity.BookEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookEntryController {

    private final Map<Integer, BookEntry> bookEntries =new HashMap<>();

    @GetMapping("/book")
    public List<BookEntry> getBookEntries() {
        return new ArrayList<>(bookEntries.values());
    }

    @PostMapping("/add")
    public boolean createBookEntry(@RequestBody BookEntry bookEntry) {
        bookEntries.put(bookEntry.getId(), bookEntry);
        return true;
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<String> getBookEntryById(@PathVariable(name = "myid") int id) {
        if(bookEntries.containsKey(id)) {
            return ResponseEntity.ok(bookEntries.get(id).toString());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Entry with id " + id + " not found");
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<String> updateBookEntry(@PathVariable int id,@RequestBody BookEntry bookEntry) {
         bookEntries.put(id, bookEntry);
        return ResponseEntity.ok("Book Entry with id " + id + " updated");
    }
}
*/
