import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Robo> robos = new ArrayList<>();

        int escolha = 0;
        Robo robo1 = null;
        Robo robo2 = null;

         /*
            O código deverá ser positivo e exclusivo; o nome não poderá estar vazio; o ataque deverá estar entre 10 e 30; 
            e a defesa, entre 0 e 20. Cada robô começará com 100 de energia e os demais indicadores zerados.
            Realizar um combate: possuir pelo menos 30 de energia
        */

       do {
            System.out.println("========== CAMPEONATO DE ROBÔS ==========");
            System.out.println(" (1) Cadastrar robô");
            System.out.println(" (2) Buscar robô por código");
            System.out.println(" (3) Listar robôs");
            System.out.println(" (4) Realizar combate (Etapa Escolha de robôs)");
            System.out.println(" (5) Executar Combate");
            System.out.println(" (6) Sair");
            System.out.println("=========================================");

            try {
                escolha = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, informe um número.");
                break;
            }

            switch (escolha) {
                case 1: {
                    System.out.println("Informe o código do robô");
                    int codigo = scanner.nextInt();
                    if (codigo <= 0) {
                        System.out.println("O código deve ser um número positivo.");
                        break;
                    }

                    System.out.println("Informe o nome do robô");
                    String nome = scanner.next();

                    if (nome == null ) {
                        System.out.println("O nome não pode ser vazio.");
                        break;
                    }

                    System.out.println("Ataque (10 a 30)");
                    int ataque = scanner.nextInt();

                    if (ataque < 10 || ataque > 30) {
                        System.out.println("O ataque deve estar entre 10 e 30.");
                        break;
                    }

                    System.out.println("Defesa (0 a 20)");
                    int defesa = scanner.nextInt();

                    if (defesa < 0 || defesa > 20) {
                        System.out.println("A defesa deve estar entre 0 e 20.");
                        break;
                    }

                    Robo robo = new Robo(codigo, nome, ataque, defesa);
                    robos.add(robo);
                    System.out.println("Robô cadastrado com sucesso!");

                break;
                }

                case 2:{
                    int cdg;
                    try {
                        System.out.println("Informe o código do robô que deseja buscar:");
                        cdg = scanner.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida, informe um número.");
                        break; 
                    }
                    boolean encontrou = false;

                    for (Robo robo : robos) {

                        if (robo.codigo == cdg) {
                            robo.consultarRobos();
                            encontrou = true;
                            break;
                        } 
                    }

                    if (!encontrou) {
                        System.out.println("Código do robô não encontrado.");
                    }
                    
                break;
                }

                case 3:{
                    for (Robo robo : robos) {
                        robo.consultarRobos();
                    }
                break;
                }

                /*
                solicitar os códigos de dois robôs distintos. Ambos deverão existir e possuir pelo menos 30 de energia
                */
                case 4:{
                    if (robos.size() < 2) {
                        System.out.println("Para realizar um combate é preciso ter cadastro mínimo de dois robôs.");
                        break;
                    }

                    int cod1 = 0;
                    int cod2 = 0;

                    boolean entradaValida = true;

                    try {
                        System.out.println("Código do 1º robô: ");
                        cod1 = scanner.nextInt();
                        System.out.println("Código do 2º robô: ");
                        cod2 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida, informe apenas números.");
                        entradaValida = false;
                    }

                    if (!entradaValida) {
                        break;
                    }

                    // Validando os códigos
                    if (cod1 == cod2) {
                        System.out.println("Os códigos devem ser diferentes.");
                        break;
                    }

                    // Identificando os robôs
                    robo1 = null;
                    robo2 = null;

                    for (Robo robo : robos) {
                        if (robo.codigo == cod1) {
                            robo1 = robo;
                        }
                        if (robo.codigo == cod2) {
                            robo2 = robo;
                        }
                    }

                    if (robo1 == null || robo2 == null) {
                        System.out.println("Combate não pode ser iniciado: algum dos códigos não existe.");
                        break;
                    }

                    // Validando energia
                    if (robo1.energia < Robo.energia_min || robo2.energia < Robo.energia_min) {
                        System.out.println("Os dois robôs precisam ter pelo menos 30 de energia.");
                        break;
                    }
                break;
                }
                
                case 5:{

                    /*
                    O robô com menos pontos atacará primeiro em todas as rodadas daquele combate. 
                    Em caso de empate, começará o de menor código. Essa ordem será definida antes do início da luta.
                    */
                    if (robo1 == null || robo2 == null) {
                        System.out.println("Escolha os robôs na opção 4.");
                        break;
                    }

                break;
                }

                case 6:{
                    System.out.println("Saindo...!");
                break;
                }
            
                default:
                    System.out.println("Entrada inválida");
                break;
            }
       } while (escolha != 6);
        
        scanner.close();
    }
}
