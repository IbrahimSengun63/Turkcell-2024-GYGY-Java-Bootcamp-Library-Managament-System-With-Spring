package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.abstracts.TransactionService;
import com.turkcell.library.system.business.dto.request.transaction.AddRequestTransaction;
import com.turkcell.library.system.business.dto.request.transaction.UpdateRequestTransaction;
import com.turkcell.library.system.business.dto.response.transaction.AddResponseTransaction;
import com.turkcell.library.system.business.dto.response.transaction.GetAllResponseTransaction;
import com.turkcell.library.system.business.dto.response.transaction.GetByIdResponseTransaction;
import com.turkcell.library.system.business.dto.response.transaction.UpdateResponseTransaction;
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

    @PostMapping("/add")
    public ResponseEntity<AddResponseTransaction> addTransaction(@RequestBody @Valid AddRequestTransaction addRequestTransaction) {
        AddResponseTransaction response = this.transactionService.addTransaction(addRequestTransaction);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdResponseTransaction getByIdTransaction(@PathVariable int id) {
        return this.transactionService.getByIdTransaction(id);
    }

    @GetMapping("/getAll")
    public List<GetAllResponseTransaction> getAllTransaction() {
        return transactionService.getAllTransaction();
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateResponseTransaction> updateTransaction(@RequestBody UpdateRequestTransaction updateRequestTransaction) {
        UpdateResponseTransaction response = this.transactionService.updateTransaction(updateRequestTransaction);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable int id) {
        this.transactionService.deleteTransaction(id);
    }
}
