package com.sardul3.nummultiplier.service;

import com.sardul3.nummultiplier.model.Input;
import com.sardul3.nummultiplier.model.Output;
import com.sardul3.nummultiplier.repository.MultiplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplierService {

   @Autowired
   private MultiplierRepository repository;


    public Output processNumber(int number) {
        int result = number * 2;
        int resultSquared = (int) Math.pow(result, 2);
        repository.save(new Input(number, result, resultSquared));
        return new Output(result, resultSquared);
    }




}
