package api.aluno.aluno.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import api.aluno.aluno.dto.AlunoDto;
import api.aluno.aluno.dto.UpdateAlunoDto;
import api.aluno.aluno.entity.Aluno;
import api.aluno.aluno.repository.AlunoRepository;

@Service
public class AlunoService implements AlunoServiceInterface {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        List<AlunoDto> retornoListaAlunos = new ArrayList<>();
        List<Aluno> listaAlunos = alunoRepository.findAll();

        for (Aluno aluno : listaAlunos) {
            AlunoDto aux = new AlunoDto(aluno);
            retornoListaAlunos.add(aux);
        }
        return retornoListaAlunos;

    }

    @Override
    public AlunoDto buscarAlunoPorMatricula(String Matricula) {
        Aluno aluno = alunoRepository.findByMatricula(Matricula);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        AlunoDto alunoEncontrado = new AlunoDto(aluno);
        return alunoEncontrado;
    }

    @Override
    public AlunoDto buscarAlunoPorId(long id) {
        Aluno aluno = alunoRepository.findById(id);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        AlunoDto alunoEncontrado = new AlunoDto(aluno);
        return alunoEncontrado;
    }

    @Override
    public AlunoDto criar(AlunoDto novoAluno) {
        Aluno aluno = new Aluno();
        aluno.setMatricula(novoAluno.getMatricula());
        aluno.setNome(novoAluno.getNome());
        aluno.setCpf(novoAluno.getCpf());
        try {
            alunoRepository.save(aluno);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
        }
        AlunoDto alunoRetorno = new AlunoDto(alunoRepository.findByMatricula(aluno.getMatricula()));

        return alunoRetorno;
    }

    @Override
    public AlunoDto atualizar(UpdateAlunoDto novosDados, long id) {
        Aluno alunoParaAtualizar = alunoRepository.findById(id);
        // se aluno não existe
        if (alunoParaAtualizar == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }

        // Update Matricula
        if (novosDados.getNovaMatricula() != null) {
            alunoParaAtualizar.setMatricula(novosDados.getNovaMatricula());
        }

        // Update Nome
        if (novosDados.getNovoNome() != null) {
            alunoParaAtualizar.setNome(novosDados.getNovoNome());
        }

        // Update CPF
        if (novosDados.getNovoCpf() != null) {
            alunoParaAtualizar.setCpf(novosDados.getNovoCpf());
        }

        Aluno alunoAtualizado = alunoRepository.save(alunoParaAtualizar);

        AlunoDto retornoAlunoAtualizado = new AlunoDto(alunoAtualizado);
        return retornoAlunoAtualizado;
    }

    @Override
    public void deletarAluno(long id) {
        Aluno alunoParaDeletar = alunoRepository.findById(id);
        if (alunoParaDeletar == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        alunoRepository.delete(alunoParaDeletar);
    }

}
