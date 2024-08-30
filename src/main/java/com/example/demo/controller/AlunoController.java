package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.AlunoService;
import com.example.demo.entity.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarTodosAlunos() {
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        return alunoService.atualizarAluno(id, alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }
}
