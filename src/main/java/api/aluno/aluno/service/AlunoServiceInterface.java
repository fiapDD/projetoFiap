package api.aluno.aluno.service;

import java.util.List;

import api.aluno.aluno.dto.AlunoDto;
import api.aluno.aluno.dto.UpdateAlunoDto;

public interface AlunoServiceInterface {
    
    List<AlunoDto> listarAlunos();
    AlunoDto buscarAlunoPorMatricula(String Matricula);
    AlunoDto buscarAlunoPorId(long id);
    AlunoDto criar(AlunoDto novoAluno);
    AlunoDto atualizar(UpdateAlunoDto novosDados, long id);
    void deletarAluno(long id);
     

}
