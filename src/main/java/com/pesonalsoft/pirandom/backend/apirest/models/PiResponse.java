package com.pesonalsoft.pirandom.backend.apirest.models;

public class PiResponse {
	
	private int param;
	private int random;
	private String PiCalc;
	
	public int getParam() {
		return param;
	}
	public void setParam(int param) {
		this.param = param;
	}
	public int getRandom() {
		return random;
	}
	public void setRandom(int random) {
		this.random = random;
	}
	public String getPiCalc() {
		return PiCalc;
	}
	public void setPiCalc(String piCalc) {
		PiCalc = piCalc;
	}

}
