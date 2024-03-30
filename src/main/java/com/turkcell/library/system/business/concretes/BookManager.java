package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.BookService;
import com.turkcell.library.system.business.dto.request.book.AddBookRequest;
import com.turkcell.library.system.business.dto.request.book.UpdateBookRequest;
import com.turkcell.library.system.business.dto.response.book.AddBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetAllBookResponse;
import com.turkcell.library.system.business.dto.response.book.GetByIdBookResponse;
import com.turkcell.library.system.business.dto.response.book.UpdateBookResponse;
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
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        this.bookBusinessRules.checkIfBookNameExists(addBookRequest.getName());
        Book book = BookMapper.INSTANCE.bookFromAddRequest(addBookRequest);
        Book savedBook = this.bookRepository.save(book);
        return BookMapper.INSTANCE.bookFromAddResponse(savedBook);
    }

    @Override
    public GetByIdBookResponse getBookById(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow();
        return BookMapper.INSTANCE.bookFromGetByIdResponse(book);
    }

    @Override
    public List<GetAllBookResponse> getAllBook() {
        List<Book> books = this.bookRepository.findAll();
        return BookMapper.INSTANCE.bookFromGetAllBookResponse(books);
    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookRequest updateBookRequest) {
        Book book = BookMapper.INSTANCE.bookFromUpdateRequest(updateBookRequest);
        Book savedBook = this.bookRepository.save(book);
        return BookMapper.INSTANCE.bookFromUpdateResponse(savedBook);
    }

    @Override
    public void deleteBook(int id) {
        this.bookRepository.deleteById(id);
    }
}
