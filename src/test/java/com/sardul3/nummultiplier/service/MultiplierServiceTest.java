package com.sardul3.nummultiplier.service;

import com.sardul3.nummultiplier.exception.custom.InvalidInputException;
import com.sardul3.nummultiplier.model.Output;
import com.sardul3.nummultiplier.repository.MultiplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MultiplierServiceTest {

    private MultiplierService service;

    @Mock
    private MultiplierRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new MultiplierService(repository);
    }

    @Test
    public void testProcessNumber() {
        int number = 5;
        int expectedResult = number * 2;
        int expectedSquaredResult = (int) Math.pow(expectedResult, 2);

        when(repository.save(null)).thenReturn(null);

        Output output = service.processNumber(number);

        assertEquals(expectedResult, output.getNumberMultiplied());
        assertEquals(expectedSquaredResult, output.getNumberMultipliedSquared());
    }

    @Test
    public void testProcessNumberWithZero() {
        int number = 0;
        assertThrows(InvalidInputException.class, () -> service.processNumber(number));
    }

    @Test
    public void testProcessNumberWithNegative() {
        int number = -5;
        assertThrows(InvalidInputException.class, () -> service.processNumber(number));
    }

    @Test
    public void testProcessNumberInteraction() {
        int number = 5;
        int expectedResult = number * 2;
        int expectedSquaredResult = (int) Math.pow(expectedResult, 2);

        when(repository.save(any())).thenReturn(null);

        Output output = service.processNumber(number);

        assertEquals(expectedResult, output.getNumberMultiplied());
        assertEquals(expectedSquaredResult, output.getNumberMultipliedSquared());

        verify(repository, times(1)).save(any());
    }
}