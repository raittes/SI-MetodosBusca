package canibais.logica;

import java.util.List;

public class Nodo {
	private Estado estado;
	private Nodo pai;
	private Acition action;
	private int profundidade;
	private int custo;
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Nodo getPai() {
		return pai;
	}
	public void setPai(Nodo pai) {
		this.pai = pai;
	}
	public int getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}
	public int getCusto() {
		return custo;
	}
	public void setCusto(int custo) {
		this.custo = custo;
	}
	

}
