/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * @author mafer
 */
public class FuncionesArbol {

    NodoArbol raiz;

    public FuncionesArbol() {
        this.raiz = null;
    }

    //insertar un nodo
    public void addNodo(int dato) {
        NodoArbol nuevo = new NodoArbol(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol aux = raiz;
            NodoArbol padre;
            while (true) {
                padre = aux;
                if (dato < aux.dato) {
                    aux = aux.hijoIzquierdo;
                    if (aux == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    aux = aux.hijoDerecho;
                    if (aux == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean eliminar(int dato) {
        //necesitamos dos punteros
        //de tipo nodo árbol
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo = true;
        while (aux.dato != dato) {
            padre = aux;
            if (dato < aux.dato) {
                //tomar izquierda
                esHijoIzquierdo = true;
                aux = aux.hijoIzquierdo;
            } else {
                esHijoIzquierdo = false;
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return false;
            }
        }//fin while
        if (aux.hijoIzquierdo == null
                && aux.hijoDerecho == null) {
            //es hoja
            if (aux == raiz) {
                raiz = null;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (aux.hijoDerecho == null) {
            if (aux == raiz) {
                raiz = aux.hijoIzquierdo;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = aux.hijoIzquierdo;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else if (aux.hijoIzquierdo == null) {
            if (aux == raiz) {
                raiz = aux.hijoDerecho;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = aux.hijoDerecho;
            } else {
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        } else {
            NodoArbol reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzquierdo) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }

    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemplazo) {
        NodoArbol reemplazarPadre = nodoReemplazo;
        NodoArbol reemplazo = nodoReemplazo;

        NodoArbol aux = nodoReemplazo.hijoDerecho;

        while (aux != null) {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.hijoIzquierdo;
        }
        if (reemplazo != nodoReemplazo.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReemplazo.hijoDerecho;
        }
        System.out.println("El nodo reemplazo es " + reemplazo);
        return reemplazo;
    }

    //Empieza desde el padre
    public void preorden(NodoArbol Nodo) {
        if (Nodo == null) {
            return;
        } else {
            System.out.print(Nodo.dato + " ");
            preorden(Nodo.hijoIzquierdo);
            preorden(Nodo.hijoDerecho);

        }
    }

    // Empieza desde los hijos
    public void postOrden(NodoArbol Nodo) {
        if (Nodo == null) {
            return;
        } else {
            preorden(Nodo.hijoIzquierdo);
            preorden(Nodo.hijoDerecho);
            System.out.print(Nodo.dato + " ");

        }
    }

    // Empieza desde los primeros izquierdos desde abajo para arriba
    public void inorden(NodoArbol Nodo) {
        if (Nodo == null) {
            return;
        } else {
            inorden(Nodo.hijoIzquierdo);
            System.out.print(Nodo.dato + " ");
            inorden(Nodo.hijoDerecho);

        }
    }

    public int obtenerlaRaíz() {
        return raiz.dato;

    }

    public int altura(NodoArbol Nodo) {
        if (Nodo != null) {
            return (1 + Math.max(altura(Nodo.hijoIzquierdo), altura(Nodo.hijoDerecho)));
        }
        return 0;
    }

    public int contar(NodoArbol Nodo) {
        if (Nodo != null) {
            return (1 + contar(Nodo.hijoIzquierdo) + contar(Nodo.hijoDerecho));
        }
        return 0;
    }

    public NodoArbol buscar(int dato) {
        NodoArbol aux = raiz;
        while (aux.dato != dato) {
            if (dato < aux.dato) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
        
    }
    public boolean equals(NodoArbol T1,NodoArbol T2){
        if (T1 == T2) 
            return true;
        if (T1 == null && T2 == null) 
            return false;
        if ((T1 == null) || (T2 == null))
                return false;

        if (T1.dato != T2.dato) {
            if (!(T1.dato == (T2.dato))) {
                return false;
            }

        }
        if (!equals(T1.hijoIzquierdo, T2.hijoIzquierdo)) {
            return false;
        }

        if (!equals(T1.hijoDerecho, T2.hijoDerecho)) {
            return false;
        }

        return true;
    }
    public void mostrar_nivel(NodoArbol Nodo){
        int nivel = 1;
        while(mostrar_nodo(Nodo,nivel)){
            nivel++; 
            break;
        } 
    }
    
    public boolean mostrar_nodo(NodoArbol Nodo,int nivel){
        if(Nodo==null){
            return false;
        
        }
        if(nivel==1){
            System.out.println(Nodo.dato + " "); 
            return true;
        }
        
        boolean izq,der;
        izq=mostrar_nodo(Nodo.hijoIzquierdo,nivel-1);
        der=mostrar_nodo(Nodo.hijoDerecho, nivel-1);
        return izq || der;
  
    }
}


    