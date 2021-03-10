package PT2020.assign1.Assignment1;

import org.junit.Test;
import junit.framework.TestCase;
import PT2020.assign1.Assignment1.model.*;
import java.util.*;

public class OperationsTester extends TestCase{

    @Test
    public void testAddition() {
        List<Monomial> monoList1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly1 = new Polynomial(monoList1);
		List<Monomial> monoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 1),
        		new Monomial(3, 2),
				new Monomial(-1, 5)));
		Polynomial poly2 = new Polynomial(monoList2);
		List<Monomial> expMonoList = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 5),
        		new Monomial(1, 3),
        		new Monomial(1, 2),
        		new Monomial(-1, 1),
				new Monomial(-4, 0)));
		Polynomial expected = new Polynomial(expMonoList);
        assertEquals(expected.toString(), Operations.newAdd(poly1, poly2).toString());

        List<Monomial> monoList3 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly3 = new Polynomial(monoList3);
		List<Monomial> monoList4 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 3),
        		new Monomial(2, 2),
				new Monomial(4, 0)));
		Polynomial poly4 = new Polynomial(monoList4);
		List<Monomial> expMonoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(0, 0)));

		Polynomial expected2 = new Polynomial(expMonoList2);
        assertEquals(expected2.toString(), Operations.newAdd(poly3, poly4).toString());
    }
    
    @Test
    public void testSubtraction() {
        List<Monomial> monoList1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly1 = new Polynomial(monoList1);
		List<Monomial> monoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 1),
        		new Monomial(3, 2),
				new Monomial(-1, 5)));
		Polynomial poly2 = new Polynomial(monoList2);
		List<Monomial> expMonoList = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 5),
        		new Monomial(1, 3),
        		new Monomial(-5, 2),
        		new Monomial(1, 1),
				new Monomial(-4, 0)));
		Polynomial expected = new Polynomial(expMonoList);
        assertEquals(expected.toString(), Operations.newSubtract(poly1, poly2).toString());

        List<Monomial> monoList3 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly3 = new Polynomial(monoList3);
		List<Monomial> monoList4 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 3),
        		new Monomial(2, 2),
				new Monomial(4, 0)));
		Polynomial poly4 = new Polynomial(monoList4);
		List<Monomial> expMonoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(2, 3),
				new Monomial(-4, 2),
				new Monomial(-8, 0)));

		Polynomial expected2 = new Polynomial(expMonoList2);
        assertEquals(expected2.toString(), Operations.newSubtract(poly3, poly4).toString());
    }
    
    @Test
    public void testMultiplicaton() {
    	//multiplication with 0
    	List<Monomial> monoList1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly1 = new Polynomial(monoList1);
		List<Monomial> monoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(0, 0)));
		Polynomial poly2 = new Polynomial(monoList2);

		Polynomial expected = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(0, 0))));
        assertEquals(expected.toString(), Operations.multiply(poly1, poly2).toString());
        
        //(x^3 - 2x^2 -4)*(-x^5 + 1) = -x^8 + 2x^7 + 4x^5 + x^3 -2x^2 - 4
        List<Monomial> monoList3 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly3 = new Polynomial(monoList3);
		List<Monomial> monoList4 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 5),
				new Monomial(1, 0)));
		Polynomial poly4 = new Polynomial(monoList4);
		List<Monomial> expMonoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 8),
        		new Monomial(2, 7),
        		new Monomial(4, 5),
        		new Monomial(1, 3),
				new Monomial(-2, 2),
				new Monomial(-4, 0)));
		Polynomial expected2 = new Polynomial(expMonoList2);
        assertEquals(expected2.toString(), Operations.multiply(poly3, poly4).toString());
    }
    
    @Test
    public void testDivision() {
    	// (x^3 -2x^2 -4)/(x-3) = x^2 + x + 3, r = 5
    	List<Monomial> monoList1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly1 = new Polynomial(monoList1);
		List<Monomial> monoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 1),
				new Monomial(-3, 0)));
		Polynomial poly2 = new Polynomial(monoList2);
		Polynomial expectedQ = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 2),
				new Monomial(1, 1),
				new Monomial(3, 0))));
        assertEquals(expectedQ.toString(), Operations.quotient(poly1, poly2).toString());
        Polynomial expectedR = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(5, 0))));
        assertEquals(expectedR.toString(), Operations.remainder(poly1, poly2).toString());
        
        // (x^3 - 1)/(x - 1) = x^2 + x + 1, r= 0
        List<Monomial> monoList3 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-1, 0)));
		Polynomial poly3 = new Polynomial(monoList3);
		List<Monomial> monoList4 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 1),
				new Monomial(-1, 0)));
		Polynomial poly4 = new Polynomial(monoList4);
		List<Monomial> expMonoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 2),
        		new Monomial(1, 1),
				new Monomial(1, 0)));
		Polynomial expectedQ2 = new Polynomial(expMonoList2);
        assertEquals(expectedQ2.toString(), Operations.quotient(poly3, poly4).toString());
        Polynomial expectedR2 = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(0, 0))));
        assertEquals(expectedR2.toString(), Operations.remainder(poly3, poly4).toString());
    }
    
    @Test
    public void testDerivation() {
    	
    	List<Monomial> monoList1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 3),
        		new Monomial(-2, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly1 = new Polynomial(monoList1);

		Polynomial expected = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(3, 2),
				new Monomial(-4, 1))));
        assertEquals(expected.toString(), Operations.derivative(poly1).toString());
     
		List<Monomial> monoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 5),
				new Monomial(1, 0)));
		Polynomial poly2 = new Polynomial(monoList2);
		List<Monomial> expMonoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-5, 4)));
		Polynomial expected2 = new Polynomial(expMonoList2);
        assertEquals(expected2.toString(), Operations.derivative(poly2).toString());
    }
    
    @Test
    public void testIntegration() {
    	
    	List<Monomial> monoList1 = new ArrayList<Monomial>(Arrays.asList(new Monomial(4, 3),
        		new Monomial(-3, 2),
        		new Monomial(0, 1),
				new Monomial(-4, 0)));
		Polynomial poly1 = new Polynomial(monoList1);

		Polynomial expected = new Polynomial(new ArrayList<Monomial>(Arrays.asList(new Monomial(1, 4),
				new Monomial(-1, 3),
				new Monomial(-4, 1))));
        assertEquals(expected.toString(), Operations.integrate(poly1).toString());
     
		List<Monomial> monoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-6, 5),
				new Monomial(1, 0)));
		Polynomial poly2 = new Polynomial(monoList2);
		List<Monomial> expMonoList2 = new ArrayList<Monomial>(Arrays.asList(new Monomial(-1, 6),
				new Monomial(1, 1)));
		Polynomial expected2 = new Polynomial(expMonoList2);
        assertEquals(expected2.toString(), Operations.integrate(poly2).toString());
    }
}
