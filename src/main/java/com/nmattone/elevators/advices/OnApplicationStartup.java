package com.nmattone.elevators.advices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.nmattone.elevators.model.strategies.EnergyCostDispatchStrategy;
import com.nmattone.elevators.services.DispatcherService;

@Component
public class OnApplicationStartup {

	private static final Logger log = LoggerFactory.getLogger(OnApplicationStartup.class);
	
	@Autowired
	private DispatcherService dispatcher;
	
	@EventListener(ApplicationReadyEvent.class)
	public void setDefaultDispatcherStrategy() {
		log.info("Asignando estrategia por defecto al dispatcher de ascensores.");
		this.dispatcher.setStrategy(new EnergyCostDispatchStrategy());
		log.info("Aplicación inicializada correctamente.");
	}
	
	
}
