package control_clase_2;

import control_clase_2.Retorno.Resultado;

public class Prueba {

    static int cantCorrectas, cantIncorrectas, cantNoImplementadas;

    void inicializarResultadosPrueba() {
        cantCorrectas = cantIncorrectas = cantNoImplementadas = 0;
    }

    public void ver(Retorno rfn, Retorno.Resultado RetornoEsperado, String comentario, String TipoRetorno) {
        System.out.println("----------------------------- Testeo --------------------------------");
        imprimirComentario(comentario);
        imprimirRetorno(rfn.getResultado(), RetornoEsperado);
        if (TipoRetorno == "Entero") {
            System.out.println("  Retorno Entero: " + rfn.getValorEntero());
        }
        if (TipoRetorno == "String") {
            System.out.println("  Retorno String: " + rfn.getValorString());
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");
        System.out.println();

        if (rfn.getResultado().equals(RetornoEsperado)) {
            cantCorrectas++;
        } else {
            if (rfn.getResultado().equals(Retorno.Resultado.NO_IMPLEMENTADA)) {
                cantNoImplementadas++;
            } else {
                cantIncorrectas++;
            }

        }
    }

    void imprimirComentario(String comentario) {
        if (comentario != null || !comentario.isEmpty()) {
            System.out.println("\n  Comentario: " + comentario);
        }
    }

    public void imprimirRetorno(Retorno.Resultado Retorno, Retorno.Resultado RetornoEsperado) {

        if (Retorno == RetornoEsperado) {
            System.out.println("  ...................OK....................");
        } else {
            System.out.println("  ...................ERROR....................");
            System.out.println("  Retorno de la app.: " + Retorno + " / Se esperaba: " + getStringRetorno(RetornoEsperado));
        }
    }

    public String getStringRetorno(Resultado Resultado) {
        switch (Resultado) {
            case OK:
                return "OK";
            case ERROR:
                return "ERROR";
            case NO_IMPLEMENTADA:

                return "NO_IMPLEMENTADA";
            default:
                return "NO_IMPLEMENTADA";
        }
    }

    void imprimirResultadosPrueba() {
        System.out.println();
        System.out.println("  +------------------------------+");
        System.out.println("    RESULTADOS DE LA PRUEBA    ");
        System.out.println("    Pruebas Correctas: " + cantCorrectas);
        System.out.println("    Pruebas Incorrectas: " + cantIncorrectas);
        System.out.println("    Pruebas NI: " + cantNoImplementadas);
        System.out.println("  +------------------------------+");
        System.out.println();
    }

    public static void tituloPrueba(String s) {
        System.out.println("");
        System.out.println("********************************************************************************************************");
        System.out.println("  " + s);
        System.out.println("********************************************************************************************************");
    }

    public static void finPrueba(String s) {
        System.out.println("**************************************** " + s + " ***************************************");
        System.out.println("********************************************************************************************************");
        System.out.println();
    }
}
