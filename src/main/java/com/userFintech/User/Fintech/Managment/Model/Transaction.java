package com.userFintech.User.Fintech.Managment.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document(collection = "transaction")
@Data
public class Transaction {

    @Id
    private String id;
    private String userId;
    private double amount;
    private Date date;
    private String type; // "credit" or "debit"
}
