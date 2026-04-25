package error;

import org.antlr.v4.runtime.*;

public class MyErrorListener extends BaseErrorListener {
  
    public static final String RED = "\u001B[31m";
    public static final String BOLD = "\u001B[1m";
    public static final String RESET = "\u001B[0m";

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        
        System.err.println(RED + BOLD + ">> [Syntax Error]" + RESET + " at line " + line + ":" + charPositionInLine);
        System.err.println("   Message: " + msg);
        
        System.err.println("   " + " ".repeat(charPositionInLine) + "^");
    }
}