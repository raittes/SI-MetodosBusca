package canibais.logica;

import java.util.ArrayList;
import java.util.List;

public class ProblemaDosCanibais {
	private static final int LADO_ESQUERDO = 1;
	private static final int LADO_DIREITO = 0;
	private List<Pessoa> canibaisEsquerda;
	private List<Pessoa> canibaisdireita;
	private List<Pessoa> exploradoresEsquerda;
	private List<Pessoa> exploradoresDireita;
	private List<Nodo> resultados;
	private Canibal chefe;
	private Barco barco;
	private Nodo atual;
	public Estado objetivo = new Estado(0, 0, 0,0);
	public ProblemaDosCanibais(){
		setAtual(new Nodo(null,null,new Estado(3,3,1,1),0,0));		
	}
	public Barco getBarco() {
		return barco;
	}
	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public void printSolucaoComSubidaEncosta() {
		List<Nodo> possibilidades = new ArrayList<Nodo>();
		if(atual.getEstado().equal(objetivo)){
			imprime("Finalizado!");
		}else{
			
			if(atual.getPai()==null){			
				geraPossibilidadesRaiz(atual, possibilidades);
				setAtual(getMelhorPossibilidade());
			}else{
				
			}
		}
		
	}
	private void imprime(String string) {
		System.out.println(string);
		
	}
	private Nodo getMelhorPossibilidade() {
		if(getAtual().getEstado().equal(objetivo)){
			
		}
		return null;
	}
	private void geraPossibilidadesRaiz(Nodo nodo, List<Nodo> possibilidades) {
		Estado estadotmp;
		Action actiontmp;
		estadotmp = new Estado(2, 2, 0,1);
		actiontmp = new Action(Action.ACTION_ATRAVESSA_EXP_E_CAN);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
		estadotmp = new Estado(2, 2, 0,0);
		actiontmp = new Action(Action.ACTION_ATRAVESSA_EXP_E_CAN);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
		estadotmp = new Estado(1, 3, 0,0);
		actiontmp = new Action(Action.ACTION_ATRAVESSA_2_CANIBAIS);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
		estadotmp = new Estado(3, 1, 0,0);
		actiontmp = new Action(Action.ACTION_ATRAVESSA_2_EXPLORADORES);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
	}
	private void expande(Nodo nodo) {
		if(nodo.getEstado().equal(objetivo)){			
			imprime("chegou ao fim!");
		}else if(nodo.getProfundidade()<30){
		}
		
	}
	private List<Nodo> geraAllPossibilidades(Nodo nodo) {
		Estado estAtual = nodo.getEstado();
		Estado estFuturo;
		List<Nodo> resultado = new ArrayList<Nodo>();
		int ladoRio = estAtual.getBarcosAEsquerda();
		int canEsquerda = estAtual.getnCanibaisEsquerda();
		int expEsquerda = estAtual.getnExploradoresEsquerda();
		if(canEsquerda>1&&ladoRio==LADO_ESQUERDO&&estAtual.getChefeNaEsquerda()==1||canEsquerda<2&&ladoRio==LADO_DIREITO&&estAtual.getChefeNaEsquerda()==0){
			estFuturo = new Estado(operaCan(estAtual,2), expEsquerda,  trocaLado(ladoRio), ladoRio==LADO_ESQUERDO?0:1);
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_2_CANIBAIS, estFuturo));
		}
		if(expEsquerda>1&&ladoRio==1||expEsquerda<2&&ladoRio==0){
			estFuturo = new Estado(canEsquerda, operaExp(estAtual, 2),  trocaLado(ladoRio), estAtual.getChefeNaEsquerda());
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_2_EXPLORADORES, estFuturo));
		}
		if(expEsquerda>0&&canEsquerda>0&&ladoRio==LADO_ESQUERDO||expEsquerda<2&&canEsquerda<2&&ladoRio==LADO_DIREITO){
			estFuturo = new Estado(operaCan(estAtual, 1),operaExp(estAtual, 1), trocaLado(ladoRio), estAtual.getChefeNaEsquerda());
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_EXP_E_CAN, estFuturo));
		}
		
		return null;
	}
	private int operaCan(Estado estado,int qt) {
		return estado.getBarcosAEsquerda()==LADO_ESQUERDO?estado.getnCanibaisEsquerda()-qt:estado.getnCanibaisEsquerda()+qt;
	}
	private int operaExp(Estado estado,int qt) {
		return estado.getBarcosAEsquerda()==LADO_ESQUERDO?estado.getnExploradoresEsquerda()-qt:estado.getnExploradoresEsquerda()+qt;
	}
	private int trocaLado(int ladoRio) {
		return ladoRio==LADO_ESQUERDO?LADO_DIREITO:LADO_ESQUERDO;
	}
	public Nodo getAtual() {
		return atual;
	}
	public void setAtual(Nodo atual) {
		this.atual = atual;
	}

}
