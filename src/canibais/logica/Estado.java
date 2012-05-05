package canibais.logica;

public class Estado {
	private int nCanibaisDireita;
	private int nExploradoresDireita;
	private int nCanibaisEsquerda;
	private int nExploradoresEsquerda;
	private int barcosAEsquerda;
	public Estado(int nCanibaisEsquerda, int nExploradoresEsquerda, int barcosAEsquerda) {
		this.nCanibaisEsquerda = nCanibaisEsquerda;
		this.nExploradoresEsquerda = nExploradoresEsquerda;
		this.barcosAEsquerda = barcosAEsquerda;
	}
	public int getnCanibaisDireita() {
		return nCanibaisDireita;
	}
	public void setnCanibaisDireita(int nCanibaisDireita) {
		this.nCanibaisDireita = nCanibaisDireita;
	}
	public int getnExploradoresDireita() {
		return nExploradoresDireita;
	}
	public void setnExploradoresDireita(int nExploradoresDireita) {
		this.nExploradoresDireita = nExploradoresDireita;
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

}
