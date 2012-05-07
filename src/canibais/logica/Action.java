package canibais.logica;

public class Action {
	public static final int ACTION_ATRAVESSA_2_CANIBAIS = 1;
	public static final int ACTION_ATRAVESSA_2_EXPLORADORES = 2;
	public static final int ACTION_ATRAVESSA_EXP_E_CAN_DESCE_EXP =3;
	public static final int ACTION_ATRAVESSA_EXP_E_CAN_DESCE_CAN =4;
	public static final int ACTION_DESCE_EXPLORADOR =5;
	public static final int ACTION_DESCE_CANIBAL = 6;
	public static final int ACTION_RETORNA_CANIBAL=7;
	public static final int ACTION_RETORNA_EXPLORADOR=8;
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
