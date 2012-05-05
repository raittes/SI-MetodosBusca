package canibais.logica;

public class Canibal extends Pessoa {

	private boolean chefe;

	public Canibal(String nome) {
		super(nome);
		
	}

	public Canibal(String nome, boolean isChefe) {
		super(nome);
		this.setChefe(isChefe);
	}

	public boolean isChefe() {
		return chefe;
	}

	public void setChefe(boolean chefe) {
		this.chefe = chefe;
	}

}
