package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.book.AddBookRequest;
import com.turkcell.library.system.business.dto.request.book.UpdateBookRequest;
import com.turkcell.library.system.business.dto.response.book.AddBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetAllBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetByIdBookResponse;
import com.turkcell.library.system.business.dto.response.book.UpdateBookResponse;
import com.turkcell.library.system.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book bookFromAddRequest(AddBookRequest request);
    AddBookResponse bookFromAddResponse(Book book);

    Book bookFromUpdateRequest(UpdateBookRequest request);
    UpdateBookResponse bookFromUpdateResponse(Book book);

    GetByIdBookResponse bookFromGetByIdResponse(Book book);

    List<GetAllBookResponse> bookFromGetAllBookResponse(List<Book> book);
}