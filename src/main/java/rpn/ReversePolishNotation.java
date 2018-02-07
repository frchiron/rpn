package rpn;

import java.math.BigDecimal;
import java.util.Arrays;

public class ReversePolishNotation {

	private static final String SEPARATOR = " ";
	
	public static BigDecimal compute(String expression) {

		if (expression.isEmpty()) {
			return new BigDecimal("0");
		}

		String[] expressionElements = expression.split(SEPARATOR);

		if (expressionElements.length == 1) {
			return new BigDecimal(expression);
		}

		
		
		String firstOperator = expressionElements[2];
		BigDecimal firstResult = getFirstResult(firstOperator, new BigDecimal(expressionElements[0]),
				new BigDecimal(expressionElements[1]));
		String endOfExpression = expression.substring(expression.indexOf(firstOperator) + 1);
		return compute(firstResult + endOfExpression);
	}

	private static BigDecimal getFirstResult(String firstOperator, BigDecimal firstOperand, BigDecimal secondOperand) {
		System.out.println("firstOperand="+firstOperand+" secondOperand="+secondOperand);
		switch (firstOperator) {
		case "+":
			return firstOperand.add(secondOperand);
		case "-":
			return firstOperand.subtract(secondOperand);
		case "*":
			return firstOperand.multiply(secondOperand);
		case "/":
			return firstOperand.divide(secondOperand);
		default:
			return new BigDecimal("0");
		}
	}
}
