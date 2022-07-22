package com.pesonalsoft.pirandom.backend.apirest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

import com.pesonalsoft.pirandom.backend.apirest.models.PiResponse;
import com.pesonalsoft.pirandom.backend.apirest.services.IPiService;

@RestController
@RequestMapping("/api/v1")
public class PiController {
	
	@Autowired
	private IPiService PiService;

	@GetMapping("/getpi_random/{input_number}")
	public ResponseEntity<?> getPiRandom(@PathVariable int input_number) {
        Map<String, String> response = new HashMap<>();
        
        PiResponse piResponse = PiService.calcularPi(input_number);
        
        if(piResponse != null){
            return ResponseEntity.ok(piResponse);
        } else {
            response.put("status", "Error");
            response.put("message", "El parámetro inicial no debe ser cero");
            return ResponseEntity.status(404).body(response);
        }
    }
}
