package com.sardul3.nummultiplier.controller;

import com.sardul3.nummultiplier.model.Output;
import com.sardul3.nummultiplier.service.MultiplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HomeControllerTest {
    private HomeController controller;

    @Mock
    private MultiplierService service;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new HomeController(service);
    }

    @Test
    public void testGetHomeForm() {
        String viewName = controller.getHomeForm();
        assertEquals("inputForm", viewName);
    }

    @Test
    public void testProcessNumber() {
        int number = 5;
        Output output = new Output(number * 2, (number * 2) * (number * 2));

        when(service.processNumber(number)).thenReturn(output);

        String viewName = controller.processNumber(number, model);

        assertEquals("inputForm", viewName);
        verify(model, times(1)).addAttribute("doubled", output.getNumberMultiplied());
        verify(model, times(1)).addAttribute("squaredDoubled", output.getNumberMultipliedSquared());
    }

}