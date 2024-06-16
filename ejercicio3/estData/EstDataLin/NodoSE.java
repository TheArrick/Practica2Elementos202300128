package EstDataLin;

public class NodoSE<T> {
    private T dato;
    private NodoSE<T> suc;

    public NodoSE(T dato) {
        this.dato = dato;
        suc = null;
    }

    public NodoSE<T> getSuc() {
        return this.suc;
    }

    public T getDato() {
        return this.dato;
    }
    public void setDato(T dato){
        this.dato = dato;

    }
    public void setSuc(NodoSE<T> suc) {
        this.suc = suc;
    }

}