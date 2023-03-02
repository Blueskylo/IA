package Unidad_1.Arbol;

public class Chi_Chenor {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(8, "Fresa");
        arbol.insertar(6, "Kiwi");
        arbol.insertar(7, "Uva");
        arbol.insertar(1, "Piña");
        arbol.insertar(9, "Sandia");
        arbol.insertar(4, "Mora Azul");

        arbol.imprimirArbol(arbol.raiz);
    }
}
