package canibais.logica;

import java.util.HashMap;
import java.util.Map;

public class Action {
	public static final int ACTION_ATRAVESSA_2_CANIBAIS = 1;
	public static final int ACTION_ATRAVESSA_2_EXPLORADORES = 2;
	public static final int ACTION_ATRAVESSA_EXP_E_CAN=3;
	public static final int ACTION_ATRAVESSA_CANIBAL=4;
	public static final int ACTION_ATRAVESSA_EXPLORADOR=5;
	private static Map<Integer, String> labels =  new HashMap<Integer, String>();
	
	
	private int value;
	public void configureLabels(){
		labels.put(ACTION_ATRAVESSA_2_CANIBAIS, "ATRAVESSARAM DOIS CANIBAIS");
		labels.put(ACTION_ATRAVESSA_2_EXPLORADORES, "ATRAVESSARAM DOIS EXPLORADORES");
		labels.put(ACTION_ATRAVESSA_EXP_E_CAN, "ATRAVESSARAM UM EXPLORADOR E UM CANIBAL");
		labels.put(ACTION_ATRAVESSA_CANIBAL, "ATRAVESSOU UM CANIBAL");
		labels.put(ACTION_ATRAVESSA_EXPLORADOR, "ATRAVESSOU UM EXPLORADOR");
	}
	public Action(int value){
		this.setValue(value);
		configureLabels();
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString(){
		return labels.get(this.value);
	}
}
