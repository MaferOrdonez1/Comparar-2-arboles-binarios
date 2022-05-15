/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author mafer
 */
public class Arbol {
    Scanner in = new Scanner(System.in);
    FuncionesArbol binaryTree1 = new FuncionesArbol();
    FuncionesArbol binaryTree2 = new FuncionesArbol(); 
    FuncionesArbol resultado = new FuncionesArbol();
    
    public static void main(String[] args) {
        Arbol print = new Arbol();
        print.menu();
    }
    public boolean escompleto(NodoArbol Nodo) {
        if (Nodo == null) {
            return true;
        }
        Queue<NodoArbol> queue = new LinkedList<>();
        // add the root node to queue
        queue.add(Nodo);
        boolean foundNonComplete = false;
        while (!queue.isEmpty()) {
            NodoArbol curr = queue.poll();
            if (curr.hijoIzquierdo != null) {
                if (foundNonComplete) {
                    return false;
                }
            }
        }
        return true;
    }

    public void menu(){
        boolean salir = false;
        int opcion;
        
        while(!salir){
           
           System.out.println("\n"+"1. Insertar un nodo ");
           System.out.println("2. Insertar segundo arbol ");
           System.out.println("3. Borrar un nodo ");
           System.out.println("4. Recorrido en Preorden ");
           System.out.println("5. Recorrido en Posorden");
           System.out.println("6. Recorrido en Inorden ");
           System.out.println("7. Obtener la raíz ");
           System.out.println("8. Determinar la Altura ");
           System.out.println("9. Determinar número de elementos ");
           System.out.println("10. Buscar un nodo ");
           System.out.println("11. Comparar igualdad en arboles ");
           System.out.println("12. Niveles ");
           System.out.println("13. Arbol binario o no binario ");
           System.out.println("14. exit ");
           System.out.println("Escribe una de las opciones:");
           opcion = in.nextInt();
           
           switch(opcion){
               case 1:
                   System.out.println("Ingrese elemento para arbol 1:");
                   binaryTree1.addNodo(in.nextInt());
                   
                   break;
                case 2:
                    add();
                   
                   break;
              
               case 3:
                   System.out.println("Ingrese nodo al borrar arbol 1:");
                   binaryTree1.eliminar(in.nextInt());

                   break;
                case 4:
                   System.out.println("Recorrido en Preorden");
                   System.out.println("Arbol 1");
                   binaryTree1.preorden(binaryTree1.raiz);
                   
                   break;
                case 5:
                   System.out.println("Recorrido en PosOrden");
                   System.out.println("Arbol 1");
                   binaryTree1.postOrden(binaryTree1.raiz);
                   
                   break;
                case 6:
                   System.out.println("Recorrido en Inorden");
                   System.out.println("Arbol 1");
                   binaryTree1.inorden(binaryTree1.raiz);
                   
                   break;
                case 7:
                   System.out.println("Obtener la raíz del arbol 1:"+binaryTree1.obtenerlaRaíz());
                   
                   break;
                case 8:
                   System.out.println("La altura del arbol 1 es: " + binaryTree1.altura(binaryTree1.raiz));
                   break;
                case 9:
                   System.out.println("Las hojas del arbol 1 son: "+binaryTree1.contar(binaryTree1.raiz));
                   
                   break;
                case 10:
                   System.out.println("Buscar nodo:");
                   if(binaryTree1.buscar(in.nextInt())== null){
                       System.out.println("Nodo no encontrado");
                   }else{
                        System.out.println("Nodo encontrado");      
                   }
                   break;
                case 11:
                   System.out.println("Comparar arboles");
                   System.out.println(binaryTree1.equals(binaryTree1.raiz, binaryTree2.raiz));
                    if ((binaryTree1.equals(binaryTree1.raiz, binaryTree2.raiz)) == true) {
                        System.out.println("Iguales");
                    }else{
                        System.out.println("Diferentes");
                    }
                    break;
                case 12:
                    System.out.println("Niveles");
                    binaryTree1.mostrar_nivel(binaryTree1.raiz);
      
                    break;
                case 13:
                   System.out.println("Arbol");
                   if ((escompleto(binaryTree1.raiz)) == true) {
                        System.out.println("Incompleto");
                    }else{
                        System.out.println("Completo");
                    }
                    break;
                case 14:
                   salir=true;
                   System.out.println("Programa terminado");
                   
                   break;
                default:
                   System.out.println("Solo números entre 1 y 10");
    
                
            }
        }
    }
    public void add() {
        System.out.println("Ingrese elemento para arbol 2:");
        binaryTree2.addNodo(in.nextInt());
    }
}