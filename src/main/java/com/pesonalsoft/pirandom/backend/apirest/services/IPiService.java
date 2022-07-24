package com.pesonalsoft.pirandom.backend.apirest.services;

import com.pesonalsoft.pirandom.backend.apirest.models.PiResponse;
import com.pesonalsoft.pirandom.backend.apirest.models.PiSimpleResponse;

public interface IPiService {
	
	public PiResponse calcularPiRandom(int input_number);
	
	public PiSimpleResponse calcularPi(int random_number);
	
}
