package com.matheus.finaceiro.DTO;

public class InfoCaixaDTO {
	private Double total;
	private Double totalEntradas;
	private Double totalSaidas;
	
	public InfoCaixaDTO(Double total, Double totalEntradas, Double totalSaidas) {
		this.total = total;
		this.totalEntradas = totalEntradas;
		this.totalSaidas = totalSaidas;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTotalEntradas() {
		return totalEntradas;
	}

	public void setTotalEntradas(Double totalEntradas) {
		this.totalEntradas = totalEntradas;
	}

	public Double getTotalSaidas() {
		return totalSaidas;
	}

	public void setTotalSaidas(Double totalSaidas) {
		this.totalSaidas = totalSaidas;
	}
	
	
}
