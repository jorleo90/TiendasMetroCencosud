package com.automation.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.tiendasmetro.co/")
public class InicioPage extends PageObject {

	@FindBy(id = "search-autocomplete-input")
	WebElementFacade txtBusqueda;
	
	@FindBy(xpath = "//*[@id='search-container']/div[2]/div[2]/div[1]/div[1]/div[3]/button")
	WebElementFacade btnAgregarPrimerResultado;
	
	@FindBy(id = "select2-locality-select-container")
	WebElementFacade cmbDepartamento;
	
	@FindBy(id = "select2-localidad-container")
	WebElementFacade cmbLocalidad;
	
	@FindBy(xpath = "//*[@class='select2-results__option']")
	List<WebElementFacade> listaDepartamento;
	
	@FindBy(id = "barrioBogota")
	WebElementFacade txtBarrio;
	
	@FindBy(id="submit-store-locality")
	WebElementFacade btnEntrar;
	
	@FindBy(xpath = "/html/body/header/div[2]/div[3]/div[2]/a")
	WebElementFacade btnCarrito;
	
	@FindBy(xpath = "/html/body/header/div[2]/div[3]/div[2]/div/div[2]/div[2]/a")
	WebElementFacade btnFinalizarCompra;
	
	public void agregarProductos(List<Map<String, String>> listaProductos, String departamento, String localidad, String barrio) {
		for (Map<String, String> map : listaProductos) {
			txtBusqueda.clear();
			txtBusqueda.sendKeys(map.get("Producto"));
			esperarOverlay();
			btnAgregarPrimerResultado.click();
			esperar(2);
			if(cmbDepartamento.isCurrentlyVisible()) {
				seleccionarLugarEntrega(departamento, localidad, barrio);
				waitFor(ExpectedConditions.invisibilityOfElementLocated(By.className("modalMsj")));
			}
		}
	}
	
	public void finalizarCompra() {
		btnCarrito.click();
		btnFinalizarCompra.click();
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
		List<WebElementFacade> listaBarrios = findAll(By.xpath("//li[contains(@id,'ui-id')]"));
		for (WebElementFacade unBarrio : listaBarrios) {
			if(unBarrio.getText().equals(barrio)) {
				unBarrio.click();
				break;
			}
		}
		btnEntrar.click();
	}
	
	public void esperarOverlay() {
		esperar(2);
		waitFor(ExpectedConditions.invisibilityOfElementLocated(By.id("store-locality")));
		waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
	}
	
	public void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
