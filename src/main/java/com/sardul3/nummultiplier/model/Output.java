package com.sardul3.nummultiplier.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Output {
    private int numberMultiplied;
    private int numberMultipliedSquared;
}
