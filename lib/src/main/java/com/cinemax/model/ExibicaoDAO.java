package com.cinemax.model;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExibicaoDAO {
	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    public List<Map<String, Object>> getExibicoes() {
    	String sql = "SELECT EXTRACT(DAY FROM e.dt_exibicao) AS DIA, EXTRACT(MONTH FROM e.dt_exibicao) AS MES, EXTRACT(YEAR FROM e.dt_exibicao) AS ANO, EXTRACT(HOUR FROM e.dt_exibicao) AS HORA,	EXTRACT(MINUTE FROM e.dt_exibicao) AS MINUTO, s.nm_sala AS SALA, f.nm_filme AS FILME, ts.nm_tipo_sala AS TIPO_SALA,	CASE WHEN (e.ic_audio_original = true) THEN 'LEG' ELSE 'DUB' END AS DUB_LEG FROM exibicao AS e JOIN filme AS f  ON (e.cd_filme = f.cd_filme) JOIN sala AS s  ON (e.cd_sala = s.cd_sala) JOIN tipo_sala AS ts ON (s.cd_tipo_sala = ts.cd_tipo_sala) ORDER BY ANO, MES, DIA;";
    	List<Map<String, Object>> listaExibicoes = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return listaExibicoes;
    }
    
    public List<Map<String, Object>> pegarFilmes() {
    	String sql = "SELECT cd_filme AS id_filme, nm_filme AS filme FROM filme;";
    	List<Map<String, Object>> listaFilmes = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return listaFilmes;
    }
    
    public List<Map<String, Object>> pegarSalas() {
    	String sql = "SELECT s.cd_sala AS id_sala, s.nm_sala AS sala, ts.nm_tipo_sala AS tipo_sala FROM sala AS s JOIN tipo_sala AS ts ON (s.cd_tipo_sala = ts.cd_tipo_sala);";
    	List<Map<String, Object>> listaSalas = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return listaSalas;
    }
    
    public void insert(Exibicao exibicao) throws ParseException {
    	exibicao.setDataHorario();
        String sql = "INSERT INTO exibicao (dt_exibicao, cd_sala, cd_filme, ic_audio_original) VALUES (?,?,?,?)";
        jdbc.update(sql, new Object[]{
        		exibicao.getDataHorario(), exibicao.getIdSala(), exibicao.getIdFilme(), exibicao.getAudioOriginal()
        });
    }
}
