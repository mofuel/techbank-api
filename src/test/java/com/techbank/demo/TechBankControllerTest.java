package com.techbank.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TechBankControllerTest {
    @Autowired TechBankController controller;
    @Test
    void devuelveDosSolicitudesFicticias() {
        assertEquals(3, controller.solicitudes().size());
        assertEquals("Consulta", controller.solicitudes().get(0).get("tipo"));
    }
    @Test
    void exponeVersion() {
        assertFalse(controller.version().get("commit").isBlank());
    }

}
