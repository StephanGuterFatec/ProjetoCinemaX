package com.cinemax;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cinemax.model.Exibicao;
import com.cinemax.model.ExibicaoService;

@Controller
public class ExibicaoController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/nova-exibicao")
	public String pegarFilmes(Model model) {
		ExibicaoService exibicaoDao = context.getBean(ExibicaoService.class);
		
		List<Map<String,Object>> filmes = exibicaoDao.pegarFilmes();
		model.addAttribute("filmes", filmes);
		
		List<Map<String,Object>> salas = exibicaoDao.pegarSalas();
		model.addAttribute("salas", salas);
		
		return "form-exibicao";
	}
	
	@PostMapping("/nova-exibicao")
	public String inserirExibicao(@ModelAttribute Exibicao modelExibicao, Model model) throws ParseException {
		ExibicaoService exibicaoDao = context.getBean(ExibicaoService.class);
		exibicaoDao.insert(modelExibicao);
		return "novaexibicaosucesso";
	}
}
