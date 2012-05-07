package canibais.logica;

public class Barco {
	
	public static final int MARGEM_ESQUERDA_VAZIO=0;
	public static final int MARGEM_ESQUERDA_DOIS = 1;
	public static final int MARGEM_DIREITA_DOIS = 2;
	public static final int MARGEM_ESQUERDA_UM = 3;
	public static final int MARGEM_DIREITA_UM = 4;
	public static final int MARGEM_DIREITA_ZERO = 5;
	
	private int estado;
	private Pessoa a;
	private Pessoa b;
	public Barco(int estado){
		this.setEstado(estado);
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Pessoa getA() {
		return a;
	}
	public void setA(Pessoa a) {
		this.a = a;
	}
	public Pessoa getB() {
		return b;
	}
	public void setB(Pessoa b) {
		this.b = b;
	}
}
