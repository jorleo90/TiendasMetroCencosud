# language: es
# encoding: iso-8859-1
Característica: Carrito de Compras
  Como usuario de Tiendas Metro
  deseo poder comprar algunos productos en línea
  para evitar el traslado hasta la tienda física

  Esquema del escenario: Agregar Productos Carrito de Compras
    Dado que estoy en la pagina de inicio de Tiendas Metro
    Cuando busco varios productos de la tienda para entrega en <Departamento> con <Localidad> y <Barrio>
      | Producto | Cantidad |
      | Leche    |        1 |
      | Huevos   |        1 |
    Y los agrego al carrito de compras
    Entonces se debe mostrar la lista de productos agregados

    Ejemplos: 
      | Departamento | Localidad | Barrio         |
      | Bogotá, D.C. | Chapinero | Chapinero Alto |
