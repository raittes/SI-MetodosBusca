package canibais.logica;

public class Barco {
	
	public static final int MARGEM_ESQUERDA_VAZIO=0;
	public static final int MARGEM_ESQUERDA_DOIS = 1;
	public static final int MARGEM_DIREITA_DOIS = 2;
	public static final int MARGEM_ESQUERDA_UM = 3;
	public static final int MARGEM_DIREITA_UM = 4;
	public static final int MARGEM_DIREITA_ZERO = 5;
	
	private int estado;
	public Barco(int estado){
		this.setEstado(estado);
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
