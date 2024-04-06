package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.rental.AddRentalRequest;
import com.turkcell.library.system.business.dto.request.rental.UpdateRentalRequest;
import com.turkcell.library.system.business.dto.response.rental.AddRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetAllRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetByIdRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.UpdateRentalResponse;
import com.turkcell.library.system.entities.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RentalMapper {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    Rental rentalFromAddRequest(AddRentalRequest request);
    AddRentalResponse AddRentalResponseFromRental(Rental rental);

    Rental rentalFromUpdateRequest(UpdateRentalRequest request);
    UpdateRentalResponse UpdateResponseFromRental(Rental rental);

    @Mapping(source = "name",target = "member.id")
    @Mapping(source = "name",target = "book.id")
    GetByIdRentalResponse GetByIdResponseFromRental(Rental rental);

    @Mapping(source = "name",target = "member.id")
    @Mapping(source = "name",target = "book.id")
    List<GetAllRentalResponse> GetAllRentalResponseFromRentals(List<Rental> rentals);
}
