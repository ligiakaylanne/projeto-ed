public class listaEncadeada {
    private materias inicio; // Referência para o início da lista encadeada de matérias
    private materias fim; // Referência para o fim da lista encadeada de matérias
    private int tamanho = 0; // Variável para armazenar o tamanho da lista encadeada

    // Método para adicionar uma nova célula à lista encadeada
    public void adiciona(materias celula) {
        if (this.tamanho == 0) { // Se a lista estiver vazia
            this.inicio = celula; // Define o início da lista como a nova célula
        } else {
            this.fim.setProximo(celula); // Define o próximo da última célula como a nova célula
        }
        this.fim = celula; // Define a nova célula como o novo fim da lista
        this.tamanho++; // Incrementa o tamanho da lista
    }

    // Método para obter o tamanho da lista encadeada
    public int getTamanho() {
        return this.tamanho;
    }

    // Método para obter o início da lista encadeada
    public materias getInicio() {
        return inicio;
    }

    // Método para obter as disciplinas da lista encadeada (mesmo que o início)
    public materias getDisplinas() {
        return inicio;
    }

    // Método toString para representar a lista encadeada como uma String
    @Override
    public String toString() {
        if (this.tamanho == 0) { // Se a lista estiver vazia
            return "[]"; // Retorna uma representação de lista vazia
        }

        StringBuilder builder = new StringBuilder("["); // Inicializa um StringBuilder para construir a representação da lista

        materias atual = this.inicio; // Começa do início da lista
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getDiciplina()).append(","); // Adiciona a disciplina da célula atual seguida de vírgula
            atual = atual.getProximo(); // Move para a próxima célula
        }
        builder.append(atual.getDiciplina()).append("]"); // Adiciona a disciplina da última célula sem vírgula adicional
        return builder.toString(); // Retorna a representação da lista como String
    }
}
