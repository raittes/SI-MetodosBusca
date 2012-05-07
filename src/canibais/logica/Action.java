package canibais.logica;

public class Action {
	public static final int ACTION_ATRAVESSA_2_CANIBAIS = 1;
	public static final int ACTION_ATRAVESSA_2_EXPLORADORES = 2;
	public static final int ACTION_ATRAVESSA_EXP_E_CAN=3;
	public static final int ACTION_ATRAVESSA_CANIBAL=7;
	public static final int ACTION_ATRAVESSA_EXPLORADOR=8;
	private int value;
	public Action(int value){
		this.setValue(value);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
