package com.sardul3.nummultiplier.service;

import com.sardul3.nummultiplier.exception.custom.InvalidInputException;
import com.sardul3.nummultiplier.model.Input;
import com.sardul3.nummultiplier.model.Output;
import com.sardul3.nummultiplier.repository.MultiplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for performing number multiplication operations.
 */
@Service
public class MultiplierService {

   final private MultiplierRepository repository;

   @Autowired
    public MultiplierService(MultiplierRepository repository) {
        this.repository = repository;
    }

    /**
     * Processes the given number by doubling it and calculating the square of the doubled number.
     * Saves the input and processed values to the repository.
     *
     * @param number The number to be processed.
     * @return An Output object containing the processed values.
     * @throws InvalidInputException If the input number is less than or equal to zero.
     */
    public Output processNumber(int number) {
        if (number <= 0) {
            throw new InvalidInputException("Number must be greater than zero");
        }

        int result = number * 2;
        int resultSquared = (int) Math.pow(result, 2);
        repository.save(new Input(number, result, resultSquared));
        return new Output(result, resultSquared);
    }
}
