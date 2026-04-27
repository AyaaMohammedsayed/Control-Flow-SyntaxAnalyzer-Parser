package error;

import org.antlr.v4.runtime.*;

public class MyErrorListener extends BaseErrorListener {

    public StringBuilder errors = new StringBuilder();

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        String symbol = offendingSymbol != null ? offendingSymbol.toString() : "";
        String problem = improveMessage(msg, symbol);

        errors.append(
                RED + ">> Syntax Error\n" + RESET +
                "   Line: " + line + ":" + charPositionInLine + "\n" +
                "   Problem: " + problem + "\n" +
                "   ^\n\n"
        );
    }

    private String improveMessage(String msg, String symbol) {

        if (msg.contains("extraneous input") && symbol.equals("else")) {
            return "Unexpected 'else' → missing '}' before it";
        }

        if (msg.contains("missing ';'")) {
            return "Missing semicolon ';'";
        }

        if (msg.contains("no viable alternative")) {
            return "Invalid or incomplete statement";
        }

        if (msg.contains("mismatched input")) {
            return "Syntax error in expression or assignment";
        }

        if (msg.contains("token recognition error")) {
            return "Invalid character in source code";
        }

        return msg;
    }
}