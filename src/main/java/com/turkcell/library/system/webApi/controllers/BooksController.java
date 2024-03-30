package com.turkcell.library.system.webApi.controllers;


import com.turkcell.library.system.business.abstracts.BookService;
import com.turkcell.library.system.business.dto.request.book.AddBookRequest;
import com.turkcell.library.system.business.dto.request.book.UpdateBookRequest;
import com.turkcell.library.system.business.dto.response.book.AddBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetAllBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetByIdBookResponse;
import com.turkcell.library.system.business.dto.response.book.UpdateBookResponse;
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

    @PostMapping("/addBook")

    public ResponseEntity<AddBookResponse> add(@RequestBody @Valid AddBookRequest addBookRequest) {

        AddBookResponse response = this.bookService.addBook(addBookRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdBookResponse getById(@PathVariable int id) {
        return this.bookService.getBookById(id);
    }

    @GetMapping("/getAll")
    public List<GetAllBookResponse> getAll() {
        return this.bookService.getAllBook();
    }

    @PutMapping("/updateBook")
    public ResponseEntity<UpdateBookResponse> update(@RequestBody UpdateBookRequest updateBookRequest) {
        UpdateBookResponse response = this.bookService.updateBook(updateBookRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        this.bookService.deleteBook(id);
    }
}