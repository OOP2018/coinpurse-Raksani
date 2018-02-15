package coinpurse;

public class Money implements Valuable{
	private double value;
	private String currency;
	
	public Money(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue(){
		return value;
	}

	/**
	 * Get the monetary currency of this object.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency(){
		return currency;
	}

	public boolean equals(Money obj) {
		if (this == obj) {
			return true;
		}
		if (this == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Money m = (Money) obj;
		return (this.getCurrency().equals(m.getCurrency())) && (this.getValue() == m.getValue());
	}

	@Override
	public int compareTo(Valuable o) {
		return Double.compare(this.getValue(), o.getValue());
	}

}
