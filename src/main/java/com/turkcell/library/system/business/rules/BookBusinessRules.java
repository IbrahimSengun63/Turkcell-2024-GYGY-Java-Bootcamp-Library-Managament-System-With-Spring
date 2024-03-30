package com.turkcell.library.system.business.rules;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import com.turkcell.library.system.dataAccess.abstracts.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookBusinessRules {
    private final BookRepository bookRepository;

    public void checkIfBookNameExists(String name) {
        if (this.bookRepository.existsByName(name)) {
            throw new BusinessException("Book already exists");
        }
    }
}