import java.util.Scanner;

public class MainQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		boolean continueLoop = true;

		//demonstrate all the rational number methods on two rational numbers that the user choose 
		while (continueLoop) {
			try {
				System.out.println("Please enter integer numerator");
				int numerator1 = scanner.nextInt(); 
				System.out.println("Please enter integer denominator");
				int denominator1 = scanner.nextInt();
				Rational rational1 = new Rational(numerator1, denominator1);
				System.out.println("The numerator that you picked is " + rational1.getNumerator() + "\n");
				System.out.println("The denominator that you picked is " + rational1.getDenominator() + "\n");
				System.out.println("the first rational number that you pick is " + rational1.reduce().toString() + "\n");
				System.out.println("Please enter another integer numerator");
				int numerator2 = scanner.nextInt();
				System.out.println("Please enter another integer denominator");
				int denominator2 = scanner.nextInt();
				Rational rational2 = new Rational(numerator2, denominator2);
				System.out.println("The numerator that you picked is " + rational2.getNumerator() + "\n");
				System.out.println("The denominator that you picked is " + rational2.getDenominator() + "\n");
				System.out.println("the second rational number that you pick is " + rational2.reduce().toString() + "\n");
				if(rational1.greaterThan(rational2)) {
					System.out.println("The first rational number: " + rational1.reduce() + " is greater then the second rational number: " + rational2.reduce() + "\n");
				}
				else {
					System.out.println("The second rational number: " + rational2.reduce() + " is greater then the first rational number: " + rational1.reduce() + "\n");
				}
				if(rational1.equals(rational2)) {
					System.out.println("The first rational number: " + rational1.reduce() + "is equal to the second rational number: " + rational2.reduce() + "\n");
				}
				else {
					System.out.println("The first rational number: " + rational1.reduce() + "is not equal to the second rational number: " + rational2.reduce() + "\n");
				}
				System.out.println(rational1 + " + " + rational2 + " = " + rational1.plus(rational2).reduce());
				System.out.println(rational1 + " - " + rational2 + " = " + rational1.minus(rational2).reduce());
				System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2).reduce());
				continueLoop = false;
				try { // in case the user tries to divide in zero
					System.out.println(rational1 + "/" + rational2 + " = " + rational1.divide(rational2).reduce());
				} catch (ArithmeticException arithmeticException) {
					System.out.println("Cant divide in 0");
				}
			} catch (ArithmeticException arithmeticException) { //in case the user choose denominator zero
				System.out.println("The denominator cant be 0, Please try again!");
			} catch (IllegalArgumentException illegalArgumentException) { //in case the user choose negative denominator
				System.out.println("The denominator cant be negative, Please try again!");
			}
		}	
	}
}
