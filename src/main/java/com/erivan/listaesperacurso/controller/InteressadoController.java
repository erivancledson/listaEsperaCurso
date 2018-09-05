package com.erivan.listaesperacurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.erivan.listaesperacurso.model.Interessado;
import com.erivan.listaesperacurso.service.InteressadoService;

@Controller
public class InteressadoController {
	
	@Autowired
	private InteressadoService service;

	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("listainteressados")
	public String listaInteressados(Model model) {
		
		Iterable<Interessado> interessados = service.obterTodos();
		model.addAttribute("interessados", interessados);
		
		return "listainteressados";
		
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(Interessado interessado,  Model model) {
		
	
		
		service.salvar(interessado);
		
		Iterable<Interessado> interessados = service.obterTodos();
		
		model.addAttribute("interessados", interessados);
		
		return "listainteressados";
	}
}
