package com.telcel.web.ingw.utils;

import java.util.StringTokenizer;

import com.telcel.web.ingw.dto.Prepago;

public class Utilidades {

	private StringBuffer aux = null;
	
	public Prepago separaValores(String linea){
		StringTokenizer token = new StringTokenizer(linea,"|");
		//Inicializar Constructor con Valores Default
		Prepago pre = new Prepago();
		//Guardar valores en DTO Telefono
		pre.setTelefono(token.nextToken());
		//Region
		pre.setRegion(Integer.parseInt(token.nextToken()));
		return pre;
	}
	
	public boolean validaInfo(String dato){
		if(!dato.equals("-1"))
			return true;
		return false;
	}
}
