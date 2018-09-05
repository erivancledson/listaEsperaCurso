package com.erivan.listaesperacurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erivan.listaesperacurso.model.Interessado;
import com.erivan.listaesperacurso.repository.InteressadoRepository;

@Service
public class InteressadoService {
	
	@Autowired
	private InteressadoRepository repository;
	
	public Iterable<Interessado> obterTodos(){
		
		Iterable<Interessado> interessados = repository.findAll();
		return interessados;
		
	}
	
	public void salvar(Interessado interessado) {
		repository.save(interessado);
	}

}
