package com.cinemax.model;

import java.sql.Timestamp;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exibicao {

	// Attributes
	
	private String data;
	private String horario;
	private Timestamp dataHorario;
	private int idSala;
	private int idFilme;
	private boolean audio_original;
	
	// Constructors
	
	public Exibicao() {}
	
	public Exibicao(String data, String horario, int id_sala, int id_filme, String audio_original) throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    Date date = formatter.parse(data + " " + horario);
	    this.dataHorario = new Timestamp(date.getTime());
		this.idSala = id_sala;
		this.idFilme = id_filme;
		if (audio_original == "LEG") {
			this.audio_original = true;
		} else {
			this.audio_original = false;
		}
	}
	
	// Getters
	
	public Timestamp getDataHorario() {
		//String dataHorario = this.dataHorario.toString();
		return this.dataHorario;
	}
	
	public String getData() {
	    Date date = new Date();
	    date.setTime(this.dataHorario.getTime());
	    String data = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return data;
	}
	
	public String getHorario() {
	    Date date = new Date();
	    date.setTime(this.dataHorario.getTime());
		String horario = new SimpleDateFormat("HH:mm").format(date);
		return horario;
	}
	
	public double getIdSala() {
		return idSala;
	}
	
	public int getIdFilme() {
		return idFilme;
	}
	
	public boolean getAudioOriginal() {
		return audio_original;
	}
	
	// Setters
	
	public void setDataHorario() throws ParseException {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    Date date = formatter.parse(this.data + " " + this.horario);
	    this.dataHorario = new Timestamp(date.getTime());
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	
	public void setAudioOriginal(boolean audio_original) {
		this.audio_original = audio_original;
	}
}
