package com.turkcell.library.system.business.rules;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import com.turkcell.library.system.dataAccess.abstracts.BookRepository;
import com.turkcell.library.system.dataAccess.abstracts.MemberRepository;
import com.turkcell.library.system.dataAccess.abstracts.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RentalBusinessRule {
    private final RentalRepository rentalRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public void checkIfDatesIsNormal(LocalDate startDate,LocalDate endDate) {
        if(endDate.isBefore(startDate)) {
            throw new BusinessException("End date can not before start date");
        }
    }

    public void checkIfRentalExists(int id) {
        if (this.rentalRepository.findById(id).isEmpty()) {
            throw new BusinessException("Rental with " + id + " id couldn't be found");
        }
    }

    public void checkIfMemberExists(int id) {
        if (this.memberRepository.findById(id).isEmpty()) {
            throw new BusinessException("Member with " + id + " id couldn't be found");
        }
    }

    public void checkIfBookExists(int id) {
        if (this.bookRepository.findById(id).isEmpty()) {
            throw new BusinessException("Book with " + id + " id couldn't be found");
        }
    }

}
