package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.RentalService;
import com.turkcell.library.system.business.dto.request.rental.AddRentalRequest;
import com.turkcell.library.system.business.dto.request.rental.UpdateRentalRequest;
import com.turkcell.library.system.business.dto.response.rental.AddRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetAllRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetByIdRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.UpdateRentalResponse;
import com.turkcell.library.system.business.rules.RentalBusinessRule;
import com.turkcell.library.system.core.utilities.mappers.RentalMapper;
import com.turkcell.library.system.dataAccess.abstracts.RentalRepository;
import com.turkcell.library.system.entities.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    private final RentalBusinessRule rentalBusinessRule;

    @Override
    public AddRentalResponse addRental(AddRentalRequest addRentalRequest) {
        this.rentalBusinessRule.checkIfDatesIsNormal(addRentalRequest.getStartDate(),addRentalRequest.getEndDate());
        Rental rental = RentalMapper.INSTANCE.rentalFromAddRequest(addRentalRequest);
        Rental savedRental = this.rentalRepository.save(rental);
        return RentalMapper.INSTANCE.AddRentalResponseFromRental(savedRental);
    }

    @Override
    public UpdateRentalResponse updateRental(UpdateRentalRequest updateRentalRequest) {
        Rental rental = RentalMapper.INSTANCE.rentalFromUpdateRequest(updateRentalRequest);
        Rental updatedRental = this.rentalRepository.save(rental);
        return RentalMapper.INSTANCE.updateResponseFromRental(updatedRental);
    }

    @Override
    public GetByIdRentalResponse getByIdRental(int id) {
        Rental rental = this.rentalRepository.findById(id).orElseThrow();
        return RentalMapper.INSTANCE.getByIdResponseFromRental(rental);
    }

    @Override
    public List<GetAllRentalResponse> getAllRental() {
        List<Rental> rentals = this.rentalRepository.findAll();
        return RentalMapper.INSTANCE.getAllRentalResponseFromRentals(rentals);
    }

    @Override
    public void deleteRental(int id) {
        this.rentalRepository.deleteById(id);
    }
}
