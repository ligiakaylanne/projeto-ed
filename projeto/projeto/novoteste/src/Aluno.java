public class Aluno {
    int matricula; // Variável para armazenar a matrícula do aluno
    materias inicio; // Referência para o início da lista de matérias associadas ao aluno

    // Construtor vazio
    public Aluno() {
        // Este construtor não realiza nenhuma operação
    }

    // Construtor que aceita a matrícula como argumento
    public Aluno(int matricula) {
        this.matricula = matricula; // Define a matrícula do aluno
    }

    // Método para obter a matrícula do aluno
    public int getMatricula() {
        return matricula;
    }

    // Método para definir a matrícula do aluno
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // Método para obter o primeiro elemento da lista de matérias
    public materias getPrimeiro() {
        return inicio;
    }

    // Método para definir o primeiro elemento da lista de matérias
    public void setPrimeiro(materias primeiro) {
        this.inicio = primeiro;
    }
}

