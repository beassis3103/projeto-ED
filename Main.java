import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("----Torre de Hanoi----");
        System.out.println("Digite a quantidade de discos que terão na torre: ");
        int qtd = entrada.nextInt();
        //Verifica se a quantidade de discos é válida
        if(qtd <= 1){
            System.out.println("A quantidade de discos deve ser maior que um(1).");
            main(args);
            return;
        }
        //Cria as torres
        Torre t1 = new Torre(qtd);
        Torre t2 = new Torre(qtd);
        Torre t3 = new Torre(qtd);

        //Inicializa a torre 1 com os discos
        try{
            for(int i = qtd; i >= 1; i--){
                t1.push(new Disco(i, 0));
            }
        } catch (InvalidMovementException | IsFullException | IsEmptyException e) {
            System.out.println("Erro ao inicializar: " + e.getMessage());
            return;
        }

        //Começa o jogo
        boolean continuar = true; //Verificador de continuidade do jogo
        int cont = 0; //Contador de movimentos
        while(continuar){
            System.out.println("Menu:\n 1-Mover Disco\n 2-Mostrar Torres\n 3-Reiniciar Jogo\n 4-Sair");
            int escolha = entrada.nextInt();
            switch(escolha){
                case (1):
                    System.out.println("Digite a torre de origem(1-3): ");
                    int origem = entrada.nextInt();
                    System.out.println("Digite a torre de destino(1-3): ");
                    int destino = entrada.nextInt();
                    //Verifica se as torres de origem e destino são válidas
                    if(origem < 1 || origem > 3 || destino < 1 || destino > 3 || origem == destino){
                        System.out.println("Movimento inválido!");
                        break;
                    }

                    //Define as torres de origem e destino
                    Torre torreOrigem = JogoHanoi.getTorre(origem, t1, t2, t3);
                    Torre torreDestino = JogoHanoi.getTorre(destino, t1, t2, t3);

                    //Tenta realizar o movimento do disco
                    try{
                        Disco d = torreOrigem.getTopo();
                        torreDestino.push(d);
                        torreOrigem.pop();
                        System.out.println("Movimento realizado.");
                        cont++;
                    }catch(IsEmptyException | IsFullException | InvalidMovementException e){
                        System.out.println("ERRO: " + e.getMessage());
                    }

                //Mostra as torres    
                case (2):
                    JogoHanoi.mostrarTorres(t1, t2, t3, qtd);
                    break;
                
                //Reinicia o jogo
                case (3):
                    System.out.println("Reiniciando jogo...");
                    main(args); //Volta para a main para reiniciar o jogo
                    return;

                //Encerra o jogo    
                case (4):
                    System.out.println("Obrigado por jogar!");
                    continuar = false; //Muda a variável para quebrar o laço while
                    break;

                //Opção inválida    
                default:
                    System.out.println("Opção inválida.");
            }

                //Verifica se a segunda ou terceira torre estão completas, ou seja, se o jogador venceu
                if((t1.isEmpty() && t2.isEmpty() && !t3.isEmpty()) || 
                (t1.isEmpty() && !t2.isEmpty() && t3.isEmpty())){
                    System.out.println("Parabéns, você venceu!\nNúmero de movimentos: " + cont);
                    break;
                }
        }
        entrada.close(); //Fecha o scanner 
    }
}