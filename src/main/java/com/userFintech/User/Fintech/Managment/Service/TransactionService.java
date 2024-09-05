package com.userFintech.User.Fintech.Managment.Service;

import com.userFintech.User.Fintech.Managment.Model.Transaction;
import com.userFintech.User.Fintech.Managment.Repository.TransactionRepository;
import com.userFintech.User.Fintech.Managment.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public Transaction processTransaction(String userId, double amount, String type){
        User user = userService.getUserById(userId).orElseThrow();
        if(type.equals("debit") && user.getBalance() < amount){
            throw new IllegalStateException("Insufficient balance");
        }
        double updateAmount = type.equals("debit") ? -amount : amount;
        userService.updateUserBalance(user, updateAmount);

        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        transaction.setType(type);

        return transactionRepository.save(transaction);
    }
    public List<Transaction> getTransactionsByUser(String userId) {
        return transactionRepository.findByUserId(userId);
    }
}
