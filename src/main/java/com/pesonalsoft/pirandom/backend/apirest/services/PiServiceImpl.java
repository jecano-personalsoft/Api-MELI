package com.pesonalsoft.pirandom.backend.apirest.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import com.pesonalsoft.pirandom.backend.apirest.models.PiResponse;
import com.pesonalsoft.pirandom.backend.apirest.models.PiSimpleResponse;

@Service
@Slf4j
public class PiServiceImpl implements IPiService {

	//private static Logger LOGGER = LoggerFactory.getLogger(PiServiceImpl.class);
	
	@Override
	public PiResponse calcularPiRandom(int input_number) {
		
		if(input_number <= 0) {
			return null;
		}
		
		PiResponse piResponse = new PiResponse();
		
		int random = obtenerNumeroRandom(input_number);
		
		String piCalc = obtenerDecimalesPi(random);
		
		piResponse.setParam(input_number);
		piResponse.setRandom(random);
		piResponse.setPiCalc(piCalc);
		
		return piResponse;
	}
	
	@Override
	public PiSimpleResponse calcularPi(int random_number) {
		
		//LOGGER.info("Entrando a calcular los digitos de pi");
		log.info("Entrando a calcular los digitos de pi");
		
		if(random_number <= 0) {
			return null;
		}
		
		PiSimpleResponse piSimpleResponse = new PiSimpleResponse();
		
		String piCalc = obtenerDecimalesPi(random_number);
		
		piSimpleResponse.setRandom(random_number);
		piSimpleResponse.setPiCalc(piCalc);
		
		return piSimpleResponse;
	}

	private int obtenerNumeroRandom(int input_number) {
		int rangoInicial = input_number/2;
		int rangoFinal = input_number+1;
		
		Random random = new Random();
		
		return rangoInicial + random.nextInt((rangoFinal - rangoInicial) + 1); 
	}
	
	private String obtenerDecimalesPi(int random) {
		BigDecimal decimal = new BigDecimal(Math.PI);
		return decimal.setScale(random, RoundingMode.DOWN).toString();
	}	
}
