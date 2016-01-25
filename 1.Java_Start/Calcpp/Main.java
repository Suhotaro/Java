
public class Main {
	
	private static boolean isOperator(char ch) {
		return (ch == '+') || (ch == '-') || 
				(ch == '*') || (ch == '*') ||
				(ch == '.');
	}
	
	private static int calculate(String s) {
		String sc = "";
		char c, op = '+';
		int op1 = 0;
		
		s = s + '.';
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			
			if (Character.isDigit(c)) {
				sc += c;
			} else if (isOperator(c)) {
				int op2 = Integer.parseInt(sc);
				
				sc = "";
				
				switch (op) {
				case '+':
					op1 += op2;
					break;
				case '-':
					op1 -= op2;
					break;
				case '*':
					op1 *= op2;
					break;
				case '/':
					op1 /= op2;
					break;	
				}
				
				op = c;
			} else
				System.out.println("Error!");
		}
		
		return op1;
	}

	public static void main(String[] args) {
		System.out.println(calculate("1+5*5-7"));
	}
}
