package com.cinemax;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cinemax.model.ExibicaoService;

@Controller
public class HomeController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
	@GetMapping("/exibircartaz")
	public String exibirCartaz(Model model) {
		ExibicaoService exibicaoDao = context.getBean(ExibicaoService.class);
		List<Map<String,Object>> exibicoes = exibicaoDao.getExibicoes();
		model.addAttribute("exibicoes", exibicoes);
		return "emcartaz";
	}
	
	@GetMapping("/painel")
	public String exibirPainel(Model model) {
		return "painel";
	}
}
