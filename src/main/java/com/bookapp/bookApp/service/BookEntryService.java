package com.bookapp.bookApp.service;

import com.bookapp.bookApp.Repository.BookEntryRepository;
import com.bookapp.bookApp.entity.BookEntry;
import com.bookapp.bookApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/*business logic will be he*/
@Component
public class BookEntryService {

    @Autowired
    private BookEntryRepository bookEntryRepository;

    public void saveEntryBook(BookEntry bookEntry){
        bookEntryRepository.save(bookEntry);
    }
    public List<BookEntry> findAllBookEntries(){
        return bookEntryRepository.findAll();
    }
    public Optional<BookEntry> findBookEntryById(ObjectId id){
        return bookEntryRepository.findById(id);
    }
    public void  deleteBookEntryById(ObjectId id){
        bookEntryRepository.deleteById(id);
    }

}
