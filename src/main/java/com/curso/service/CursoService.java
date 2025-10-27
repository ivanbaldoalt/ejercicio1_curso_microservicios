package com.curso.service;

import java.util.List;
import com.curso.model.Curso;

public interface CursoService {
	List<Curso> findCursos();
	List<Curso> saveCurso(Curso curso);
	List<Curso> deleteCurso(String id);
	void updateDuracion(String id, int duracion);
	Curso findCurso(String id);
	List<Curso> findByPrecioBetween(double min, double max);
	
}
