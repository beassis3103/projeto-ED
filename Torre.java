public class Pilha <T> {
    // atributos
    private Object[] elementos;
    private int topo;
    private int tamanho;
    // construtores
    public Pilha(int tamanho){
        this.tamanho = tamanho;
        this.elementos = new Object[tamanho];
        this.topo = -1;
    }