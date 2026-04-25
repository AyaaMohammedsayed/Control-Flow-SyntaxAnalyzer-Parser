import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.*;
import visitor.*;
import error.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // لو المستخدم كتب "java Main -test" هيدخل في وضع الاختبار
        if (args.length > 0 && args[0].equals("-test")) {
            System.out.println("🚀 Running in TEST MODE...");
            System.out.println("=== RUNNING VALID TESTS ===");
            runTests("test/valid");
            System.out.println("\n=== RUNNING INVALID TESTS ===");
            runTests("test/invalid");
        } 
        // الوضع الافتراضي (تطوير)
        else {
            System.out.println("🛠 Running in DEVELOPMENT MODE...");
            processFile("src/input.txt");
        }
    }

    // دالة بتمسك الفولدر وتلف على كل الملفات اللي فيه
    public static void runTests(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        processFile(file.getPath());
                    } catch (Exception e) {
                        System.err.println("Error processing " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
        }
    }

    // الدالة الأساسية لمعالجة أي ملف
public static void processFile(String filePath) throws IOException {
    System.out.println("\n========================================");
    System.out.println("Processing file: " + filePath);
    System.out.println("========================================");

    // 1. تحضير فولدر الـ graphs
    File outputDir = new File("output_graphs");
    if (!outputDir.exists()) {
        outputDir.mkdir();
    }

    File inputFile = new File(filePath);
    String outputFileName = "output_graphs/" + inputFile.getName().replace(".txt", ".dot");

    // 2. تشغيل الـ Lexer والـ Parser
    CharStream input = CharStreams.fromFileName(filePath);
    ControlFlowLexer lexer = new ControlFlowLexer(input);
    lexer.removeErrorListeners();
    lexer.addErrorListener(new MyErrorListener());

    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ControlFlowParser parser = new ControlFlowParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(new MyErrorListener());

    ParseTree tree = parser.program();
    ASTBuilder builder = new ASTBuilder();
    ASTNode ast = builder.visit(tree);

    // 3. طباعة النتيجة (الـ Console) وحفظ الـ Graphviz
    if (ast != null) {
        System.out.println("✅ Status: Success");
        
        // هنا رجعنا الـ ASTPrinter عشان يطبع الشجرة في الكونسول
        System.out.println("🌳 AST Structure:");
        ASTPrinter.print(ast, "");
        
        // وهنا شغل الـ Graphviz
        GraphvizGenerator generator = new GraphvizGenerator();
        generator.generate(ast, outputFileName);
        
        System.out.println("💾 Graph saved to: " + outputFileName);
    } else {
        System.err.println("❌ Status: Failed (Check errors above)");
    }
}
}