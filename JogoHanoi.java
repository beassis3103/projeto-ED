public class JogoHanoi {
    public static void main(String[] args){
        System.out.println("----Torre de Hanoi----");
        Scanner entrada_escolha = new Scanner(System.in);
        System.out.println("Menu:\n 1-Mover Disco\n 2-Mostrar Torres\n 3-Reiniciar Jogo\n 4- Sair");
        escolha = entrada_escolha.nextInt();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a quantidade de discos que terão na torre: ");
        qtd = entrada.nextInt();
        Disco tamanho = new Disco(tam_disco);
        try{
            t1 = new Torre(qtd);
            t2 = new Torre(qtd);
            t3 = new Torre(qtd);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Tente novamente.\n");
        }
    }
}