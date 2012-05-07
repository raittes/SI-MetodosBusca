package canibais.logica;

public class Nodo {
	private Estado estado;
	private Nodo pai;
	private Action action;
	private int profundidade;
	private int custo;
	public Nodo(Nodo pai, Action action, Estado estado, int profundidade, int custo) {
		this.pai = pai;
		this.setAction(action);
		this.estado = estado;
		this.profundidade = profundidade;
		this.custo = custo;
	}
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
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	

}
