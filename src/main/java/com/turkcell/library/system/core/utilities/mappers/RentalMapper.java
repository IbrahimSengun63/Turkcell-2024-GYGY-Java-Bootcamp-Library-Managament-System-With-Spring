package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.rental.AddRequestRental;
import com.turkcell.library.system.business.dto.request.rental.UpdateRequestRental;
import com.turkcell.library.system.business.dto.response.rental.AddResponseRental;
import com.turkcell.library.system.business.dto.response.rental.GetAllResponseRental;
import com.turkcell.library.system.business.dto.response.rental.GetByIdResponseRental;
import com.turkcell.library.system.business.dto.response.rental.UpdateResponseRental;
import com.turkcell.library.system.entities.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RentalMapper {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    Rental addRequestToRental(AddRequestRental addRequestRental);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "book.id", target = "bookId")
    AddResponseRental rentalToAddResponse(Rental rental);

    Rental updateRequestToRental(UpdateRequestRental updateRequestRental);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "book.id", target = "bookId")
    UpdateResponseRental rentalToUpdateResponse(Rental rental);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.name", target = "bookName")
    GetByIdResponseRental rentalToGetByIdResponse(Rental rental);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.name", target = "bookName")
    GetAllResponseRental rentalToGetAllResponse(Rental rental);

    List<GetAllResponseRental> rentalsToGetAllResponse(List<Rental> rentals);
}
