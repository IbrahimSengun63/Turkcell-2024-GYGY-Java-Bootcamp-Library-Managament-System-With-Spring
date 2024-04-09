package com.turkcell.library.system.business.concretes;


import com.turkcell.library.system.business.abstracts.RentalService;
import com.turkcell.library.system.business.dto.request.rental.AddRequestRental;
import com.turkcell.library.system.business.dto.request.rental.UpdateRequestRental;
import com.turkcell.library.system.business.dto.response.rental.ListResponseRentals;
import com.turkcell.library.system.business.dto.response.rental.AddResponseRental;
import com.turkcell.library.system.business.dto.response.rental.GetAllResponseRental;
import com.turkcell.library.system.business.dto.response.rental.GetByIdResponseRental;
import com.turkcell.library.system.business.dto.response.rental.UpdateResponseRental;
import com.turkcell.library.system.business.rules.RentalBusinessRule;
import com.turkcell.library.system.core.utilities.mappers.RentalMapper;
import com.turkcell.library.system.dataAccess.abstracts.BookRepository;
import com.turkcell.library.system.dataAccess.abstracts.MemberRepository;
import com.turkcell.library.system.dataAccess.abstracts.RentalRepository;
import com.turkcell.library.system.entities.Member;
import com.turkcell.library.system.entities.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    private final RentalBusinessRule rentalBusinessRule;

    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;


    @Override
    public AddResponseRental addRental(AddRequestRental addRequestRental) {
        this.rentalBusinessRule.checkIfDatesIsNormal(addRequestRental.getStartDate(), addRequestRental.getEndDate());
        Rental rental = RentalMapper.INSTANCE.addRequestToRental(addRequestRental);
        rental.setMember(this.memberRepository.findById(addRequestRental.getMemberId()).orElseThrow());
        rental.setBook(this.bookRepository.findById(addRequestRental.getBookId()).orElseThrow());
        Rental savedRental = this.rentalRepository.save(rental);
        return RentalMapper.INSTANCE.rentalToAddResponse(savedRental);
    }

    @Override
    public UpdateResponseRental updateRental(UpdateRequestRental updateRequestRental) {
        Rental rental = RentalMapper.INSTANCE.updateRequestToRental(updateRequestRental);
        rental.setMember(this.memberRepository.findById(updateRequestRental.getMemberId()).orElseThrow());
        rental.setBook(this.bookRepository.findById(updateRequestRental.getBookId()).orElseThrow());
        Rental updatedRental = this.rentalRepository.save(rental);
        return RentalMapper.INSTANCE.rentalToUpdateResponse(updatedRental);
    }

    @Override
    public GetByIdResponseRental getByIdRental(int id) {
        Rental rental = this.rentalRepository.findById(id).orElseThrow();
        return RentalMapper.INSTANCE.rentalToGetByIdResponse(rental);
    }

    @Override
    public List<GetAllResponseRental> getAllRental() {
        List<Rental> rentals = this.rentalRepository.findAll();
        return RentalMapper.INSTANCE.rentalsToGetAllResponse(rentals);
    }

    @Override
    public void deleteRental(int id) {
        this.rentalRepository.deleteById(id);
    }

    @Override
    public List<ListResponseRentals> listMemberRentals(int id) {
        //business rule define
        Member member = this.memberRepository.findById(id).orElseThrow();
        List<Rental> rentals = this.rentalRepository.findByMemberId(id);
        member.setRentals(rentals);
        return RentalMapper.INSTANCE.rentalsToListResponse(rentals);
    }
}
