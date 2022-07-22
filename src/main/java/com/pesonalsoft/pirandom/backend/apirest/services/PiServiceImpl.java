package com.pesonalsoft.pirandom.backend.apirest.services;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.stereotype.Service;
import com.pesonalsoft.pirandom.backend.apirest.models.PiResponse;

@Service
public class PiServiceImpl implements IPiService {

	@Override
	public PiResponse calcularPi(int input_number) {
		
		if(input_number == 0) {
			return null;
		}
		
		PiResponse piResponse = new PiResponse();
		
		int random = obtenerNumeroRandom(input_number);
		String piCalc = obtenerValorPi(random);
		
		piResponse.setParam(input_number);
		piResponse.setRandom(random);
		piResponse.setPiCalc(piCalc);
		
		return piResponse;
	}

	private int obtenerNumeroRandom(int input_number) {
		int rangoInicial = input_number/2;
		int rangoFinal = input_number+1;
		
		Random random = new Random();
		
		return rangoInicial + random.nextInt((rangoFinal - rangoInicial) + 1); 
	}
	
	private String obtenerValorPi(int random) {
		DecimalFormat decFormat = new DecimalFormat();
		decFormat.setMaximumFractionDigits(random);
		
		return decFormat.format(Math.PI);
	}	
}
