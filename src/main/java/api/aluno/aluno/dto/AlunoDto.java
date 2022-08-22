package api.aluno.aluno.dto;

import api.aluno.aluno.entity.Aluno;

public class AlunoDto {

    public AlunoDto(){};
    public AlunoDto(Aluno aluno){
        this.id = aluno.getId();
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
    }
    private long id;
    private String matricula;
    private String nome;
    private String cpf;

 
   //Get/Sets
   //id
    public long getId() {
        return id;
    }   
    public void setId(long id) {
        this.id = id;
    }
   //Matricula
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    //Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    //cpf
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
