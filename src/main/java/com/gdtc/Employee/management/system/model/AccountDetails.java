package com.gdtc.Employee.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String bankName;
    private String ifscCode;
    private String branch;
    private String nameOnAccount;
    private Integer accountNumber;


    @OneToOne
    private Employee employeeId;


}
