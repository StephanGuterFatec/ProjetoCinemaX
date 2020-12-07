package com.cinemax.model;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExibicaoService {
	@Autowired
	ExibicaoDAO exibicaoDAO;
	
	  public List<Map<String, Object>> getExibicoes() {
	      return exibicaoDAO.getExibicoes();
	  }
	  
	  public List<Map<String, Object>> pegarFilmes() {
	      return exibicaoDAO.pegarFilmes();
	  }
	  
	  public List<Map<String, Object>> pegarSalas() {
	      return exibicaoDAO.pegarSalas();
	  }
	  
	  public void insert(Exibicao novaExibicao) throws ParseException {
		  exibicaoDAO.insert(novaExibicao);
	  }
}
