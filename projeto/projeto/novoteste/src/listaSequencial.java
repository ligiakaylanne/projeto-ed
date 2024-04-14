public class listaSequencial {
    // Declaração de uma classe chamada listaSequencial

    Aluno[] lista = new Aluno[60];
    // Declaração de um array de Aluno chamado lista com capacidade para 60 elementos
    int tamanho = 0;
    // Variável que armazena o tamanho atual da lista (quantidade de elementos inseridos)

    public boolean estaVazia() {
        // Método para verificar se a lista está vazia
        return (tamanho == 0);
    }

    public boolean estaCheia() {
        // Método para verificar se a lista está cheia
        return (tamanho == lista.length);
    }

    public int tamanhoLista() {
        // Método para retornar o tamanho atual da lista
        return (tamanho);
    }

    public boolean temEsseItemNaLista(int number) {
        // Método para verificar se um determinado item está na lista
        for (int i = 0; i < tamanho; i++) {
            if (lista[i].matricula == number) {
                // Compara a matrícula do aluno com o número fornecido
                return true;
            }
        }
        return false;
    }

    public void deslocarParaDireita(int pos) {
        // Método para deslocar elementos para a direita a partir de uma determinada posição
        for (int i = tamanho; i > pos; i--)
            lista[i] = lista[i - 1];
    }

    public boolean inserirAluno(Aluno aluno) {
        // Método para inserir um aluno na lista
        if (estaCheia())
            return false; // Se a lista estiver cheia, retorna falso

        if (tamanho == 0) {
            lista[0] = aluno; // Se a lista estiver vazia, insere na primeira posição
            tamanho++;
            return true;
        }

        int i = 0;
        while (i < tamanho && lista[i].matricula < aluno.matricula) {
            i++;
        }
        deslocarParaDireita(i);
        lista[i] = aluno; // Insere o aluno na posição correta
        tamanho++;
        return true;
    }

    public void deslocarParaEsquerda(int pos) {
        // Método para deslocar elementos para a esquerda a partir de uma determinada posição
        for (int i = pos; i < (tamanho - 1); i++)
            lista[i] = lista[i + 1];
    }

    public Aluno removerAlunoPelaMatricula(int matriculaRemover) {
        // Método para remover um aluno da lista pela matrícula
        if (estaVazia())
            return null; // Se a lista estiver vazia, retorna nulo

        for (int i = 0; i < tamanho; i++) {
            if (lista[i].matricula == matriculaRemover) {
                Aluno removido = lista[i]; // Salva o aluno a ser removido
                deslocarParaEsquerda(i); // Remove o aluno deslocando os elementos para a esquerda
                tamanho--;
                return removido;
            }
        }
        return null; // Retorna nulo se o aluno não for encontrado
    }

    public Aluno removerAlunoPeloId(int id) {
        // Método para remover um aluno da lista pelo ID
        if (estaVazia() || id < 0 || id >= tamanho)
            return null; // Se a lista estiver vazia ou o ID for inválido, retorna nulo

        Aluno removido = lista[id]; // Salva o aluno a ser removido
        deslocarParaEsquerda(id); // Remove o aluno deslocando os elementos para a esquerda
        tamanho--;
        return removido;
    }

    public void limparListaEncadeada(int matricula) {
        // Método para limpar a lista encadeada de um aluno pelo número de matrícula
        for (int i = 0; i < tamanho; i++) {
            if (lista[i].matricula == matricula) {
                lista[i].inicio = null; // Define o início da lista encadeada como nulo
                lista[i].setPrimeiro(null); // Define o primeiro nó da lista encadeada como nulo
                return;
            }
        }
    }

    public void exibirLista() {
        // Método para exibir a lista de alunos
        String mensagem = "";
        if (tamanho == 0) {
            System.out.println("|  Estamos sem alunos |");
        } else {
            for (int i = 0; i < tamanho; i++) {
                materias atual = lista[i].inicio; // Obtém o início da lista encadeada de disciplinas do aluno
                if (tamanho > 1) {
                    while (atual.getProximo() != null) {
                        mensagem += atual.getDiciplina() + ", "; // Adiciona disciplinas à mensagem
                        atual = atual.getProximo();
                    }
                    mensagem += atual.getDiciplina();
                }
                mensagem = (mensagem.equals("")) ? " Nao tem disciplinas" : mensagem;
                // Verifica se a mensagem está vazia e ajusta se necessário
                System.out.println("-----------------" +
                                   "\nID do Aluno " + (i + 1) +
                                   "\nMatricula: " + lista[i].matricula +
                                   "\nDisciplinas: " + mensagem +
                                   "\n-----------------");
                mensagem = "";
            }
        }
    }

    public void exibirListaUmElemento(int id) {
        // Método para exibir informações de um aluno específico
        String mensagem = "";
        if (tamanho == 0) {
            System.out.println("|  Estamos sem alunos |");

        } else {
            if (id >= 0 && id < tamanho) {
                materias atual = lista[id].inicio; // Obtém o início da lista encadeada de disciplinas do aluno
                if (tamanho > 1) {
                    while (atual.getProximo() != null) {
                        mensagem += atual.getDiciplina() + ", "; // Adiciona disciplinas à mensagem
                        atual = atual.getProximo();
                    }
                    mensagem += atual.getDiciplina();
                }
                mensagem = (mensagem.equals("")) ? " Nao tem disciplinas" : mensagem;
                // Verifica se a mensagem está vazia e ajusta se necessário
                System.out.println("-----------------------------" +
                                   "\nID do Aluno " + (id + 1) +
                                   "\nMatricula: " + lista[id].matricula +
                                   "\nDisciplinas: " + mensagem +
                                   "\n-----------------------------");
            } else {
                System.out.println("ID de aluno inválido.");
            }
        }
    }
}
