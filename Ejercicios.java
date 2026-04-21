// Ejercios 1
// Inserte los valores en orden {55, 25, 75, 15, 35, 65, 8555, 25, 75, 15, 35, 65, 85}
// -Realice el recorrido in-order y muestre la secuencia de nodos.
// -Escriba una funcion recursiva para contar las hojas del arbol.
// - Inserte el valor 30 y muestre el recorrido in orden actualizado

// Ejercicio 2 
// Elimine el nodo con valor 65 del arbol resultante, mateniendo la propieadd de BST



// Requisito 
// El entregable es el codigo en java implementdos con sus soluciones a los ejercicio planteados sobre arboles binarios



class Node {
    int valor;
    Node izquierda, derecha;

    Node(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class Ejercicios {
    Node raiz;

    void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    Node insertarRecursivo(Node raiz, int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return raiz;
        }
        if (valor < raiz.valor)
            raiz.izquierda = insertarRecursivo(raiz.izquierda, valor);
        else if (valor > raiz.valor)
            raiz.derecha = insertarRecursivo(raiz.derecha, valor);
        return raiz;
    }
    
    void inOrden(Node nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecha);
        }
    }
    

    public static void main(String[] args) {
        Ejercicios arbol = new Ejercicios();
        int[] valores = {55, 25, 75, 15, 35, 65, 8555, 25, 75, 15, 35, 65, 85};
        for (int valor : valores) {
            arbol.insertar(valor);
        }
        
        System.out.println("Recorrido in-order:");
        arbol.inOrden(arbol.raiz);
        
        
        
        arbol.insertar(30);
        
        System.out.println("Recorrido in-order actualizado:");
        arbol.inOrden(arbol.raiz);

            // Input para eliminar un valor
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.print("\nIngrese el valor a eliminar: ");
            int valorEliminar = sc.nextInt();
            arbol.raiz = arbol.eliminarNodo(arbol.raiz, valorEliminar);
            System.out.println("Recorrido in-order tras eliminar " + valorEliminar + ":");
            arbol.inOrden(arbol.raiz);
            sc.close();
    }

        // Elimina un nodo con el valor dado
        Node eliminarNodo(Node raiz, int valor) {
            if (raiz == null) return null;
            if (valor < raiz.valor) {
                raiz.izquierda = eliminarNodo(raiz.izquierda, valor);
            } else if (valor > raiz.valor) {
                raiz.derecha = eliminarNodo(raiz.derecha, valor);
            } else {
                // Nodo encontrado
                if (raiz.izquierda == null) return raiz.derecha;
                if (raiz.derecha == null) return raiz.izquierda;
                // Nodo con dos hijos: obtener el sucesor
                raiz.valor = minValor(raiz.derecha);
                raiz.derecha = eliminarNodo(raiz.derecha, raiz.valor);
            }
            return raiz;
        }
        int minValor(Node nodo) {
            int minv = nodo.valor;
            while (nodo.izquierda != null) {
                minv = nodo.izquierda.valor;
                nodo = nodo.izquierda;
            }
            return minv;
        }
}