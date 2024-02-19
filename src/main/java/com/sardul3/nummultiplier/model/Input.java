package com.sardul3.nummultiplier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing an input number and its processed values.
 */
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

    /**
     * Constructor for creating an Input object with the given number and processed values.
     *
     * @param number            The original input number.
     * @param result   The processed number (doubled).
     * @param resultSquared The squared processed number.
     */
    public Input(int number, int result, int resultSquared) {
        this.number = number;
        this.processedNumber = result;
        this.processedNumberSquared = resultSquared;
    }
}