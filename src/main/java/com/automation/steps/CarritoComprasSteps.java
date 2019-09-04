package com.automation.steps;

import com.automation.pages.InicioPage;

import net.thucydides.core.annotations.Step;

public class CarritoComprasSteps {

	InicioPage pageInicio;
	
	@Step
	public void ingresarPagina() {
		pageInicio.open();
	}
	
	
	
}
