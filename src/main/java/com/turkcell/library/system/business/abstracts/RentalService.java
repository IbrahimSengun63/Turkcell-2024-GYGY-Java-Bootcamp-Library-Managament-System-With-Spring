package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.rental.AddRequestRental;
import com.turkcell.library.system.business.dto.request.rental.UpdateRequestRental;
import com.turkcell.library.system.business.dto.response.rental.ListResponseRentals;
import com.turkcell.library.system.business.dto.response.rental.AddResponseRental;
import com.turkcell.library.system.business.dto.response.rental.GetAllResponseRental;
import com.turkcell.library.system.business.dto.response.rental.GetByIdResponseRental;
import com.turkcell.library.system.business.dto.response.rental.UpdateResponseRental;

import java.util.List;

public interface RentalService {
    AddResponseRental addRental(AddRequestRental addRequestRental);

    UpdateResponseRental updateRental(UpdateRequestRental updateRequestRental);

    GetByIdResponseRental getByIdRental(int id);

    List<GetAllResponseRental> getAllRental();

    void deleteRental(int id);

    List<ListResponseRentals> listMemberRentals(int id);

}
