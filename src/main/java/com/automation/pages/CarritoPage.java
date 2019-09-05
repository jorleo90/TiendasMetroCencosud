package com.automation.pages;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CarritoPage extends PageObject{

	@FindBy(xpath = "//div[@class='cart-products-items']/div")
	List<WebElementFacade> listaProductosCarrito;
	
	
	public boolean validarCompra(int numProductos) {
		return listaProductosCarrito.size() == numProductos;
	}
	
}
