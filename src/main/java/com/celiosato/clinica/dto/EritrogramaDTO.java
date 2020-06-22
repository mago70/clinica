package com.celiosato.clinica.dto;

import java.io.Serializable;

import com.celiosato.clinica.domain.Eritrograma;

public class EritrogramaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double eritrocitos;
	private double hemoglobina;
	private String obs;

	
	public EritrogramaDTO() {
		
	}
	
	public EritrogramaDTO(Eritrograma obj) {
		id = obj.getId();
		eritrocitos = obj.getEritrocitos();
		hemoglobina = obj.getHemoglobina();
		obs = obj.getObs();	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getEritrocitos() {
		return eritrocitos;
	}

	public void setEritrocitos(double eritrocitos) {
		this.eritrocitos = eritrocitos;
	}

	public double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
