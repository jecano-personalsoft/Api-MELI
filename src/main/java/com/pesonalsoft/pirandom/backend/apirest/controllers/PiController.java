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
import com.pesonalsoft.pirandom.backend.apirest.models.PiSimpleResponse;
import com.pesonalsoft.pirandom.backend.apirest.services.IPiService;
import com.pesonalsoft.pirandom.backend.apirest.utiles.Constantes;

@RestController
@RequestMapping("/api/v1")
public class PiController {
	
	@Autowired
	private IPiService PiService;

	@SuppressWarnings("unused")
	@GetMapping("/getpi_random/{input_number}")
	public ResponseEntity<?> getPiRandom(@PathVariable int input_number) {
		Map<String, String> response = new HashMap<>();
        
        PiResponse piResponse = new PiResponse();
        
        if(Constantes.MAX_RANDOM_PRECISION == 0) {
        	piResponse = PiService.calcularPiRandom(input_number);
        	
        	if(piResponse == null){
        		response.put("userMessage", "The entered parameter must be greater than cerso");
                response.put("internalMessage", "PARAMETER_NOT_VALID");
                response.put("moreInfo", "https://httpstatuses.com/400");
                return ResponseEntity.status(400).body(response);
            }
        	
        	return ResponseEntity.ok(piResponse);
        } else if (Constantes.MAX_RANDOM_PRECISION != 0) {
        	piResponse = PiService.calcularPiRandom(input_number);
        	
        	if(piResponse == null){
        		response.put("userMessage", "The entered parameter must be greater than cerso");
                response.put("internalMessage", "PARAMETER_NOT_VALID");
                response.put("moreInfo", "https://httpstatuses.com/400");
                return ResponseEntity.status(400).body(response);
            }
        	
        	if(piResponse.getRandom() > Constantes.MAX_RANDOM_PRECISION) {
        		response.put("userMessage", "Random parameter would cause overflow");
                response.put("randomGenerate", String.valueOf(piResponse.getRandom()));
                response.put("internalMessage", "CONFLICT_RANDOM_NOT_VALID");
                response.put("moreInfo", "https://httpstatuses.com/409");
                return ResponseEntity.status(409).body(response);
        	}
        	
        	return ResponseEntity.ok(piResponse);
        }
        
        response.put("userMessage", "An unexpected error has been detected. Please check the information and try again.");
        response.put("internalMessage", "UNEXPECTED_ERROR");
        response.put("moreInfo", "https://httpstatuses.com/500");
        return ResponseEntity.status(500).body(response);
    }
	
	@GetMapping("/getpi/{random_number}")
	public ResponseEntity<?> getPi(@PathVariable int random_number) {
		Map<String, String> response = new HashMap<>();
        
		PiSimpleResponse piSimpleResponse = new PiSimpleResponse();
        
		piSimpleResponse = PiService.calcularPi(random_number);
    	
    	if(piSimpleResponse == null){
    		response.put("userMessage", "The entered parameter must be greater than cerso");
            response.put("internalMessage", "PARAMETER_NOT_VALID");
            response.put("moreInfo", "https://httpstatuses.com/400");
            return ResponseEntity.status(400).body(response);
        }
    	
    	return ResponseEntity.ok(piSimpleResponse);
    }
}
