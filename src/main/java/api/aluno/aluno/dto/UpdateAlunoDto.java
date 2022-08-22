package api.aluno.aluno.dto;


public class UpdateAlunoDto {
    private String novaMatricula;
    private String novoNome;
    private String novoCpf;

    //Getters/Setters
    //Matricula
    public String getNovaMatricula() {
        return novaMatricula;
    }
    public void setNovaMatricula(String novaMatricula) {
        this.novaMatricula = novaMatricula;
    }
    //Nome
    public String getNovoNome() {
        return novoNome;
    }
    public void setNovoNome(String novoNome) {
        this.novoNome = novoNome;
    }
    //CPF
    public String getNovoCpf() {
        return novoCpf;
    }
    public void setNovoCpf(String novoCpf) {
        this.novoCpf = novoCpf;
    }
    
}
