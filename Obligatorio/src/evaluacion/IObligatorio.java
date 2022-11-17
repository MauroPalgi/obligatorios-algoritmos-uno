package evaluacion;

public interface IObligatorio {

    //pre: capacidadCajas integrla positivo       post: creacion de sistema
    public Retorno crearSistemaDeDistribucion(int capacidadCajas);
    //pre: sistema creado      post: se agrega cliente en la lista de clientes de el sistema creado

    public Retorno agregarCliente(String nombre, String rut, int tel, String direccion);
    //pre: sistemacreado, sl cliente debe existir en el sistema o no , el metodo tienen validaciones     post: eliminar cliente del la lista de clientes del sistema

    public Retorno eliminarCliente(String rut);
    //pre: sistemacreado, no existe dicho camion en el sistema     post: se agrega camion en la lista de camiones de el sistema creado

    public Retorno agregarCamion(String matricula, int toneladasMaxSoportadas);
    //pre: sistemacreado, sl camion debe existir en el sistema o no , el metodo tienen validaciones     post: eliminar camion del la lista de camiones del sistema

    public Retorno eliminarCamion(String matricula);
    //pre: sistema creado, no existe dicho producto en el sistema     post: se agrega producto en la lista de productos de el sistema creado

    public Retorno registrarProducto(String nombre, String descripcion);
    // pre: sistema creado, el camion , el producto deben existir, el numnero de caja no deb ser repetido, cant unidades integrales positivos y que no sean mayor que la capaidad de la fabrica
    // post: alta de stock tanto en el cliente como en la fabrica en si

    public Retorno altaDeStockDeProducto(String matriculaCamion, int codigoProd, int nroCaja, int cantUnidades);
    //pre: mismas condiciones de la alta, esta vez la cantidad de productos pueden ser sufcicientes o no      post: el producto se retiro correctamente

    public Retorno retiroDeProducto(String matriculaCam, String rutCliente, int codProducto, int cant);
    //pre: sistema creado      post: lista los camiones en el sistema

    public Retorno listarCamiones();
    //pre: sistema creado      post: lista los clientes (los clientes al ser agregados se agregan ordenadamente) en el sistema

    public Retorno listarClientesOrdenado();
    //pre: sistema creado      post: lista los productos en el sistema

    public Retorno listarProductos();

    //pre: sistema creado     
    // post: devuelve el nodo final ya que dicha lista se carga desde el final y se obtiene del final tambien se podria utilizar una estructura de cola FIFO
    public Retorno ultimoProductoRegistrado();
    //pre: sistema creado      post: lista los envios realizados en el sistema

    public Retorno listarEnvíosDeProducto(int codProd);
    //pre: sistema creado      post: lista los envios pendientes en el sistema

    public Retorno listarOrdenesPendientes(int codProd);
    //pre: sistema creado      post: muestra los reportes 

    public Retorno reporteDeEnviosDeProductos();

}
