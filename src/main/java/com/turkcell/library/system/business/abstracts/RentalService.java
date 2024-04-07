package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.rental.AddRentalRequest;
import com.turkcell.library.system.business.dto.response.rental.AddRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetAllRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetByIdRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.UpdateRentalResponse;
import com.turkcell.library.system.entities.Rental;

import java.util.List;

public interface RentalService {
    AddRentalResponse addRental(AddRentalRequest addRentalRequest);
    UpdateRentalResponse updateRental(UpdateRentalResponse updateRentalResponse);
    GetByIdRentalResponse getByIdRental(int id);
    List<GetAllRentalResponse> getAllRental();
    void deleteRental(int id);
}
