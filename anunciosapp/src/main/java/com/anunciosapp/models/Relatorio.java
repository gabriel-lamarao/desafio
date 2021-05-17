package com.anunciosapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Relatorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoRelatorio;
	
	private double totalInvestido;
	private int visualizacoes;
	private int cliques;
	private int compartilhamentos;
	
	private int periodo;
	@OneToOne
	private Anuncio anuncio;
	
	
	public void calculaAlcance(double investimentoDiario) {
		
		
		// Visualizações por real investido (Views)
		double views = investimentoDiario * 30;

		// Porcentagem de cliques por cada visualização (Clicks)
		double clicks = views * 0.12;

		// Porcentagem de compartilhamentos por clique em redes sociais (Shares Social Media)
		double sharesSM = clicks * 0.15;		
		
		// Visualizacoes a cada compartilhamento (viewsShare)
		double viewsShare = sharesSM * 40.0;
		
		// Compartilhamentos recebe o valor de compatilhamentos em sequencia 
		viewsShare = viewsShare * 4;
		
		// Total de visualizações mais compartilhamentos por dia
		double totalViews = views +viewsShare;
		int alcanceDiario = (int) totalViews;
		
		// Total de Visualizações dentro do periodo do anuncio
		this.visualizacoes = alcanceDiario * periodo;
		
		// Valor total investido dentro do periodo do anuncio
		this.totalInvestido = investimentoDiario * periodo;
		
		// Recebe o total de cliques 
		int cliquesDiario = (int) clicks;
		this.cliques = cliquesDiario * periodo;
		
		// Recebe o total de compartilhamentos
		int compartilhamentosDiario = (int) viewsShare;
		this.compartilhamentos = compartilhamentosDiario * periodo;
		
	}
	
	public Long getCodigoRelatorio() {
		return codigoRelatorio;
	}

	public void setCodigoRelatorio(Long codigoRelatorio) {
		this.codigoRelatorio = codigoRelatorio;
	}

	public double getTotalInvestido() {
		return totalInvestido;
	}

	public void setTotalInvestido(double totalInvestido) {
		this.totalInvestido = totalInvestido;
	}

	public int getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(int visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public int getCliques() {
		return cliques;
	}

	public void setCliques(int cliques) {
		this.cliques = cliques;
	}

	public int getCompartilhamentos() {
		return compartilhamentos;
	}

	public void setCompartilhamentos(int compartilhamentos) {
		this.compartilhamentos = compartilhamentos;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

}
