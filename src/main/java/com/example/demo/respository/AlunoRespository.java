package com.example.demo.respository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRespository extends JpaRepository<Aluno, Long>{
    
}