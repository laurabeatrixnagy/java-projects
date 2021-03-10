package PT2020.assign1.Assignment1.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Operations {

	
	public static Polynomial newAdd(Polynomial p1, Polynomial p2) {
		List<Monomial> result = new ArrayList<Monomial>();
		for (Monomial mono1 : p1.getPolynomial()) {
			result.add(mono1);
					
			}
		for(Monomial mono2 : p2.getPolynomial()) {
			result.add(mono2);
		}		
		Polynomial resultPoly = new Polynomial(result);
		return resultPoly;
	}
	
	public static Polynomial newSubtract(Polynomial p1, Polynomial p2) {
		List<Monomial> result = new ArrayList<Monomial>();
		for (Monomial mono1 : p1.getPolynomial()) {
			result.add(mono1);
					
			}
		for(Monomial mono2 : p2.getPolynomial()) {
			result.add(new Monomial(-mono2.getCoeff(), mono2.getPower()));
		}		
		Polynomial resultPoly = new Polynomial(result);
		return resultPoly;
	}
	
	public static Polynomial multiply(Polynomial p1, Polynomial p2) {
		List<Monomial> result = new ArrayList<Monomial>();
		if (p1.getPolynomial().isEmpty() || p2.getPolynomial().isEmpty()) {
			return new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(0, 0))));
		}
		for (Monomial mono1 : p1.getPolynomial()) {
			for(Monomial mono2 : p2.getPolynomial()) {
				result.add(new Monomial(mono1.getCoeff() * mono2.getCoeff(), mono1.getPower() + mono2.getPower()));
			}
		}
		Polynomial res = new Polynomial(result);
		return res;
	}
	
	public static Polynomial quotient(Polynomial p1, Polynomial p2) {
		Polynomial result = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(0, 0))));
		Polynomial poly1 = new Polynomial(p1.getPolynomial());
		
		while(poly1.getDegree() >= p2.getDegree()) {
			int degree = poly1.getDegree() - p2.getDegree();
			double coeff = poly1.getPolynomial().get(0).getCoeff()/p2.getPolynomial().get(0).getCoeff();
			
			Polynomial poly2 = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(coeff, degree))));
			if (!result.getPolynomial().isEmpty()) {
				result = newAdd(result, poly2);
			}
			else result = new Polynomial(poly2.getPolynomial());
			poly2 = multiply(poly2, p2);
			poly1 = newSubtract(poly1, poly2);
			
		}
		return result;
	}
	
	public static Polynomial remainder(Polynomial p1, Polynomial p2) {
		Polynomial result = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(0, 0))));
		Polynomial poly1 = new Polynomial(p1.getPolynomial());
		
		while(poly1.getDegree() >= p2.getDegree()) {
			int degree = poly1.getDegree() - p2.getDegree();
			double coeff = poly1.getPolynomial().get(0).getCoeff()/p2.getPolynomial().get(0).getCoeff();
			
			Polynomial poly2 = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(coeff, degree))));
			if (!result.getPolynomial().isEmpty()) {
				result = newAdd(result, poly2);
			}
			else result = new Polynomial(poly2.getPolynomial());
			poly2 = multiply(poly2, p2);
			poly1 = newSubtract(poly1, poly2);
			
		}
		return poly1;
	}
	
	public static Polynomial derivative(Polynomial p1) {
		List<Monomial> res = new ArrayList<Monomial>();
		
		for(Monomial mono : p1.getPolynomial()) {
			double coeff = 0; 
			coeff = mono.getCoeff() * mono.getPower();
			if (coeff != 0) {
				res.add(new Monomial(coeff, mono.getPower() - 1));
			}
				
		}
		return new Polynomial(res);
	}
	
	public static Polynomial integrate(Polynomial p1) {
		List<Monomial> res = new ArrayList<Monomial>();
		
		for(Monomial mono : p1.getPolynomial()) {
			double coeff = 0;
			coeff = mono.getCoeff() / (mono.getPower() + 1);
			if (coeff != 0) {
				res.add(new Monomial(coeff, mono.getPower() + 1));
			}
		}
		return new Polynomial(res);
	}
}