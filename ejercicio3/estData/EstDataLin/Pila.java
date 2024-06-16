package EstDataLin;

/**
 * Write a description of class Pila here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pila<T> {
    private T top;
    private Pila<T> base;

    public Pila() {
        top = null;
        base = null;
    }

    private Pila(T dato, Pila<T> base) {
        top = dato;
        this.base = base;
    }

    public boolean esVacia() {
        return top == null;
    }

    public void push(T dato) {
        if (esVacia()) {
            top = dato;
            base = new Pila<>();
        } else {
            base = new Pila<T>(top, base);
            top = dato;
        }
    }

    public T top() {
        return top;
    }

    public void pop() {
        if (!esVacia()) {
            top = base.top;
            base = base.base;
        }
    }

}
