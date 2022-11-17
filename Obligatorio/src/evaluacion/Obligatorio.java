/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;

import obligatorio.clases.*;
import utils.estructuras.*;

/**
 *
 * @author maurp
 */
public class Obligatorio implements IObligatorio {

    private Fabrica fabrica;

    @Override
    public Retorno crearSistemaDeDistribucion(int capacidadCajas) {
        // ERROR SI CAPACIDADCAJAS <=0
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        if (capacidadCajas > 0) {
            this.fabrica = new Fabrica(capacidadCajas);
            ret.resultado = Retorno.Resultado.OK;
            return ret;
        }

        return ret;
    }

    @Override
    public Retorno agregarCliente(String nombre, String rut, int tel, String direccion) {
        // ERROR SI EXISTE CLIENTE CON IGUAL RUT
        if (this.fabrica == null) {
            // a modo de test
            this.fabrica = new Fabrica(10);
        }
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        Cliente nuevoCliente = new Cliente(nombre, rut, tel, direccion);
        if (!this.fabrica.getListaClientes().buscarElemento(nuevoCliente)) {
            this.fabrica.getListaClientes().agregarOrd(nuevoCliente);
            ret.resultado = Retorno.Resultado.OK;
            return ret;
        }

        return ret;
    }

    @Override
    public Retorno eliminarCliente(String rut) {
        // ERROR EL CLIENTE NO PUEDE TENER ENTREGAS REGISTRADAS
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas) {
        // ERROR CAMION IGUAL MATRICULA
        // ERROR TONELADAS <=0
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        if (toneladasMaxSoportadas <= 0) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        if (this.fabrica != null) {
            Camion nuevoCamion = new Camion(matricula, toneladasMaxSoportadas);

            if (!this.fabrica.getListaCamiones().buscarElemento(nuevoCamion)) {
                this.fabrica.getListaCamiones().agregarOrd(nuevoCamion);
                ret.resultado = Retorno.Resultado.OK;
                return ret;
            }

        }
        return ret;

    }

    @Override
    public Retorno eliminarCamion(String matricula) {
        // ERROR SI TIENE ENTREGAS REGISTRADAS
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno registrarProducto(String nombre, String descripcion) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        if ("".equals(descripcion)) {
            ret.resultado = Retorno.Resultado.ERROR_3;
            return ret;
        }
        if (this.fabrica != null) {
            Producto nuevoProducto = new Producto(nombre);
            NodoDoble<Producto> NodoExistenteProducto = this.fabrica.getListaProductos().obtenerElemento(nuevoProducto);
            if (NodoExistenteProducto != null && NodoExistenteProducto.getDato() != null) {
                ret.resultado = Retorno.Resultado.ERROR_1;
                return ret;
            }

            NodoDoble<Producto> actualProducto = this.fabrica.getListaProductos().getInicio();
            while (actualProducto != null) {
                if (actualProducto.getDato().getNombre().compareTo(nombre) == 0) {
                    ret.resultado = Retorno.Resultado.ERROR_2;
                    return ret;
                }

                actualProducto = actualProducto.getSiguiente();
            }
            this.fabrica.getListaProductos().agregarOrd(nuevoProducto);
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades) {
        // ERROR NO EXISTE CAMION, NO EXISTE PRODUCTO, CANT UNIDADES <=0, YA EXISTE CAJA (ESTE METODO CREA UNA CAJA ENTIENDO), 
        // ERROR CAPACIDAD DE FABRICA PARA DESPACHAR EXEDIDA
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Se realiza un retiro de una cantidad de unidades del producto especificado para el
    envío a un cliente. En caso de existir stock del producto en la fábrica, puede ser necesario retirar 
    productos de una o más cajas.
    Cuando se retiran el total de productos de una caja, la misma debe ser destruida y dada de baja
    en el sistema. Se deberá gestionar el stock total y por caja en cada uno de los productos.
    Adicionalmente dado que los productos pueden tener caducidad se debe retirar del stock los 
    productos que llevan más tiempo en la fábrica (los que entraron primero).
    En caso de no poder cumplir en forma total con el pedido (no contar en stock con el total
    solicitado) se realizará el retiro por la cantidad disponible, generando una “orden en espera” para 
    el mismo camión, cliente, producto y con la cantidad de unidades faltantes para cumplir la 
    solicitud original. Se deberá realizar el retiro pendiente en cuanto exista stock para satisfacer el 
    total de la orden, siempre respetando el orden de registro de las ordenes en espera.    
     */
    @Override
    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant) {
        // ERROR NO EXISTE CAMION, NO EXISTE CLIENTE, NO EXISTRE PRODUCTO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno listarCamiones() {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);

        if (this.fabrica != null) {
            this.fabrica.getListaCamiones().mostrar();
            ret.resultado = Retorno.Resultado.OK;
            return ret;
        }
        return ret;
    }

    @Override
    public Retorno listarClientesOrdenado() {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);

        if (this.fabrica != null) {
            this.fabrica.getListaClientes().mostrar();
            ret.resultado = Retorno.Resultado.OK;
            return ret;
        }
        return ret;
    }

    @Override
    public Retorno listarProductos() {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        if (this.fabrica != null) {
            this.fabrica.getListaProductos().mostrar();
            ret.resultado = Retorno.Resultado.OK;
            return ret;
        }
        return ret;
    }

    @Override
    public Retorno ultimoProductoRegistrado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retorno listarEnvíosDeProducto(int codProd) {
        // ERROR NO EXISTE EL PRODUCTO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //  Lista las órdenes pendientes de un producto dado, ordenadas por orden de prioridad 
    @Override
    public Retorno listarOrdenesPendientes(int codProd) {
        // ERROR NO EXISTE PRODUCTO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Se muestra una matriz donde, para cada producto (filas) se muestran la cantidad de unidades enviadas para cada cliente (columnas).
    @Override
    public Retorno reporteDeEnviosDeProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
