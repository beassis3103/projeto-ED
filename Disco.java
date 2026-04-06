public class Disco{
    private final int qtd; //Constante do tamanho do disco
    private int contador_disco; //
    public Disco(int tam_disco, int contador_disco){
        this.qtd = tam_disco;
        this.contador_disco = contador_disco;
    }
    public int getTamanho(){
        return qtd;
    }
    public int setTamanho(int tam_disco){
        return this.qtd;
    }
    public int getContador_disco() {
        return contador_disco;
    }
    public void setContador_disco(int contador_disco) {
        this.contador_disco = 0;
    }
}
