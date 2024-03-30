package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.book.AddBookRequest;
import com.turkcell.library.system.business.dto.request.book.UpdateBookRequest;
import com.turkcell.library.system.business.dto.response.book.AddBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetAllBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetByIdBookResponse;
import com.turkcell.library.system.business.dto.response.book.UpdateBookResponse;

import java.util.List;

public interface BookService {
    //Book entity replaced with DTO object to apply restriction on db access
    AddBookResponse addBook(AddBookRequest addBookRequest);

    GetByIdBookResponse getBookById(int id);

    List<GetAllBookResponse> getAllBook();

    UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest);

    void deleteBook(int id);
}