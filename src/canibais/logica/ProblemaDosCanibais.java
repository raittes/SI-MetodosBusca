package canibais.logica;

import java.util.ArrayList;
import java.util.List;

public class ProblemaDosCanibais {
	private List<Pessoa> canibaisEsquerda;
	private List<Pessoa> canibaisdireita;
	private List<Pessoa> exploradoresEsquerda;
	private List<Pessoa> exploradoresDireita;
	private List<Nodo> resultados;
	private Canibal chefe;
	private Barco barco;
	private Nodo atual;
	public Estado objetivo = new Estado(0, 0, 0,false);
	public ProblemaDosCanibais(){
		setAtual(new Nodo(null,null,new Estado(3,3,1,false),0,0));		
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
		estadotmp = new Estado(2, 2, 0,false);
		actiontmp = new Action(Action.ACTION_ATRAVESSA_EXP_E_CAN_DESCE_CAN);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
		estadotmp = new Estado(2, 2, 0,true);
		actiontmp = new Action(Action.ACTION_ATRAVESSA_EXP_E_CAN_DESCE_CAN);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
		actiontmp = new Action(Action.ACTION_ATRAVESSA_EXP_E_CAN_DESCE_EXP);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
		estadotmp = new Estado(3, 1, 0,true);
		actiontmp = new Action(Action.ACTION_ATRAVESSA_2_CANIBAIS);
		expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));
	}
	private void expande(Nodo nodo) {
		Estado estadotmp;
		Action actiontmp;	
		if(nodo.getEstado().equal(objetivo)){
			
			imprime("chegou ao fim!");
		}else if(nodo.getProfundidade()<30){
			switch(nodo.getAction().getValue()){
			case Action.ACTION_ATRAVESSA_2_CANIBAIS:
				geraPossibilidades1(nodo);
				break;
			case Action.ACTION_ATRAVESSA_2_EXPLORADORES:
				int ladoRio = (nodo.getEstado().getBarcosAEsquerda()-1*)-1;
				int nExploradores = nodo.getEstado().getnExploradoresEsquerda()?;
				
			}
		}
		
	}
	private void geraPossibilidades1(Nodo nodo) {
		Estado estadotmp;
		Action actiontmp;
		if(nodo.getPai().getEstado().getBarcosAEsquerda()==0&&nodo.getPai().getEstado().getnCanibaisEsquerda()<3){
			estadotmp = new Estado(nodo.getPai().getEstado().getnExploradoresEsquerda(),
					nodo.getPai().getEstado().getnCanibaisEsquerda()+1,
					1,true);
			actiontmp = new Action(Action.ACTION_RETORNA_CANIBAL);
			expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));									
		}
		else if(nodo.getPai().getEstado().getnCanibaisEsquerda()>0){
			estadotmp = new Estado(nodo.getPai().getEstado().getnExploradoresEsquerda(),
					nodo.getPai().getEstado().getnCanibaisEsquerda()-1,
					0,true);
			actiontmp = new Action(Action.ACTION_RETORNA_CANIBAL);
			expande(new Nodo(nodo, actiontmp, estadotmp, nodo.getProfundidade()+1, nodo.getCusto()+1));	
		}
	}
	public Nodo getAtual() {
		return atual;
	}
	public void setAtual(Nodo atual) {
		this.atual = atual;
	}

}
