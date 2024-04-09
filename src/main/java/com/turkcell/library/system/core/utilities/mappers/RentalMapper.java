package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.rental.AddRequestRental;
import com.turkcell.library.system.business.dto.request.rental.UpdateRequestRental;
import com.turkcell.library.system.business.dto.response.rental.*;
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


    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "id", target = "rentalId")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.name", target = "bookName")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "book.available", target = "available")
    ListResponseRentals rentalToListResponse(Rental rental);

    List<ListResponseRentals> rentalsToListResponse(List<Rental> rentals);
}
