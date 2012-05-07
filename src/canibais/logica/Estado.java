package canibais.logica;

public class Estado {
	private int nCanibaisEsquerda;
	private int nExploradoresEsquerda;
	private int barcosAEsquerda;
	private int chefeNoBarco;
	public Estado(int nCanibaisEsquerda, int nExploradoresEsquerda, int barcosAEsquerda, boolean b) {
		this.nCanibaisEsquerda = nCanibaisEsquerda;
		this.nExploradoresEsquerda = nExploradoresEsquerda;
		this.barcosAEsquerda = barcosAEsquerda;
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
	public int getChefeNoBarco() {
		return chefeNoBarco;
	}
	public void setChefeNoBarco(int chefeNoBarco) {
		this.chefeNoBarco = chefeNoBarco;
	}

}
