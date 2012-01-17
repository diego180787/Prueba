package com.telcel.web.ingw.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;

import com.telcel.web.ingw.dto.Prepago;
import com.telcel.web.ingw.utils.Utilidades;

public class CachePrepagoMain{

	private static final Log logger = LogFactory.getLog(CachePrepagoMain.class);
	
	public static void main (String []args)throws Exception{
		
		Prepago pre = null;
		PropertyConfigurator.configure("/home/root2/bdcache/log4jPrepago.properties");
		BufferedReader br = null;
		Utilidades util = new Utilidades();
		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo("168.143.161.136", 27017), "MiTelcelPrepago"));
		
		//Borramos la colección actual
		mongoOps.dropCollection(Prepago.class);
		
		try {
	    	br = new BufferedReader(new FileReader("/home/root2/bdcache/prepago.txt"));
	        String linea;
	        while((linea=br.readLine())!=null){
	        	pre = util.separaValores(linea);
	        	mongoOps.insert(pre);
	        	logger.info("Telefono Insertado: "+pre.getTelefono());
	        }	
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        try{
	        	br.close();
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	}	  
	    }	
		
		//Hacemos la inserción en Mongo
		/*if(Integer.parseInt(args[0])==1){
			mongoOps.insert(pre);
			
		}*/
		
		//Test
		/*util.separaValores("5510108003|4488151| |RDI841003QJ4|M0436|MG MASXMENOS 1 12 F|20101216|30| | |9|MASIVO");
		logger.info("Test");*/
		
		
		
		//Contamos el total de registros insertados
		/*List<Postpago> Postpagos =  mongoOps.findAll(Postpago.class);
		logger.info("Total de registros insertados: "+Postpagos.size());*/
       	
	}
}
