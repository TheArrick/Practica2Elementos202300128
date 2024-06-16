package EstDataNoLin;

import EstDataLin.*;

/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main {   

    public void pruebaAuxi2() {
        Tree<String> tree = new Tree<>();
        ListaSE<Integer> lista = new ListaSE<>();
        tree.insertar(lista, "c");

        
        tree.insertar(lista, "a");
        tree.insertar(lista, "u");
        tree.insertar(lista, "h");
        
        
        lista = new ListaSE<>();
        lista.insertar(0);

        tree.insertar(lista, "t");
        
        lista = new ListaSE<>();
        lista.insertar(1);
        
        
        tree.insertar(lista, "t");
        
      
        
        lista = new ListaSE<>();
        lista.insertar(2);
        tree.insertar(lista, "e");
        lista.insertar(2);
        tree.insertar(lista, "u");
        
        lista = new ListaSE<>();
        
        lista.insertar(0);
        lista.insertar(0);
        
        tree.insertar(lista, "s");
        
        lista = new ListaSE<>();
        lista.insertar(1);
        lista.insertar(0);
        
        tree.insertar(lista, "p");
        lista.insertar(1);
        lista.insertar(0);
        
        tree.insertar(lista, "e");
        
        lista = new ListaSE<>();
        lista.insertar(2);
        lista.insertar(1);
        tree.insertar(lista, "i");
        lista.insertar(2);
        lista.insertar(1);
        tree.insertar(lista, "s");
                
        
        tree.mirarArriba();
     
    }
    
    public Tree<String> pruebaAuxiCHacal() {
        Tree<String> tree = new Tree<>();
        ListaSE<Integer> lista = new ListaSE<>();
        tree.insertar(lista, "c");

        
        tree.insertar(lista, "a");
        tree.insertar(lista, "u");
        tree.insertar(lista, "h");
        
        
        lista = new ListaSE<>();
        lista.insertar(0);

        tree.insertar(lista, "t");
        
        lista = new ListaSE<>();
        lista.insertar(1);
        
        
        tree.insertar(lista, "t");
        
      
        
        lista = new ListaSE<>();
        lista.insertar(2);
        tree.insertar(lista, "e");
        lista.insertar(2);
        tree.insertar(lista, "u");
        
        lista = new ListaSE<>();
        
        lista.insertar(0);
        lista.insertar(0);
        
        tree.insertar(lista, "s");
        
        lista = new ListaSE<>();
        lista.insertar(1);
        lista.insertar(0);
        
        tree.insertar(lista, "p");
        lista.insertar(1);
        lista.insertar(0);
        
        tree.insertar(lista, "e");
        
        lista = new ListaSE<>();
        lista.insertar(2);
        lista.insertar(1);
        tree.insertar(lista, "i");
        lista.insertar(2);
        lista.insertar(1);
        tree.insertar(lista, "s");
        return tree;     
    }

}
