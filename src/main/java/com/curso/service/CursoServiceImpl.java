package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursoDAO;
import com.curso.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	CursoDAO cursoDAO;
	
	@Override
	public List<Curso> findCursos() {
		return cursoDAO.findAll();
	}

	@Override
	public List<Curso> saveCurso(Curso curso) {
		cursoDAO.save(curso);
		return findCursos();
	}

	@Override
	public List<Curso> deleteCurso(String id) {
		cursoDAO.deleteById(id);
		return findCursos();
	}

	@Override
	public void updateDuracion(String id, int duracion) {
		Curso curso = findCurso(id);
		if(curso != null) {
			curso.setDuracion(duracion);
			cursoDAO.save(curso);
		}
	}

	@Override
	public Curso findCurso(String id) {
		return cursoDAO.findById(id).orElse(null);
	}

	@Override
	public List<Curso> findByPrecioBetween(double min, double max) {
		return cursoDAO.findByPrecioBetween(min,max);
	}

}
