package PT2020.assign1.Assignment1.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Polynomial {

	private List<Monomial> polynomial = new ArrayList<Monomial>();

	public Polynomial() {
		this.polynomial = null;
	}

	public Polynomial(List<Monomial> monoms) {
		this.polynomial = buildPolynomial(monoms);
	}

	public List<Monomial> buildPolynomial(List<Monomial> monoList) {
		List<Monomial> newPoly = new ArrayList<Monomial>();

		newPoly = Polynomial.normalize(monoList);
		Collections.sort(newPoly, new Comparator<Monomial>() {
			//@Override
			public int compare(Monomial m1, Monomial m2) {
				return m2.getPower() - m1.getPower();
			}
		});
		return newPoly;
	}

	public static List<Monomial> normalize(List<Monomial> monoList) {
		List<Monomial> newPoly = new ArrayList<Monomial>();
		List<Integer> powers = new ArrayList<Integer>();
		for (Monomial mono : monoList) {
			powers.add(mono.getPower());
		}
		int occurences = 0;
		double coeff = 0;

		for (Monomial mono : monoList) {
			coeff = 0;
			occurences = Collections.frequency(powers, mono.getPower());
			if (occurences > 1) {
				for (Monomial mono1 : monoList) {
					if (!mono.equals(mono1) && mono.getPower() == mono1.getPower()) {
						coeff = mono.getCoeff() + mono1.getCoeff();
					}
				}
				powers.removeAll(Collections.singleton((Integer) mono.getPower()));
				if (coeff != 0)
					newPoly.add(new Monomial(coeff, mono.getPower()));
			} else if (occurences == 1 && mono.getCoeff() != 0)
				newPoly.add(mono);
		}
		return newPoly;
	}

	public List<Monomial> getPolynomial() {
		return this.polynomial;
	}

	public int getDegree() {
		if (!this.getPolynomial().isEmpty()) {
			return this.polynomial.get(0).getPower();
		} else
			return 0;
	}

	public String toString() {
		String polynomial = new String("");
		if (this.polynomial.isEmpty()) {
			return "0";
		}
		for (Monomial m : this.polynomial) {
			if (m.getPower() > 1) {
				if (m.getCoeff() > 0) {
					if (m.equals(this.polynomial.get(0))) {
						polynomial += " " + m.getCoeff() + "x^" + m.getPower() + " ";
					} else
						polynomial += "+ " + m.getCoeff() + "x^" + m.getPower() + " ";
				} else
					polynomial += "- " + (-m.getCoeff()) + "x^" + m.getPower() + " ";
			} else if (m.getPower() == 0) {
				if (m.getCoeff() > 0) {
					polynomial += "+ " + m.getCoeff();
				} else
					polynomial += "- " + (-m.getCoeff());
			} else if (m.getCoeff() > 0) {
				polynomial += "+ " + m.getCoeff() + "x^1" + " ";
			} else
				polynomial += "- " + (-m.getCoeff()) + "x^1" + " ";
		}
		return polynomial;
	}

}