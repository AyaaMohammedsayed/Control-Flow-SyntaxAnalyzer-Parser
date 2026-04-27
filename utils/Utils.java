package utils;

import org.antlr.v4.runtime.*;
import parser.*;
import visitor.*;
import error.*;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void runTests(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        processFile(file.getPath());
                    } catch (Exception e) {
                        System.err.println("Error processing " +
                                file.getName() + ": " + e.getMessage());
                    }
                }
            }
        }
    }

    public static void processFile(String filePath) throws IOException {

        System.out.println("\n========================================");
        System.out.println("Processing file: " + filePath);
        System.out.println("========================================");

        File outDir = new File("output_graphs");
        if (!outDir.exists()) outDir.mkdir();

        String outputPath = "output_graphs/" +
                new File(filePath).getName().replace(".txt", ".dot");

   
        CharStream input = CharStreams.fromFileName(filePath);
        ControlFlowLexer lexer = new ControlFlowLexer(input);

        MyErrorListener errorListener = new MyErrorListener();
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

     
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ControlFlowParser parser = new ControlFlowParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        ControlFlowParser.ProgramContext tree = parser.program();

   
     if (errorListener.errors.length() > 0) {
    System.err.println(errorListener.errors.toString());
    System.err.println("Status: Failed  (Syntax Errors detected)");
    return;
}

        ASTBuilder builder = new ASTBuilder();
        ASTNode ast = builder.visit(tree);

        if (ast != null) {
            System.out.println(GREEN + "Syntax Success " + RESET);
            System.out.println("AST Structure:");

            ASTPrinter.print(ast, "");

            GraphvizGenerator graph = new GraphvizGenerator();
            graph.generate(ast, outputPath);

            System.out.println("Graph saved to: " + outputPath);

        } else {
            System.err.println("Status: Failed (AST is null)");
        }
    }
}