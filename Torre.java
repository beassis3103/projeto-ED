public class Torre{
    // atributos
    public Disco[] discos;
    private int topo;
    private int tamanho;
    public String elementos[];
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

    public String pop() throws Exception{
        if (!this.isEmpty()){
            String temp = this.elementos[topo];
            topo--;
            return temp;
        }
        else
            throw new Exception("Essa torre está vazia!");
    }
}
