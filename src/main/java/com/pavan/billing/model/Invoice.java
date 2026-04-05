package com.pavan.billing.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private double amount;
    private double tax;
    private double totalAmount;

    public Invoice() {}

    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }

    public double getAmount() { return amount; }

    public double getTax() { return tax; }

    public double getTotalAmount() { return totalAmount; }

    public void setId(Long id) { this.id = id; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public void setAmount(double amount) { this.amount = amount; }

    public void setTax(double tax) { this.tax = tax; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}