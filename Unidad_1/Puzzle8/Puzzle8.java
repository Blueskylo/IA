public class Puzzle8 {
                                         
    public static String estadoInicial = "8654 7231";
    /*
     1 2 5  | 1 2 3 
     7 8    | 4 5 6 
     3 4 6  | 7 8 
     */
    public static String estadoFinal = "12345678 ";
    
    public static void main(String[] args) {
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(new Nodo(estadoInicial), estadoFinal);
        //Ejecuta la busqueda
        a.busquedaPorAnchura();
        //a.busquedaPorAnchuraconheuristica();
        //a.busquedaPorProfundidad();
        //Imprime movimientos
        
        /*
        Nodo n = new Nodo(estadoInicial);
        Collection<String> c = n.generaHijos();
        c = c;
        */
    }
    /*
     
     */
}