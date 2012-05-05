package canibais.logica;

import java.util.ArrayList;
import java.util.List;

public class ProblemaDosCanibais {
	private List<Pessoa> pessoasAEsquerdaDoRio;
	private List<Pessoa> pessoasADireitaDoRio;
	private Barco barco;
	private Nodo Raiz;
	public ProblemaDosCanibais(){
		this.pessoasAEsquerdaDoRio = new ArrayList<Pessoa>();
		this.pessoasADireitaDoRio = new ArrayList<Pessoa>();
		
		pessoasAEsquerdaDoRio.add(new Explorador("Explorador_1"));
		pessoasAEsquerdaDoRio.add(new Explorador("Explorador_2"));
		pessoasAEsquerdaDoRio.add(new Explorador("Explorador_3"));
		pessoasAEsquerdaDoRio.add(new Canibal("Canibal_1",false));
		pessoasAEsquerdaDoRio.add(new Canibal("Canibal_2",false));
		pessoasAEsquerdaDoRio.add(new Canibal("Chefe_canibais",true));
		raiz = new Nodo(null,null,new Estado(3,3,1),0,0);
		
	}

}
