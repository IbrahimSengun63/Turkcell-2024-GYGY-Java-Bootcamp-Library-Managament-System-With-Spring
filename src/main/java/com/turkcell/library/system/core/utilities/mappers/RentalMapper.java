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
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface RentalMapper {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    Rental rentalFromAddRequest(AddRentalRequest request);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "book.id", target = "bookId")
    AddRentalResponse AddRentalResponseFromRental(Rental rental);

    Rental rentalFromUpdateRequest(UpdateRentalRequest request);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "book.id", target = "bookId")
    UpdateRentalResponse updateResponseFromRental(Rental rental);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.name", target = "bookName")
    GetByIdRentalResponse getByIdResponseFromRental(Rental rental);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.name", target = "bookName")
    GetAllRentalResponse rentalToGetAllRentalResponse(Rental rental);

    List<GetAllRentalResponse> getAllRentalResponseFromRentals(List<Rental> rentals);
}
