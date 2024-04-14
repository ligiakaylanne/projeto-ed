public class materias {
    // Variáveis de instância para armazenar informações sobre a disciplina
    String diciplina; // Nome da disciplina
    float nota; // Nota da disciplina

    // Referência para a próxima matéria na lista encadeada
    materias proximo = null;

    // Construtor que aceita nota e disciplina como parâmetros
    public materias(float nota, String diciplina) {
        this.diciplina = diciplina; // Define o nome da disciplina
        this.nota = nota; // Define a nota da disciplina
    }

    // Construtor vazio
    public materias() {
        // Construtor vazio, não realiza nenhuma operação
    }

    // Método getter para obter o nome da disciplina
    public String getDiciplina() {
        return diciplina;
    }

    // Método setter para definir o nome da disciplina
    public void setDiciplina(String diciplina) {
        this.diciplina = diciplina;
    }

    // Método getter para obter a nota da disciplina
    public float getNota() {
        return nota;
    }

    // Método setter para definir a nota da disciplina
    public void setNota(float nota) {
        this.nota = nota;
    }

    // Método getter para obter a próxima matéria na lista encadeada
    public materias getProximo() {
        return proximo;
    }

    // Método setter para definir a próxima matéria na lista encadeada
    public void setProximo(materias proximo) {
        this.proximo = proximo;
    }

}
