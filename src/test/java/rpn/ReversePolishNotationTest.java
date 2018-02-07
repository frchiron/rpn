package rpn;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ReversePolishNotationTest {

	@Test
	public void should_return_one_given_one_operand() {

		String expression = "1";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void should_return_one_given_one_operand_second_try() {

		String expression = "4";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(4);
	}

	@Test
	public void should_return_addition_given_2_numbers_and_one_plus() {

		String expression = "4 1 +";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(5);
	}

	@Test
	public void should_return_addition_given_2_numbers_and_one_plus_second_try() {

		String expression = "14 1 +";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(15);
	}
	
	@Test
	public void should_return_multiplication_given_2_numbers_and_one_star() {

		String expression = "10 2 *";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(20);
	}
	
	@Test
	public void should_return_substraction_given_2_numbers_and_one_minus() {

		String expression = "10 2 -";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(8);
	}
	
	@Test
	public void should_return_division_given_2_numbers_and_one_slash() {

		String expression = "10 2 /";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(5);
	}
	
	@Test
	public void should_return_result_given_two_operators() {

		String expression = "4 2 + 3 -";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(3);
	}
	
	@Test
	public void should_return_result_given_two_operators_second_try() {

		String expression = "4 2 - 7 +";
		
		long result = ReversePolishNotation.compute(expression);
		
		assertThat(result).isEqualTo(9);
	}
	
	@Test
	public void should_return_0_given_empty_expression() {

		long result = ReversePolishNotation.compute("");
		
		assertThat(result).isEqualTo(0);
	}
}
