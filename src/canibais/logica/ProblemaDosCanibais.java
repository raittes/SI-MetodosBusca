package canibais.logica;

import java.util.ArrayList;
import java.util.List;

public class ProblemaDosCanibais {
	private static final int LADO_ESQUERDO = 1;
	private static final int LADO_DIREITO = 0;
	private Nodo raiz;
	public Estado objetivo = new Estado(0, 0, 0,0);
	private List<Nodo> sucessos = new ArrayList<Nodo>();
	public ProblemaDosCanibais(){
		setRaiz(new Nodo(null,null,new Estado(3,3,1,1),0,0));		
	}
	public void printBuscaCegaLarguraProfundidadeLimitada() {			
				geraPossibilidadesRaiz(raiz);
				Nodo melhor = null;
				for (Nodo nodo : sucessos) {
					if(melhor == null){
						melhor = nodo;
					}
					else{
						if(nodo.getProfundidade()<melhor.getProfundidade()){
							melhor = nodo;
						}
					}
				}
				imprimeNodo(melhor);
	}
	private void imprimeNodo(Nodo melhor) {
		imprime(melhor.toString());
		if(melhor.getPai()!=null){
			imprimeNodo(melhor.getPai());
		}		
	}
	private void imprime(String string) {
		System.out.println(string);		
	}
	private void geraPossibilidadesRaiz(Nodo nodo) {
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
		if(nodo.getEstado().equal(objetivo)&&nodo.getProfundidade()>10){
			//aqui limita a profundidade minima em que o nó objetivo pode ser encontrado
			sucessos.add(nodo);
		}else if(nodo.getProfundidade()<13){
			//aqui limita a profundidade maxima que a busca em largura irá procurar.
			for (Nodo tempNodo : getPossibilidadesValidas(geraAllPossibilidades(nodo))) {
					expande(tempNodo);																												
			}
		}
		
	}
	private List<Nodo> getPossibilidadesValidas(List<Nodo> geraAllPossibilidades) {
		List<Nodo> resultado = new ArrayList<Nodo>();
		for (Nodo nodo : geraAllPossibilidades) {
			if(respeitaRegras(nodo)){
				resultado.add(nodo);
			}
		}
		return resultado;
	}
	private boolean respeitaRegras(Nodo nodo) {
		Estado est = nodo.getEstado();
		int nCanEsq = est.getnCanibaisEsquerda();
		int nExpEsq = est.getnExploradoresEsquerda();
		if(nCanEsq>nExpEsq && nExpEsq>0){
			return false;
		}else if(3-nCanEsq>3-nExpEsq && 3-nExpEsq>0){
			return false;
		}
		return true;
	}
	private List<Nodo> geraAllPossibilidades(Nodo nodo) {
		Estado estAtual = nodo.getEstado();
		Estado estFuturo;
		List<Nodo> resultado = new ArrayList<Nodo>();
		int ladoRio = estAtual.getBarcosAEsquerda();
		int canEsquerda = estAtual.getnCanibaisEsquerda();
		int expEsquerda = estAtual.getnExploradoresEsquerda();
		int chefeCanEsq = estAtual.getChefeNaEsquerda();
		if(canEsquerda>1&&ladoRio==LADO_ESQUERDO&&chefeCanEsq==1||canEsquerda<2&&ladoRio==LADO_DIREITO&&chefeCanEsq==0){
			estFuturo = new Estado(operaCan(estAtual,2), expEsquerda,  trocaLado(ladoRio), ladoRio==LADO_ESQUERDO?0:1);
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_2_CANIBAIS, estFuturo));
		}
		if(expEsquerda>1&&ladoRio==1||expEsquerda<2&&ladoRio==0){
			estFuturo = new Estado(canEsquerda, operaExp(estAtual, 2),  trocaLado(ladoRio), chefeCanEsq);
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_2_EXPLORADORES, estFuturo));
		}
		if(expEsquerda>0&&canEsquerda>0&&ladoRio==LADO_ESQUERDO||expEsquerda<2&&canEsquerda<2&&ladoRio==LADO_DIREITO){
			estFuturo = new Estado(operaCan(estAtual, 1),operaExp(estAtual, 1), trocaLado(ladoRio), chefeCanEsq);
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_EXP_E_CAN, estFuturo));
			estFuturo = new Estado(operaCan(estAtual, 1),operaExp(estAtual, 1), trocaLado(ladoRio), ladoRio==LADO_ESQUERDO?0:1);
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_EXP_E_CAN, estFuturo));
		}
		if(expEsquerda>0&&ladoRio==LADO_ESQUERDO||expEsquerda<3&&ladoRio==LADO_DIREITO){
			estFuturo = new Estado(canEsquerda,operaExp(estAtual, 1), trocaLado(ladoRio), chefeCanEsq);
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_EXPLORADOR, estFuturo));
		}
		if(canEsquerda>0&&ladoRio==LADO_ESQUERDO&&chefeCanEsq==1||canEsquerda<3&&ladoRio==LADO_DIREITO&&chefeCanEsq==0){
			estFuturo = new Estado(operaCan(estAtual, 1),expEsquerda, trocaLado(ladoRio), ladoRio==LADO_ESQUERDO?0:1);
			resultado.add(new Nodo(nodo, Action.ACTION_ATRAVESSA_CANIBAL, estFuturo));
		}
		return resultado;
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
	public Nodo getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

}
