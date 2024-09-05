package com.userFintech.User.Fintech.Managment.Controller;

import com.userFintech.User.Fintech.Managment.Model.Transaction;
import com.userFintech.User.Fintech.Managment.Service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/{userId}")
    public ResponseEntity<Transaction> processTransaction(
            @PathVariable String userId,
            @RequestParam double amount,
            @RequestParam String type // credit or debit
    ) {
        return ResponseEntity.ok(transactionService.processTransaction(userId, amount, type));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(transactionService.getTransactionsByUser(userId));
    }
}