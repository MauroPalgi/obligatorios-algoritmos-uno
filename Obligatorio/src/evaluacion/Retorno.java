package evaluacion;

public class Retorno {

    enum Resultado {
        OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, ERROR_5, NO_IMPLEMENTADA
    };
    int valorEntero = -1;
    String valorString = "";
    boolean valorbooleano = true;
    Resultado resultado;

    public Retorno(Resultado resultado) {
        this.resultado = resultado;
    }

}
