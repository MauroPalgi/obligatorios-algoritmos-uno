package evaluacion;

import evaluacion.Retorno.Resultado;

public class Prueba {

    static int cantCorrectas, cantIncorrectas, cantNoImplementadas;
    private boolean showOnlyErrorLogs = false;
    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_BLACK = "\u001B[30m";
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_YELLOW = "\u001B[33m";
    public final String ANSI_BLUE = "\u001B[34m";
    public final String ANSI_PURPLE = "\u001B[35m";
    public final String ANSI_CYAN = "\u001B[36m";
    public final String ANSI_WHITE = "\u001B[37m";

    public void setShowOnlyErrorLogs(boolean onlyErrorLogs) {
        this.showOnlyErrorLogs = onlyErrorLogs;
    }

    void inicializarResultadosPrueba() {
        cantCorrectas = cantIncorrectas = cantNoImplementadas = 0;
    }

    public void ver(Retorno.Resultado tr, Retorno.Resultado RetornoEsperado, String comentario) {
        if (tr != RetornoEsperado && showOnlyErrorLogs) {
            System.out.println();
            System.out.println(this.ANSI_RED + "----------------------------- Testeo --------------------------------");
            imprimirComentario(comentario);
            imprimirRetorno(tr, RetornoEsperado);
            System.out.println("");
            System.out.println("---------------------------------------------------------------------" + this.ANSI_RESET);
            System.out.println();
        } else {
            if (!showOnlyErrorLogs) {
                System.out.println("----------------------------- Testeo --------------------------------");
                imprimirComentario(comentario);
                imprimirRetorno(tr, RetornoEsperado);
                System.out.println("");
                System.out.println("---------------------------------------------------------------------");
                System.out.println();
            }

        }
        if (tr.equals(RetornoEsperado)) {
            cantCorrectas++;
        } else {
            if (tr.equals(Retorno.Resultado.NO_IMPLEMENTADA)) {
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
            case ERROR_1:
                return "ERROR 1";
            case ERROR_2:
                return "ERROR 2";
            case ERROR_3:
                return "ERROR 3";
            case ERROR_4:
                return "ERROR 4";
            case ERROR_5:
                return "ERROR 5";
            case NO_IMPLEMENTADA:

                return "NO_IMPLEMENTADA";
            default:
                return "NO_IMPLEMENTADA";
        }
    }

    public void imprimirResultadosPrueba() {
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
