import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean continuar = true;
        listaSequencial listaPrincipa = new listaSequencial();
        FuncoesMenu menu = new FuncoesMenu();

        while (continuar) {
            menu.menu();
            Scanner entrada = new Scanner(System.in);
            System.out.print(">>>");
            int key = entrada.nextInt();
            switch (key) {
                case 1:
                    listaEncadeada listaSecundaria = new listaEncadeada();
                    Aluno estudante = new Aluno();
                    System.out.print("Qual seu rgm? ");
                    estudante.setMatricula(entrada.nextInt());
                    entrada.nextLine();
                    System.out.print("Quer adicionar uma disciplina? [s/n] ");
                    String ops = entrada.nextLine();

                    if (ops.toLowerCase().equals("s")) {
                        while (true) {
                            materias disciplina = new materias();
                            System.out.print("\nDigite o nome da disciplina? ");
                            disciplina.setDiciplina(entrada.nextLine());
                            System.out.print("Digite a nota total? ");
                            disciplina.setNota(entrada.nextInt());

                            System.out.println("----------\n" +
                                    "A disciplina: " + disciplina.getDiciplina() + "\nA nota : " + disciplina.nota);

                            System.out.print("Quer salvar? [s/n] ");

                            entrada.nextLine();
                            String verificar = entrada.nextLine();

                            if (verificar.toLowerCase().equals("s")) {
                                listaSecundaria.adiciona(disciplina);
                            } else {
                                System.out.println("ENTÃO NÃO SALVOU");
                            }

                            System.out.print("Quer continuar adicionando disciplina? [s/n]");
                            String terminar = entrada.nextLine();
                            if (terminar.toLowerCase().equals("n")) {
                                estudante.setPrimeiro(listaSecundaria.getInicio());
                                listaPrincipa.inserirAluno(estudante);
                                break;
                            }
                        }
                    } else if (ops.toLowerCase().equals("n")) {
                        listaPrincipa.inserirAluno(estudante);
                    } else {
                        System.out.println("Resposta inválida");
                    }
                    break;

                case 2:
                    int rgm = entrada.nextInt();
                    System.out.print("Digite o Rgm que você quer remover: ");
                    listaPrincipa.removerAlunoPelaMatricula(rgm);
                    listaPrincipa.exibirLista();
                    break;

                case 3:
                    System.out.print("Digite o ID que você quer remover: ");
                    int id = entrada.nextInt();
                    listaPrincipa.removerAlunoPeloId(id);
                    listaPrincipa.exibirLista();
                    break;

                case 4:
                    System.out.println("Digite a RGM que você quer?");
                    int rgmBusca = entrada.nextInt();

                    if (listaPrincipa.temEsseItemNaLista(rgmBusca)) {
                        System.out.println("ALUNO ENCONTRADO COM ESTE RGM");
                        listaPrincipa.exibirLista();
                    } else {
                        System.out.println("NENHUM ALUNO ENCONTRADO COM ESTE RGM");
                    }
                    break;

                case 5:
                    listaPrincipa.exibirLista();
                    System.out.print("\npressione enter para sair... ");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;

                case 6:
                    if (listaPrincipa.tamanho <= 0) {
                        System.out.println("NENHUM ELEMENTO NA LISTA");
                        break;
                    }
                    System.out.println("Digite o RGM que você quer remover as disciplinas? ");
                    int rgmBuscaRemove = entrada.nextInt();

                    if (listaPrincipa.temEsseItemNaLista(rgmBuscaRemove)) {
                        System.out.println("ALUNO ENCONTRADO COM ESTE RGM");
                        listaPrincipa.limparListaEncadeada(rgmBuscaRemove);
                        listaPrincipa.exibirLista();
                    } else {
                        System.out.println("NENHUM ALUNO ENCONTRADO COM ESTE RGM");
                    }
                    break;

                case 7:
                    continuar = false;
                    entrada.close();
                    break;

                default:
                    entrada.close();
                    break;
            }
        }
    }
}

