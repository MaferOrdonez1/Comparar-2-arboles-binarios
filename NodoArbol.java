/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol;

/**
 *
 * @author mafer
 */
public class NodoArbol {
    int dato;
    NodoArbol hijoIzquierdo;
    NodoArbol hijoDerecho;
   
    public NodoArbol(int dato){
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    @Override
    public String toString(){
        return "su dato es " + this.dato;
    }
}
