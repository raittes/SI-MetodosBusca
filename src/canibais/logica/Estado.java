package canibais.logica;

public class Estado {
	private int nCanibaisEsquerda;
	private int nExploradoresEsquerda;
	private int barcosAEsquerda;
	private int chefeNaEsquerda;
	public Estado(int nCanibaisEsquerda, int nExploradoresEsquerda, int barcosAEsquerda, int chefeNaEsquerda) {
		this.nCanibaisEsquerda = nCanibaisEsquerda;
		this.nExploradoresEsquerda = nExploradoresEsquerda;
		this.barcosAEsquerda = barcosAEsquerda;
		this.chefeNaEsquerda = chefeNaEsquerda;
	}
	public int getnExploradoresEsquerda() {
		return nExploradoresEsquerda;
	}
	public void setnExploradoresEsquerda(int nExploradoresEsquerda) {
		this.nExploradoresEsquerda = nExploradoresEsquerda;
	}
	public int getnCanibaisEsquerda() {
		return nCanibaisEsquerda;
	}
	public void setnCanibaisEsquerda(int nCanibaisEsquerda) {
		this.nCanibaisEsquerda = nCanibaisEsquerda;
	}
	public int getBarcosAEsquerda() {
		return barcosAEsquerda;
	}
	public void setBarcosAEsquerda(int barcosAEsquerda) {
		this.barcosAEsquerda = barcosAEsquerda;
	}
	public boolean equal(Estado objetivo) {
		if(this.nCanibaisEsquerda==objetivo.getnCanibaisEsquerda()
				&& this.nExploradoresEsquerda == objetivo.getnExploradoresEsquerda()
				&& this.barcosAEsquerda == objetivo.getBarcosAEsquerda()){
			return true;
		}
		return false;
	}
	public int getChefeNaEsquerda() {
		return chefeNaEsquerda;
	}
	public void setChefeNaEsquerda(int chefeNaEsquerda) {
		this.chefeNaEsquerda = chefeNaEsquerda;
	}

}
