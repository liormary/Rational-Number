
public class Rational {
	private int numerator;
	private int denominator;

	public Rational() {
		this (1,1);
	}
	
	// two argument constructor initializes the rational number numerator and denominator 
	public Rational(int p, int q) throws ArithmeticException, IllegalArgumentException {
		if (q == 0) throw new ArithmeticException(); // throw exception to the main if the denominator is 0 
		else if (q < 0) throw new IllegalArgumentException(); // throw exception to the main if the denominator is negative 
		else {
			this.numerator = p;
			this.denominator = q;
		}
	}

	//multiply two numbers
	private int multi(int a, int b) {
		return a*b;
	}

	//checks in one rational number is greater then the other
	public boolean greaterThan(Rational r) {
		if (multi(numerator, r.denominator) > multi(denominator, r.numerator)) return true;
		else return false;
	}

	//checks if two rational numbers are equals
	public boolean equals(Object other) {
		Rational r = (Rational)other;
		if ((multi(numerator, r.denominator)) == (multi(denominator, r.numerator))) return true;
		else return false;
	}

	//help method to plus and minus
	private Rational plusOrMinus(Rational r, int i) {
		Rational other = new Rational();
		if (i==0) { //one rational number plus another rational number
			other.numerator = ((multi(numerator, r.denominator) + (multi(denominator, r.numerator))));
			other.denominator = multi(denominator, r.denominator);
		}
		else { //one rational number minus another rational number
			other.numerator = ((multi(numerator, r.denominator) - (multi(denominator, r.numerator))));
			other.denominator = multi(denominator, r.denominator);
		}
		return other;
	}

	//one rational number plus another rational number
	public Rational plus(Rational r) {
		Rational other = new Rational();
		other = plusOrMinus(r,0);
		return other;
	}

	//one rational number minus another rational number
	public Rational minus(Rational r) {
		Rational other = new Rational();
		other = plusOrMinus(r,1);
		return other;
	}

	//help method to multiply and divide
	private Rational multiplyOrDivide(Rational r, int i) {
		Rational other = new Rational();
		if (i == 0) { //multiply two rational numbers
			other.numerator = multi(numerator, r.numerator);
			other.denominator = multi(denominator, r.denominator);
		}
		else { //divide two rational numbers
			other.numerator = multi(numerator, r.denominator);
			other.denominator = multi(denominator, r.numerator);
		}
		return other;
	}

	//multiply two rational numbers
	public Rational multiply(Rational r) {
		Rational other = new Rational();
		other = multiplyOrDivide(r,0);
		return other;
	}

	//divide two rational numbers
	public Rational divide(Rational r) throws ArithmeticException {
		if (r.numerator == 0) throw new ArithmeticException(); // in case the user tries to divide in zero
		else {
			Rational other = new Rational();
			other = multiplyOrDivide(r,1);
			if (other.denominator < 0) { //in case the denominator is negative
				other.numerator = -other.numerator;
				other.denominator = Math.abs(other.denominator);
			}
			return other;
		}
	}
	
	//gets the rational number numerator
	public int getNumerator() {
		return this.numerator;
	}

	//gets the rational number denominator
	public int getDenominator() {
		return this.denominator;
	}

	//show the rational number
	public String toString() {
		return (numerator +"/" + denominator);
	}

	//find two numbers greater common divide 
	private int gcd(int x, int y) {
		if (y != 0) return gcd(y, x%y);
		else return x;
	}

	//reduce rational number
	public Rational reduce() {
		int gcd = gcd(Math.abs(numerator), denominator);
		Rational other = new Rational();
		if (gcd == 0) { //if the gcd is 0, the number is already reduced
			other.numerator = numerator;
			other.denominator = denominator;
		}
		else {
		other.numerator = numerator/gcd;
		other.denominator = denominator/gcd;
		}
		return other;
	}
}
