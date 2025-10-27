package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.curso.model.Curso;
import com.curso.service.CursoService;

@RestController
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	@GetMapping(value="/cursos")
	public List<Curso> findCursos(){
		return cursoService.findCursos();
	}
	
	@PostMapping(value="/curso", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> saveCurso(@RequestBody Curso curso) {
		return cursoService.saveCurso(curso);
	}
	
	@DeleteMapping(value="/curso/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> deleteCurso(@PathVariable String id) {
		return cursoService.deleteCurso(id);
	}
	
	@PutMapping(value="curso/{id}/{duracion}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateDuracion(@PathVariable String id, @PathVariable int duracion) {
		cursoService.updateDuracion(id, duracion);
	}
	
	@GetMapping(value="/curso/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso findCurso(@PathVariable String id) {
		return cursoService.findCurso(id);
	}
	
	@GetMapping(value="/cursos/precio/{min}/{max}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> findByPrecioBetween(@PathVariable int min,@PathVariable int max) {
		return cursoService.findByPrecioBetween(min, max);
	}
	
	
}
