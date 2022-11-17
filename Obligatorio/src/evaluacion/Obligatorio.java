/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion;

import obligatorio.clases.*;
import utils.estructuras.*;
import java.lang.Math;

/**
 *
 * @author maurp
 */
public class Obligatorio implements IObligatorio {

    private Fabrica fabrica;

    public Fabrica getFabrica() {
        return fabrica;
    }

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
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        Cliente clienteBuscado = new Cliente(rut);
        NodoDoble<Cliente> cliente = this.fabrica.getListaClientes().obtenerElemento(clienteBuscado);
        boolean existeCliente = cliente != null;
        if (!existeCliente) {
            return ret;
        }
        System.out.println("cliente encontrado" + cliente.getDato().toString());
        if (!cliente.getDato().getEntregas().esVacia()) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        this.fabrica.getListaClientes().borrarElemento(cliente.getDato());
        ret.resultado = Retorno.Resultado.OK;
        return ret;
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
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        Camion camionBuscado = new Camion(matricula);
        NodoDoble<Camion> camion = this.fabrica.getListaCamiones().obtenerElemento(camionBuscado);
        boolean existeCamion = camion != null;
        if (!existeCamion) {
            return ret;
        }
        if (!camion.getDato().getEntregasRealizadas().esVacia()) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        this.fabrica.getListaCamiones().borrarElemento(camion.getDato());
        ret.resultado = Retorno.Resultado.OK;
        return ret;
    }

    @Override
    public Retorno registrarProducto(String nombre, String descripcion) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);

        if (this.fabrica != null) {
            Producto nuevoProducto = new Producto(nombre, descripcion);
            if ("".equals(descripcion) || descripcion == null) {
                ret.resultado = Retorno.Resultado.ERROR_3;
                Producto.idGlobal--;
                return ret;
            }
            NodoDoble<Producto> NodoExistenteProducto = this.fabrica.getListaProductos().obtenerElemento(nuevoProducto);
            if (NodoExistenteProducto != null && NodoExistenteProducto.getDato() != null) {
                ret.resultado = Retorno.Resultado.ERROR_1;
                Producto.idGlobal--;
                return ret;
            }

            NodoDoble<Producto> actualProducto = this.fabrica.getListaProductos().getInicio();
            while (actualProducto != null) {
                if (NodoExistenteProducto != null && actualProducto.getDato().getIdProducto() == NodoExistenteProducto.getDato().getIdProducto()) {
                    ret.resultado = Retorno.Resultado.ERROR_2;
                    return ret;
                }

                actualProducto = actualProducto.getSiguiente();
            }
            this.fabrica.getListaProductos().agregarFinal(nuevoProducto);
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades) {
        // ERROR NO EXISTE CAMION, NO EXISTE PRODUCTO, CANT UNIDADES <=0, YA EXISTE CAJA (ESTE METODO CREA UNA CAJA ENTIENDO), 
        // ERROR CAPACIDAD DE FABRICA PARA DESPACHAR EXEDIDA
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        // busca camion
        Camion camionBuscado = new Camion(matriculaCamion);
        NodoDoble<Camion> camionCaja = this.fabrica.getListaCamiones().obtenerElemento(camionBuscado);

        // buscar producto
        NodoDoble<Producto> actualProducto = this.fabrica.getListaProductos().getInicio();
        NodoDoble<Producto> productoCaja = null;
        while (actualProducto != null) {
            if (actualProducto.getDato().getIdProducto() == codigoProd) {
                productoCaja = actualProducto;
                actualProducto = null;
                break;
            } else {
                actualProducto = actualProducto.getSiguiente();
            }

        }
        // buscar numero de caja
        Caja cajaBuscada = new Caja(nroCaja);
        boolean existeCaja = this.fabrica.getListaCaja().buscarElemento(cajaBuscada);

        boolean existeCamion = camionCaja != null;
        boolean existeProducto = productoCaja != null;
        boolean sonCantUnidadesPositivas = cantUnidades > 0;
        boolean quedaCapacidad = this.fabrica.getCapacidadCajas() - cantUnidades >= 0;

        if (!existeCamion) {
            return ret;
        }
        if (!existeProducto) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        if (!sonCantUnidadesPositivas) {
            ret.resultado = Retorno.Resultado.ERROR_3;
            return ret;
        }
        if (existeCaja) {
            ret.resultado = Retorno.Resultado.ERROR_4;
            return ret;
        }
        if (!quedaCapacidad) {
            ret.resultado = Retorno.Resultado.ERROR_5;
            return ret;
        }
        boolean sePuedeAlta = existeCamion && existeCamion && existeProducto && sonCantUnidadesPositivas && !existeCaja && quedaCapacidad;

        // cumplir con pedidos pendientes primero
        NodoDoble<Entrega> actualPentiende = this.fabrica.getListaEntregasPendientes().getInicio();
        while (actualPentiende != null) {
            if (actualPentiende.getDato().getProducto().getIdProducto() == codigoProd) {
                int cantPendienteActual = actualPentiende.getDato().getCantUnidades();
                int sobrante = cantPendienteActual - cantUnidades;
                boolean seCubrenPendientes = cantPendienteActual - cantUnidades < 0;
                if (seCubrenPendientes) {
                    this.fabrica.getListaEntregasPendientes().borrarElemento(actualPentiende.getDato());
                    camionCaja.getDato().getEntregasPendientes().borrarElemento(actualPentiende.getDato());
                    actualPentiende.getDato().setEsPendiente(false);
                    this.fabrica.getListaEntregasRealizadas().agregarFinal(actualPentiende.getDato());
                    camionCaja.getDato().getEntregasRealizadas().agregarFinal(actualPentiende.getDato());
                    cantUnidades -= cantPendienteActual;
                } else {

                    if (sobrante > 0) {
                        actualPentiende.getDato().setCantUnidades(sobrante);
                        NodoDoble<Camion> camionConPendiente = camionCaja.getDato().getEntregasPendientes().obtenerElemento(actualPentiende.getDato());
                        NodoDoble<Entrega> entregaAModificar = camionConPendiente.getDato().getEntregasPendientes().obtenerElemento(actualPentiende.getDato());
                        entregaAModificar.getDato().setCantUnidades(sobrante);
                        NodoDoble<Entrega> entregaFabricaAModificar = this.fabrica.getListaEntregasPendientes().obtenerElemento(actualPentiende.getDato());
                        entregaFabricaAModificar.getDato().setCantUnidades(sobrante);
                    }

                    if (sobrante == 0) {
                        this.fabrica.getListaEntregasPendientes().borrarElemento(actualPentiende.getDato());
                        camionCaja.getDato().getEntregasPendientes().borrarElemento(actualPentiende.getDato());
                    }
                }

            }
            actualPentiende = actualPentiende.getSiguiente();
        }

        if (sePuedeAlta) {
            // ser caja en producto
            cajaBuscada = new Caja(nroCaja, camionCaja.getDato(), productoCaja.getDato(), cantUnidades);
            productoCaja.getDato().getListaCaja().agregarOrd(cajaBuscada);
            int nuevoStockProducto = productoCaja.getDato().getStockEnFabrica() + cantUnidades;
            productoCaja.getDato().setStockEnFabrica(nuevoStockProducto);
            // set caja en fabrica            
            // cajaBuscada.
            this.fabrica.getListaCaja().agregarOrd(cajaBuscada);
            int nuevaCapacidadCajas = this.fabrica.getCapacidadCajas() - 1;
            this.fabrica.setCapacidadCajas(nuevaCapacidadCajas);
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
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
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        // busca camion
        Camion camionBuscado = new Camion(matriculaCam);
        NodoDoble<Camion> camionCaja = this.fabrica.getListaCamiones().obtenerElemento(camionBuscado);
        boolean existeCamion = camionCaja != null;
        if (!existeCamion) {
            return ret;
        }
        // buscar producto
        NodoDoble<Producto> actualProducto = this.fabrica.getListaProductos().getInicio();
        NodoDoble<Producto> productoCaja = null;
        while (actualProducto != null) {
            if (actualProducto.getDato().getIdProducto() == codProducto) {
                productoCaja = actualProducto;
                actualProducto = null;
                break;
            } else {
                actualProducto = actualProducto.getSiguiente();
            }
        }
        boolean existeProducto = productoCaja != null;

        if (!existeProducto) {
            ret = new Retorno(Retorno.Resultado.ERROR_3);
            return ret;
        }

        // buscar cliente
        Cliente clienteBuscar = new Cliente(rutCliente);
        NodoDoble<Cliente> clienteCaja = this.fabrica.getListaClientes().obtenerElemento(clienteBuscar);
        boolean existeCliente = clienteCaja != null;
        if (!existeCliente) {
            ret = new Retorno(Retorno.Resultado.ERROR_2);
            return ret;

        }
        if (productoCaja != null && camionCaja != null && clienteCaja != null) {
            Entrega entregaPentiende;
            Entrega entregaRealizada;
            if (!productoCaja.getDato().getListaCaja().esVacia()) {
                NodoDoble<Caja> actualCaja = productoCaja.getDato().getListaCaja().getFin();
                int catidadUnidadesEnFabrica = productoCaja.getDato().getStockEnFabrica();
                int exedenteDemanda = catidadUnidadesEnFabrica - cant;
                if (exedenteDemanda > 0) {
                    productoCaja.getDato().setStockEnFabrica(exedenteDemanda);
                    while (actualCaja != null && cant > 0) {
                        int cantidadUnidadesEnCaja = actualCaja.getDato().getUnidadesProducto();
                        int sobranteCaja = cantidadUnidadesEnCaja - cant;
                        if (sobranteCaja > 0) {
                            actualCaja.getDato().setUnidadesProducto(sobranteCaja);
                        } else {
                            if (sobranteCaja <= 0) {
                                productoCaja.getDato().getListaCaja().borrarElemento(actualCaja.getDato());
                            }
                        }
                        cant -= cantidadUnidadesEnCaja;
                        actualCaja = actualCaja.getAnterior();
                    }
                    entregaRealizada = new Entrega(productoCaja.getDato(), false, cant);
                    this.fabrica.getListaEntregasRealizadas().agregarFinal(entregaRealizada);
                    camionCaja.getDato().getEntregasRealizadas().agregarFinal(entregaRealizada);
                    clienteCaja.getDato().getEntregas().agregarFinal(entregaRealizada);

                } else {
                    if (exedenteDemanda <= 0) {
                        productoCaja.getDato().getListaCaja().vaciar();
                        entregaRealizada = new Entrega(productoCaja.getDato(), false, cant);
                        this.fabrica.getListaEntregasRealizadas().agregarFinal(entregaRealizada);
                        camionCaja.getDato().getEntregasRealizadas().agregarFinal(entregaRealizada);
                        clienteCaja.getDato().getEntregas().agregarFinal(entregaRealizada);
                        if (exedenteDemanda < 0) {
                            entregaPentiende = new Entrega(productoCaja.getDato(), true, Math.abs(exedenteDemanda));
                            this.fabrica.getListaEntregasPendientes().agregarFinal(entregaPentiende);
                            camionCaja.getDato().getEntregasPendientes().agregarFinal(entregaPentiende);
                        }
                    }

                }
            } else {
                entregaPentiende = new Entrega(productoCaja.getDato(), true, cant);
                this.fabrica.getListaEntregasPendientes().agregarFinal(entregaPentiende);
                camionCaja.getDato().getEntregasPendientes().agregarFinal(entregaPentiende);
            }
            ret = new Retorno(Retorno.Resultado.OK);
        }
        return ret;
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
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        System.out.println(this.fabrica.getListaProductos().getFin().toString());
        return ret;

    }

    @Override
    public Retorno listarEnvíosDeProducto(int codProd) {
        // ERROR NO EXISTE EL PRODUCTO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //  Lista las órdenes pendientes de un producto dado, ordenadas por orden de prioridad 
    @Override
    public Retorno listarOrdenesPendientes(int codProd) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR_1);
        ListaDoble<Entrega> listaPendienteDeProducto = new ListaDoble<>();
        boolean hayPendientes = false;

        // buscar producto
        NodoDoble<Producto> actualProducto = this.fabrica.getListaProductos().getInicio();
        NodoDoble<Producto> productoCaja = null;
        while (actualProducto != null) {
            if (actualProducto.getDato().getIdProducto() == codProd) {
                productoCaja = actualProducto;
                actualProducto = null;
                break;
            }
            actualProducto = actualProducto.getSiguiente();
        }

        boolean existeProducto = productoCaja != null;
        if (!existeProducto) {
            return ret;
        }
        // buscamos si existe la orden pendiente para ese producto
        NodoDoble<Entrega> actualPentiende = this.fabrica.getListaEntregasPendientes().getInicio();
        while (actualPentiende != null) {
            if (actualPentiende.getDato().getProducto().getIdProducto() == codProd) {
                listaPendienteDeProducto.agregarFinal(actualPentiende.getDato());
                hayPendientes = true;
            }
            actualPentiende = actualPentiende.getSiguiente();
        }
        listaPendienteDeProducto.mostrar();
        ret = new Retorno(Retorno.Resultado.OK);
        return ret;
    }

    // Se muestra una matriz donde, para cada producto (filas) se muestran la cantidad de unidades enviadas para cada cliente (columnas).
    @Override
    public Retorno reporteDeEnviosDeProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
