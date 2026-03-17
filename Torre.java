public class Torre{
    // atributos
    private Disco[] discos;
    private int topo;
    private int tamanho;
    // construtores
    public Torre(int tamanho) throws Exception{
        if(tamanho <= 1){
            throw new Exception("Erro! As torres devem ter no mínimo 2 discos");
        }
        this.tamanho = tamanho;
        this.discos = new Disco[tamanho];
        this.topo = -1;
    }
    public boolean isEmpty(){
        return this.topo == -1;
    }
    public boolean isFull(){
        return topo == tamanho - 1;
    }

    public void push (Disco d) throws Exception{
        if (!this.isFull())
            this.discos[++this.topo] = d;
        else
            throw new Exception("Essa torre já está cheia!");
    }

    public T pop() throws Exception{
        if (!this.isEmpty())
            return discos[topo--];
        else
            throw new Exception("Essa torre está vazia!");
    }
}
