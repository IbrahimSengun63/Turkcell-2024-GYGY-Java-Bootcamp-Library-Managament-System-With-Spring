package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.book.AddRequestBook;
import com.turkcell.library.system.business.dto.request.book.UpdateRequestBook;
import com.turkcell.library.system.business.dto.response.book.AddResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetAllResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetByIdResponseBook;
import com.turkcell.library.system.business.dto.response.book.UpdateResponseBook;
import com.turkcell.library.system.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book addRequestToBook(AddRequestBook addRequestBook);
    AddResponseBook bookToAddResponse(Book book);

    Book updateRequestToBook(UpdateRequestBook updateRequestBook);
    UpdateResponseBook bookToUpdateResponse(Book book);

    GetByIdResponseBook bookToGetByIdResponse(Book book);

    List<GetAllResponseBook> booksToGetAllResponse(List<Book> books);
}