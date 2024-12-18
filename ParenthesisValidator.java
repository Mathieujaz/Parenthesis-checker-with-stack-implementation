public class ParenthesisValidator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter parentheses strings to validate (type 'exit' to quit):");
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user types 'exit'
            }
            boolean isValid = isValidParenthesisString(input);
            System.out.println(input + " - " + (isValid ? "Valid" : "Invalid"));
        }
        
        scanner.close();
    }

    public static boolean isValidParenthesisString(String str) {
        Stack stack = new Stack();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '*') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // More closing than opening
                }
                // Pop if there's a matching opening parenthesis or wildcard
                if (stack.top() == '(' || stack.top() == '*') {
                    stack.pop();
                } else {
                    // There should always be an opening parenthesis or wildcard
                    return false;
                }
            }                                       //the method pops the matching ( )
        }

        // After processing, check if there are unmatched '('
        // We can use remaining '*' to balance remaining '('
        int openCount = 0;
        int wildcardCount = 0;

        while (!stack.isEmpty()) {
            char topElement = stack.pop();
            if (topElement == '(') {                 //counts how unmatched 
                openCount++;
            } else if (topElement == '*') {
                wildcardCount++;
            }
        }

        // Remaining wildcards can match the opening parentheses
        return openCount <= wildcardCount;
    }
}