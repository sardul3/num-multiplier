package com.sardul3.nummultiplier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private int processedNumber;
    private int processedNumberSquared;

    public Input(int number, int result, int resultSquared) {
        this.number = number;
        this.processedNumber = result;
        this.processedNumberSquared = resultSquared;
    }
}