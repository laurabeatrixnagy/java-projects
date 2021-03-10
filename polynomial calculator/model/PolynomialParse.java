package PT2020.assign1.Assignment1.model;

import java.util.ArrayList;
import java.util.List;

public class PolynomialParse {

	public static Polynomial parse(String expr) {
		List<Monomial> monoList = new ArrayList<Monomial>();
		
		int pos, index = 0;
		char sign = ' ';
		String[] coeffs = expr.split("x\\^\\d+\\+?");
	    for (String part : coeffs) {
	    	pos = 0;
	    	for (char ch : part.toCharArray()) {
	    		if (ch == '-') {
	    			sign = '-';
	    			break;
	    		}
	    		else sign = '+';
	    	}
	    	
	    	for (char ch : part.toCharArray()) {
	    		if (!Character.isDigit(ch)) {
	    			pos++;
	    		}
	    	}
	    	
	    	coeffs[index++] = sign + part.substring(pos, part.length());
	    }
	    
	    index = 0;
	    String[] powers = new String[100];
	    
	    for (int i = 0; i < expr.length(); i++) {
    		if (expr.charAt(i) == '^') {
    			powers[index++] = String.valueOf(expr.charAt(i + 1));
    		}
    	}
	    if (powers[0] == null) {
	    	powers[0] = "0";
	    }
	    for (int i = index; i < 100; i++) {
	    	powers[i] = "0";
	    }
	    
	    for (int i = 0; i < coeffs.length ; i++) {
	    	double coeff = Double.parseDouble(coeffs[i]);
	    	int pow = Integer.parseInt(powers[i]);
	    	monoList.add(new Monomial(coeff, pow));
	    }
	   
	    Polynomial result = new Polynomial(monoList);
	    return result;
	}

	
}