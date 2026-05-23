package com.bookapp.bookApp.Repository;

import com.bookapp.bookApp.entity.BookEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookEntryRepository extends MongoRepository <BookEntry, ObjectId> {

}



/*controller---> service---> Repo*/