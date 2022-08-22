package api.aluno.aluno.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.aluno.aluno.dto.AlunoDto;
import api.aluno.aluno.dto.UpdateAlunoDto;
import api.aluno.aluno.service.AlunoServiceInterface;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private AlunoServiceInterface alunoService;

    public AlunoController(AlunoServiceInterface alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("getAll")
    public List<AlunoDto> getAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("getByMatricula/{matricula}")
    public AlunoDto getAlunoMatricula(
            @PathVariable(name = "matricula") String matricula) {
        return alunoService.buscarAlunoPorMatricula(matricula);
    }

    @GetMapping("getById/{id}")
    public AlunoDto getAlunoId(
            @PathVariable(name = "id") long id) {
        return alunoService.buscarAlunoPorId(id);
    }

    @PostMapping("addAluno")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDto CreateAluno(@RequestBody AlunoDto novoAluno) {
        alunoService.criar(novoAluno);
        return novoAluno;
    }

    @PutMapping("updateAluno/{id}")
    public AlunoDto UpdateAluno(
            @RequestBody UpdateAlunoDto novosDados,
            @PathVariable long id) {
        AlunoDto AlunoAtualizado = alunoService.atualizar(novosDados, id);

        return AlunoAtualizado;
    }

    @DeleteMapping("deleteAluno/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteAluno(@PathVariable long id) {
        alunoService.deletarAluno(id);
    }

}
