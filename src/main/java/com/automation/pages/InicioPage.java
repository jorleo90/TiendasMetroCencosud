package com.automation.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.tiendasmetro.co/")
public class InicioPage extends PageObject {

	@FindBy(id = "search-autocomplete-input")
	WebElementFacade txtBusqueda;
	
	@FindBy(xpath = "//*[@id=\"search-container\"]/div[2]/div[2]/div[1]/div[1]/div[3]/button")
	WebElementFacade btnAgregarPrimerResultado;
	
	@FindBy(id = "select2-locality-select-container")
	WebElementFacade cmbDepartamento;
	
	@FindBy(id = "select2-localidad-container")
	WebElementFacade cmbLocalidad;
	
	@FindBy(xpath = "//*[@class='select2-results__option']")
	List<WebElementFacade> listaDepartamento;
	
	@FindBy(id = "barrioBogota")
	WebElementFacade txtBarrio;
	
	public void agregarProductos(List<Map<String, String>> listaProductos) {
		
	}
	
	public void seleccionarLugarEntrega(String departamento, String localidad, String barrio) {
		cmbDepartamento.click();
		for (WebElementFacade unDepartamento : listaDepartamento) {
			if(unDepartamento.getText().equals(departamento)) {
				unDepartamento.click();
				break;
			}
		}
		cmbLocalidad.click();
		List<WebElementFacade> listaLocalidades = findAll(By.xpath("//*[@class='select2-results__option']"));
		for (WebElementFacade unaLocalidad : listaLocalidades) {
			if(unaLocalidad.getText().equals(localidad)) {
				unaLocalidad.click();
				break;
			}
		}
		txtBarrio.sendKeys(barrio);
	}
	
}
