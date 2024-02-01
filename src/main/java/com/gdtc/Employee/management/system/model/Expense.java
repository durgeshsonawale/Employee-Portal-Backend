package com.gdtc.Employee.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Integer cost;
    private String comment;
    private String date;
    private Integer approverId;
    private ExpenseStatus status = ExpenseStatus.PENDING;
    private ExpenseType expense1;

    @ManyToOne
    private Employee employeeId;

}

