package api.aluno.aluno.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.aluno.aluno.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    List<Aluno> findAllByNomeLike(String nome);
    Aluno findById(long id);
    
    Aluno findByMatricula(String matricula);

}
