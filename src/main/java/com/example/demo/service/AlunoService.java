package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.respository.AlunoRespository;
import com.example.demo.entity.*;

@Service
public class AlunoService {

    @Autowired
    public AlunoRespository alunoRepository;

    public List<Aluno> listarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno criarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }
    
    public Aluno atualizarAluno(long id, Aluno alunoAtualizado){
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setNotaPrimeiroSemestre(alunoAtualizado.getNotaPrimeiroSemestre());
            aluno.setNotaSegundoSemestre(alunoAtualizado.getNotaSegundoSemestre());
            aluno.setProfessor(alunoAtualizado.getProfessor());
            aluno.setNumSala(alunoAtualizado.getNumSala());
            return alunoRepository.save(aluno);
        }).orElse(null);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
