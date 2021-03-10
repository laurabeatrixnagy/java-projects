package PT2020.assign1.Assignment1.model;

public class Monomial{

	private double coeff;
	private int power;
	
	public Monomial() {
		this.coeff = this.power = 0;
	}
	public Monomial(double coeff, int power) {
		this.coeff = coeff;
		this.power = power;
	}
	
	public Monomial(int coeff) {
		this.coeff = coeff;
	}

	void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	void setPower(int pow) {
		this.power = pow;
	}
	
	double getCoeff() {
		return this.coeff;
	}
	
	int getPower() {
		return this.power;
	}
}
