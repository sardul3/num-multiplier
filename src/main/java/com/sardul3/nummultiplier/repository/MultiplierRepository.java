package com.sardul3.nummultiplier.repository;

import com.sardul3.nummultiplier.model.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiplierRepository extends JpaRepository<Input, Integer> {
}
