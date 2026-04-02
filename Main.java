import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("----Torre de Hanoi----");
        System.out.println("Digite a quantidade de discos que terão na torre: ");
        int qtd = entrada.nextInt();
        if(qtd <= 1){
            System.out.println("A quantidade de discos deve ser maior que um(1).");
            main(args);
            return;
        }
        Torre t1 = new Torre(qtd);
        Torre t2 = new Torre(qtd);
        Torre t3 = new Torre(qtd);
        try{
            for(int i = qtd; i >= 1; i--){
                t1.push(new Disco(i, 0));
            }
        } catch (InvalidMovementException | IsFullException | IsEmptyException e) {
            System.out.println("Erro ao inicializar: " + e.getMessage());
            return;
        }
        boolean continuar = true;
        while(continuar){
            System.out.println("Menu:\n 1-Mover Disco\n 2-Mostrar Torres\n 3-Reiniciar Jogo\n 4-Sair");
            int escolha = entrada.nextInt();
            switch(escolha){
                case 1 -> {
                    System.out.println("Digite a torre de origem(1-3): ");
                    int origem = entrada.nextInt();
                    System.out.println("Digite a torre de destino(1-3): ");
                    int destino = entrada.nextInt();
                    if(origem < 1 || origem > 3 || destino < 1 || destino > 3 || origem == destino){
                        System.out.println("Movimento inválido!");
                        break;
                    }
                    Torre torreOrigem = JogoHanoi.getTorre(origem, t1, t2, t3);
                    Torre torreDestino = JogoHanoi.getTorre(destino, t1, t2, t3);
                    try{
                        Disco d = torreOrigem.pop();
                        torreDestino.push(d);
                        System.out.println("Movimento realizado.");
                    }catch(IsEmptyException | IsFullException | InvalidMovementException e){
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }
                case 2 -> {
                    JogoHanoi.mostrarTorres(t1, t2, t3, qtd);
                }
                case 3 -> {
                    System.out.println("Reiniciando jogo...");
                    main(args);
                    return;
                }
                case 4 -> {
                    System.out.println("Obrigado por jogar!");
                    continuar = false;
                }
                default -> {
                    System.out.println("Opção inválida.");
                }
            }
        }
        entrada.close();
    }
}