import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Mario R�os
 */
public class ArbolBusqueda {

    Nodo raiz;
    String objetivo;

    public ArbolBusqueda(Nodo raiz, String objetivo) {
        this.raiz = raiz;
        raiz.prof = 1;
        this.objetivo = objetivo;
    }

    // Busqueda por Anchura
    public void busquedaPorAnchura() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.prof = nodoActual.prof + 1;
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado() + "\n");

        System.out.println("Nodos para demostrar que ruta tomo: ");
        CaminoFinal(nodoActual, new String());
    }

    public void busquedaPorProfundidad() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.prof = nodoActual.prof + 1;
                    nHijo.costo = heuristica1(nHijo, objetivo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
        System.out.println(nodoActual.prof);

        System.out.println("Nodos para demostrar que ruta tomo: ");
        CaminoFinal(nodoActual, new String());
        
    }

    /* public ArrayList<Nodo> camino(Nodo nodo, ArrayList<Nodo> pasosNodos) {
        if (nodo.padre != null) {
            pasosNodos = camino(nodo.padre, pasosNodos);
        }
        pasosNodos.add(nodo);
        return pasosNodos;
    } */

    private int heuristica1(Nodo nHijo, String objetivo) {
        return 0;
    }

    public void CaminoFinal(Nodo nodo, String num) {
        if (nodo.padre != null) {
            CaminoFinal(nodo.padre, num);
        }
        num = nodo.getEstado();
        System.out.println(num.charAt(0) + " | " + num.charAt(1) + " | " + num.charAt(2));
        System.out.println("--|---|--");
        System.out.println(num.charAt(3) + " | " + num.charAt(4) + " | " + num.charAt(5));
        System.out.println("--|---|--");
        System.out.println(num.charAt(6) + " | " + num.charAt(7) + " | " + num.charAt(8));
        System.out.println();
    }

}