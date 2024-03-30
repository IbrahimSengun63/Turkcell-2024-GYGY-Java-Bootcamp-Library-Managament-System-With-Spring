package com.turkcell.library.system.dataAccess.abstracts;

import com.turkcell.library.system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa db built in methods accessed by extending jpa repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    boolean existsByName(String name);
}