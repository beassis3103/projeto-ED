
public class Pilha <T> {
    private static final int TAM_DEFAULT = 100;
    private	int topo;
    private	T elementos[ ];
    public T getElementos(int i) {
        return elementos[i];
    }
    public	Pilha(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
        this.topo = -1;
    }
    public	Pilha() {
        this(TAM_DEFAULT);
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == this.elementos.length-1;
    }

    public void push(T e) throws IsFullException{
        if (!this.isFull( ))
            this.elementos[++this.topo] = e;
        else
            throw new IsFullException("Overflow - Estouro de Pilha");
    }

    public T pop() throws IsEmptyException{
        if (!this.isEmpty( ))
            return this.elementos[this.topo--];
        else{
            throw new IsEmptyException( "Underflow - Esvaziamento de Pilha");
        }
    }

    public T topo() throws IsEmptyException{
        if (!this.isEmpty( ))
            return this.elementos[this.topo];
        else{
            throw new IsEmptyException("Underlow - Esvaziamento de Pilha");
        }
    }

    public int sizeElements() {
        return topo+1;
    }

}
