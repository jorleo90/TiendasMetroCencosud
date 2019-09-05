package com.automation.steps;

import java.util.List;
import java.util.Map;

import com.automation.pages.CarritoPage;
import com.automation.pages.InicioPage;

import net.thucydides.core.annotations.Step;

public class CarritoComprasSteps {

	InicioPage pageInicio;
	CarritoPage pageCarrito;
	
	@Step
	public void ingresarPagina() {
		pageInicio.open();
	}
	
	@Step
	public void agregarProductos(List<Map<String, String>> listaProductos, String departamento, String localidad, String barrio) {
		pageInicio.agregarProductos(listaProductos, departamento, localidad, barrio);
	}
	
	@Step
	public void finalizarCompra() {
		pageInicio.finalizarCompra();
	}
	
	@Step
	public boolean validarLista(int numProductos) {
		return pageCarrito.validarCompra(numProductos);
	}
	
}
