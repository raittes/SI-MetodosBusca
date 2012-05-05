package canibais.main;

import java.util.ArrayList;
import java.util.List;

import canibais.logica.Canibal;
import canibais.logica.Explorador;
import canibais.logica.Pessoa;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Pessoa> pessoasAEsquerdaDoRio = new ArrayList<Pessoa>();
		List<Pessoa> pessoasADireitaDoRio = new ArrayList<Pessoa>();
		pessoasAEsquerdaDoRio.add(new Explorador("Explorador_1"));
		pessoasAEsquerdaDoRio.add(new Explorador("Explorador_2"));
		pessoasAEsquerdaDoRio.add(new Explorador("Explorador_3"));
		pessoasAEsquerdaDoRio.add(new Canibal("Canibal_1",false));
		pessoasAEsquerdaDoRio.add(new Canibal("Canibal_2",false));
		pessoasAEsquerdaDoRio.add(new Canibal("Chefe_canibais",true));
		while

	}

}
