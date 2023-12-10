package com.yeswanth.expensetrackerapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expense")
public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name ="expense_name")
    @NotBlank(message = "Expense name must not be null")
    @Size(min =3, message ="Expense name must be atleast 3 characters")
    private String name;


    private String description;

    @Column(name ="expense_amount")
    @NotNull(message ="Expense amount should not be null")
    private BigDecimal amount;

    @NotNull(message = "Category should not be null")
    private String Category;

    @NotNull(message = "Date must not be null")
    private Date date;

    @Column(name ="created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name ="updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

}
