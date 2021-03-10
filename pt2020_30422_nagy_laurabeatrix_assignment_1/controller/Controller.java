package PT2020.assign1.Assignment1.controller;

import PT2020.assign1.Assignment1.model.*;
import PT2020.assign1.Assignment1.view.View;;
public class Controller {

	private View view;
	private Polynomial polynom1;
	private Polynomial polynom2;
	
	public Controller(View view) {
		this.view = view;
		this.view.setController(this);
	}
	
	public void setFirstPoly(String poly) {
		polynom1 = PolynomialParse.parse(poly);
	}
	
	public void setSecondPoly(String poly) {
		polynom2 = PolynomialParse.parse(poly);
	}
	
	public void addition() throws MissingInputException{
		checkPolys();
		setFirstPoly(view.getPoly1());
		setSecondPoly(view.getPoly2());
		String result = Operations.newAdd(polynom1, polynom2).toString();
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
	}
	
	public void subtraction() throws MissingInputException{
		checkPolys();
		setFirstPoly(view.getPoly1());
		setSecondPoly(view.getPoly2());
		String result = Operations.newSubtract(polynom1, polynom2).toString();
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
	}
	
	public void multiplication() throws MissingInputException{
		checkPolys();
		setFirstPoly(view.getPoly1());
		setSecondPoly(view.getPoly2());
		String result = Operations.multiply(polynom1, polynom2).toString();
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
	}
	
	public void division() throws MissingInputException{
		checkPolys();
		setFirstPoly(view.getPoly1());
		setSecondPoly(view.getPoly2());
		String result = Operations.quotient(polynom1, polynom2).toString();
		System.out.println(result);
		String remainder = Operations.remainder(polynom1, polynom2).toString();
		System.out.println(remainder);
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
		if (remainder.isEmpty()) remainder = "0";
		view.setRemainderField(remainder);
		
	}
	
	public void derivationFirst() throws MissingInputException{
		noPoly1();
		setFirstPoly(view.getPoly1());
		String result = Operations.derivative(polynom1).toString();
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
	}
	
	public void derivationSecond() throws MissingInputException{
		noPoly2();
		setSecondPoly(view.getPoly2());
		String result = Operations.derivative(polynom2).toString();
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
	}
	
	public void integrationFirst() throws MissingInputException{
		noPoly1();
		setFirstPoly(view.getPoly1());
		String result = Operations.integrate(polynom1).toString();
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
	}
	
	public void integrationSecond() throws MissingInputException{
		noPoly2();
		setSecondPoly(view.getPoly2());
		String result = Operations.integrate(polynom2).toString();
		if (result.isEmpty()) result = "0";
		view.setResultField(result);
	}
	
	public void checkPolys() throws MissingInputException {
		String msg = new String("Polynomials missing");
		if (view.getPoly1().isEmpty() || view.getPoly2().isEmpty()) {
			throw new MissingInputException(msg);
		}
	}
	public void noPoly1() throws MissingInputException {
		String msg = new String("Polynomial 1 missing");
		if (view.getPoly1().isEmpty()) {
			throw new MissingInputException(msg);
		}
	}
	public void noPoly2() throws MissingInputException {
		String msg = new String("Polynomial 2 missing");
		if (view.getPoly2().isEmpty()) {
			throw new MissingInputException(msg);
		}
	}
	
}
