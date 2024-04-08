package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.abstracts.TransactionService;
import com.turkcell.library.system.business.dto.request.transaction.AddTransactionRequest;
import com.turkcell.library.system.business.dto.request.transaction.UpdateTransactionRequest;
import com.turkcell.library.system.business.dto.response.transaction.AddTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetAllTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetByIdTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.UpdateTransactionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionsController {
    private final TransactionService transactionService;

    @PostMapping("/addTransaction")
    public ResponseEntity<AddTransactionResponse> addTransaction(@RequestBody @Valid AddTransactionRequest addTransactionRequest) {
        AddTransactionResponse response = this.transactionService.addTransaction(addTransactionRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdTransactionResponse getByIdTransaction(@PathVariable int id) {
        return this.transactionService.getByIdTransaction(id);
    }

    @GetMapping("/getAll")
    public List<GetAllTransactionResponse> getAllTransaction() {
        return transactionService.getAllTransaction();
    }

    @PutMapping("/updateTransaction")
    public ResponseEntity<UpdateTransactionResponse> updateTransaction(@RequestBody UpdateTransactionRequest updateTransactionRequest) {
        UpdateTransactionResponse response = this.transactionService.updateTransaction(updateTransactionRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/deleteRental/{id}")
    public void deleteRental(@PathVariable int id) {
        this.transactionService.deleteTransaction(id);
    }
}
