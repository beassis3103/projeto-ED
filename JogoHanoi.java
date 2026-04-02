public class JogoHanoi {
    public static Torre getTorre(int n, Torre t1, Torre t2, Torre t3){
        if(n == 1) return t1;
        if(n == 2) return t2;
        return t3;
    }

    public static void mostrarTorres(Torre t1, Torre t2, Torre t3, int qtd){
        System.out.println("Torre 1:");
        printTorre(t1);
        System.out.println("Torre 2:");
        printTorre(t2);
        System.out.println("Torre 3:");
        printTorre(t3);
    }

    public static void printTorre(Torre t){
        Pilha<Disco> p = t.getTam_disco();
        if(p.isEmpty()){
            System.out.println("Vazia");
            return;
        }
        for(int i = p.sizeElements() - 1; i >= 0; i--){
            Disco d = p.getElementos(i);
            String repete = "*".repeat(d.getTamanho());
            System.out.println(repete);
        }
    }



}