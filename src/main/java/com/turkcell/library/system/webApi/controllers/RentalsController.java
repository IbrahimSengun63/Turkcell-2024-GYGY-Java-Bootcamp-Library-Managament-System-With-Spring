package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.abstracts.RentalService;
import com.turkcell.library.system.business.dto.request.rental.AddRequestRental;
import com.turkcell.library.system.business.dto.request.rental.UpdateRequestRental;
import com.turkcell.library.system.business.dto.response.rental.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalsController {
    private final RentalService rentalService;

    @PostMapping("/add")
    public ResponseEntity<AddResponseRental> addRental(@RequestBody @Valid AddRequestRental addRequestRental) {
        AddResponseRental response = this.rentalService.addRental(addRequestRental);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdResponseRental getByIdRental(@PathVariable int id) {
        return this.rentalService.getByIdRental(id);
    }

    @GetMapping("/getAll")
    public List<GetAllResponseRental> getAllRental() {
        return this.rentalService.getAllRental();
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateResponseRental> updateRental(@RequestBody @Valid UpdateRequestRental updateRequestRental) {
        UpdateResponseRental response = this.rentalService.updateRental(updateRequestRental);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRental(@PathVariable int id) {
        this.rentalService.deleteRental(id);
    }

    @GetMapping("/getRentalsByMember/{id}")
    public List<ListResponseRentals> getRentalsByMember(@PathVariable int id) {
        return this.rentalService.listMemberRentals(id);
    }
}
