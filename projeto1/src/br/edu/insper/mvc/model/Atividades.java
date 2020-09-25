package br.edu.insper.mvc.model;

import java.util.Calendar;

public class Atividades {
	private Integer id;
	private String tarefa;
	private String tipo;
	private Calendar tempo;
	private Double dificuldade;
	
	
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTarefa() {
		return tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Calendar getTempo() {
		return tempo;
	}
	public void setTempo(Calendar tempo) {
		this.tempo = tempo;
	}
	public Double getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(Double dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
	
}


