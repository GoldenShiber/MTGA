package stats;

public class CombatValue {
	
	private String statName = "";
	private int multiPlier = 0;
	
	public CombatValue() {
		super();
	}
	
	public CombatValue(String statName, int multiplier) {
		this.setStatName(statName);
		this.setMultiPlier(multiplier);
	}

	public String getStatName() {
		return statName;
	}

	public void setStatName(String statName) {
		this.statName = statName;
	}

	public int getMultiPlier() {
		return multiPlier;
	}

	public void setMultiPlier(int multiPlier) {
		this.multiPlier = multiPlier;
	}
	
}
