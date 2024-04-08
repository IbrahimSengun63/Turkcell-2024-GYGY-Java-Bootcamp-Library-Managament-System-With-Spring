package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.book.AddRequestBook;
import com.turkcell.library.system.business.dto.request.book.UpdateRequestBook;
import com.turkcell.library.system.business.dto.response.book.AddResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetAllResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetByIdResponseBook;
import com.turkcell.library.system.business.dto.response.book.UpdateResponseBook;

import java.util.List;

public interface BookService {
    //Book entity replaced with DTO object to apply restriction on db access
    AddResponseBook addBook(AddRequestBook addRequestBook);

    GetByIdResponseBook getByIdBook(int id);

    List<GetAllResponseBook> getAllBook();

    UpdateResponseBook updateBook(UpdateRequestBook updateRequestBook);

    void deleteBook(int id);
}