package com.turkcell.library.system.webApi.controllers;


import com.turkcell.library.system.business.abstracts.BookService;
import com.turkcell.library.system.business.dto.request.book.AddRequestBook;
import com.turkcell.library.system.business.dto.request.book.UpdateRequestBook;
import com.turkcell.library.system.business.dto.response.book.AddResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetAllResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetByIdResponseBook;
import com.turkcell.library.system.business.dto.response.book.UpdateResponseBook;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor

public class BooksController {
    //dependency injection
    //web api end point connected to db via business layer
    private final BookService bookService;

    @PostMapping("/add")

    public ResponseEntity<AddResponseBook> addBook(@RequestBody @Valid AddRequestBook addRequestBook) {

        AddResponseBook response = this.bookService.addBook(addRequestBook);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdResponseBook getByIdBook(@PathVariable int id) {
        return this.bookService.getByIdBook(id);
    }

    @GetMapping("/getAll")
    public List<GetAllResponseBook> getAllBook() {
        return this.bookService.getAllBook();
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateResponseBook> updateBook(@RequestBody UpdateRequestBook updateRequestBook) {
        UpdateResponseBook response = this.bookService.updateBook(updateRequestBook);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        this.bookService.deleteBook(id);
    }
}