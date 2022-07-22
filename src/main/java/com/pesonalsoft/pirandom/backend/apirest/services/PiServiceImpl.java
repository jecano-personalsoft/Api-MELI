package com.pesonalsoft.pirandom.backend.apirest.services;

import org.springframework.stereotype.Service;
import com.pesonalsoft.pirandom.backend.apirest.models.PiResponse;

@Service
public class PiServiceImpl implements IPiService {

	@Override
	public PiResponse calcularPi(int input_number) {
		
		PiResponse piResponse = new PiResponse();
		
		piResponse.setParam(input_number);
		piResponse.setRandom(9);
		piResponse.setPiCalc("3.1416");
		
		return piResponse;
	}
	
}
