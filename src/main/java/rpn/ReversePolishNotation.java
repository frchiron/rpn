package rpn;

public class ReversePolishNotation {

	private static final String SEPARATOR = " ";

	public static long compute(String expression) {

		if (expression.isEmpty()) {
			return 0;
		}

		String[] expressionElements = expression.split(SEPARATOR);

		if (expressionElements.length == 1) {
			return Long.valueOf(expression);
		}

		String firstOperator = expressionElements[2];
		Long firstResult = getFirstResult(firstOperator, Long.valueOf(expressionElements[0]),
				Long.valueOf(expressionElements[1]));
		String endOfExpression = expression.substring(expression.indexOf(firstOperator) + 1);
		return compute(firstResult + endOfExpression);
	}

	private static Long getFirstResult(String firstOperator, Long firstOperand, Long secondOperand) {
		switch (firstOperator) {
		case "+":
			return firstOperand + secondOperand;
		case "-":
			return firstOperand - secondOperand;
		case "*":
			return firstOperand * secondOperand;
		case "/":
			return firstOperand / secondOperand;
		default:
			return 0L;
		}
	}
}
