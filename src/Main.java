import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.*;
import visitor.*;
import error.*;
import java.io.File;
import java.io.IOException;
import utils.*;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equals("-test")) {
            System.out.println(" Running in TEST MODE...");
            System.out.println("=== RUNNING VALID TESTS ===");
            Utils.runTests("test/valid");
            System.out.println("\n=== RUNNING INVALID TESTS ===");
             Utils.runTests("test/invalid");
        } 
        else {
            System.out.println(" Running in DEVELOPMENT MODE...");
             Utils.processFile("src/input.txt");
        }
    }


}