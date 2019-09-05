package com.automation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.automation.steps.CarritoComprasSteps;

import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class CarritoComprasStepdefinitions {

	int numProductos = 0;

	@Steps
	CarritoComprasSteps stepsCarritoCompras;

	@Dado("^que estoy en la pagina de inicio de Tiendas Metro$")
	public void queEstoyEnLaPaginaDeInicioDeTiendasMetro() throws Exception {
		stepsCarritoCompras.ingresarPagina();
	}

	@Cuando("^busco varios productos de la tienda para entrega en (.*) con (.*) y (.*)$")
	public void buscoVariosProductosDeLaTiendaParaEntregaEnBogot·DCConChapineroYChapineroAlto(String departamento,
			String localidad, String barrio, DataTable productos) throws Exception {
		List<Map<String, String>> listaProductos = productos.asMaps(String.class, String.class);
		numProductos = listaProductos.size();
		stepsCarritoCompras.agregarProductos(listaProductos, departamento, localidad, barrio);
	}

	@Y("^los agrego al carrito de compras$")
	public void losAgregoAlCarritoDeCompras() throws Exception {
		stepsCarritoCompras.finalizarCompra();
	}

	@Entonces("^se debe mostrar la lista de productos agregados$")
	public void seDebeMostrarLaListaDeProductosAgregados() throws Exception {
		assertTrue("La cantidad de productos agregados no corresponde con la compra realizada!",
				stepsCarritoCompras.validarLista(numProductos));
	}

}
