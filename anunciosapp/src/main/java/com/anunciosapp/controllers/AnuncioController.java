package com.anunciosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anunciosapp.models.Anuncio;
import com.anunciosapp.repository.AnuncioRepository;
import com.anunciosapp.repository.RelatorioRepository;

@Controller
public class AnuncioController {
	
	@Autowired
	private AnuncioRepository ar;
	
	@Autowired
	private RelatorioRepository rr;
	
	@RequestMapping("/relatorio")
	public String relatorio() {	
		return "relatorio/relatorio";
	}
	
	@RequestMapping(value="/cadastrarAnuncio", method=RequestMethod.GET)
	public String form() {
		return "anuncio/formAnuncio";
	}
	
	@RequestMapping(value="/cadastrarAnuncio", method=RequestMethod.POST)
	public String form(Anuncio anuncio) {
		ar.save(anuncio);
		return "redirect:/cadastrarAnuncio";
	}
	
	@RequestMapping(value="/anuncios", method=RequestMethod.GET)
	public ModelAndView listaAnuncios() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Anuncio> anuncio = ar.findAll();
		mv.addObject("anuncios", anuncio);
		return mv;
	}
}
