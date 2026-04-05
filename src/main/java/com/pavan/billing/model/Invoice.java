package com.pavan.billing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is required")
    @Size(min=2, max=50, message = "Customer name must be between 2 - 50 characters")
    private String customerName;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    private double tax;

    private double totalAmount;

    // Default constructor
    public Invoice() {}

    // Getters
    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }

    public double getAmount() { return amount; }

    public double getTax() { return tax; }

    public double getTotalAmount() { return totalAmount; }

    // Setters
    public void setId(Long id) { this.id = id; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public void setAmount(double amount) { this.amount = amount; }

    public void setTax(double tax) { this.tax = tax; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}