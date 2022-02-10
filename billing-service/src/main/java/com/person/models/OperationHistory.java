package com.person.models;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation_history")
public class OperationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "operation", nullable = false)
    private Operation operation;


    public OperationHistory(){}

    public OperationHistory(Double amount, Operation operation){
        this.amount = amount;
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OperationHistory that = (OperationHistory) o;
        return Objects.equals(id, that.id)  && Objects.equals(amount, that.amount)
            && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, operation);
    }

    @Override
    public String toString() {
        return "OperationHistory{" +
            "id=" + id +
            ", amount=" + amount +
            ", operation=" + operation +
            '}';
    }
}
