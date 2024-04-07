package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.abstracts.RentalService;
import com.turkcell.library.system.business.dto.request.rental.AddRentalRequest;
import com.turkcell.library.system.business.dto.request.rental.UpdateRentalRequest;
import com.turkcell.library.system.business.dto.response.rental.AddRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetAllRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.GetByIdRentalResponse;
import com.turkcell.library.system.business.dto.response.rental.UpdateRentalResponse;
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

    @PostMapping("/addRental")
    public ResponseEntity<AddRentalResponse> addRental(@RequestBody @Valid AddRentalRequest addRentalRequest) {
        AddRentalResponse response = this.rentalService.addRental(addRentalRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdRentalResponse getByIdRental(@PathVariable int id) {
        return this.rentalService.getByIdRental(id);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalResponse> getAllRental() {
        return this.rentalService.getAllRental();
    }

    @PutMapping("/updateRental")
    public ResponseEntity<UpdateRentalResponse> updateRental(UpdateRentalRequest updateRentalRequest) {
        UpdateRentalResponse response = this.rentalService.updateRental(updateRentalRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/deleteRental/{id}")
    public void deleteRental(@PathVariable int id) {
        this.rentalService.deleteRental(id);
    }
}
