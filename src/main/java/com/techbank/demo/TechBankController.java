package com.techbank.demo;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechBankController {
    @GetMapping("/api/solicitudes")
    public List<Map<String, Object>> solicitudes() {
        return List.of(
                Map.of("id", 1, "tipo", "Consulta", "estado", "Abierta"),
                Map.of("id", 2, "tipo", "Soporte", "estado", "Cerrada"),
                Map.of("id", 3, "tipo", "Seguimiento", "estado", "Abierta"));
    }

    @GetMapping("/version")
    public Map<String, String> version() {
        String sha = System.getenv("APP_COMMIT");
        return Map.of("commit", sha == null ? "local" : sha);
    }
}