package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursoDAO extends JpaRepository<Curso, String> {
	List<Curso> findByPrecioBetween(double min, double max);
}
