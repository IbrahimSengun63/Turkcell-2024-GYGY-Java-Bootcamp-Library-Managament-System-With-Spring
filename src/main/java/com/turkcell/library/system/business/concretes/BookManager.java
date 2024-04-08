package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.BookService;
import com.turkcell.library.system.business.dto.request.book.AddRequestBook;
import com.turkcell.library.system.business.dto.request.book.UpdateRequestBook;
import com.turkcell.library.system.business.dto.response.book.AddResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetAllResponseBook;
import com.turkcell.library.system.business.dto.response.book.GetByIdResponseBook;
import com.turkcell.library.system.business.dto.response.book.UpdateResponseBook;
import com.turkcell.library.system.business.rules.BookBusinessRules;
import com.turkcell.library.system.core.utilities.mappers.BookMapper;
import com.turkcell.library.system.dataAccess.abstracts.BookRepository;
import com.turkcell.library.system.entities.Book;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class BookManager implements BookService {

    private final BookRepository bookRepository;
    private final BookBusinessRules bookBusinessRules;

    @Override
    public AddResponseBook addBook(AddRequestBook addRequestBook) {
        this.bookBusinessRules.checkIfBookNameExists(addRequestBook.getName());
        Book book = BookMapper.INSTANCE.addRequestToBook(addRequestBook);
        Book savedBook = this.bookRepository.save(book);
        return BookMapper.INSTANCE.bookToAddResponse(savedBook);
    }

    @Override
    public GetByIdResponseBook getByIdBook(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow();
        return BookMapper.INSTANCE.bookToGetByIdResponse(book);
    }

    @Override
    public List<GetAllResponseBook> getAllBook() {
        List<Book> books = this.bookRepository.findAll();
        return BookMapper.INSTANCE.booksToGetAllResponse(books);
    }

    @Override
    public UpdateResponseBook updateBook(UpdateRequestBook updateRequestBook) {
        Book book = BookMapper.INSTANCE.updateRequestToBook(updateRequestBook);
        Book savedBook = this.bookRepository.save(book);
        return BookMapper.INSTANCE.bookToUpdateResponse(savedBook);
    }

    @Override
    public void deleteBook(int id) {
        this.bookRepository.deleteById(id);
    }
}
