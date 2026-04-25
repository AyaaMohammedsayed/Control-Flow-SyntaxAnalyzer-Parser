package visitor;

import java.io.FileWriter;
import java.io.IOException;

public class GraphvizGenerator {
    private int counter = 0;

    public void generate(ASTNode root, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("digraph AST {\n");
            writer.write("  node [shape=box, style=filled, fillcolor=white];\n");
            
            // نبدأ المعالجة
            processNode(root, writer);
            
            writer.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int processNode(ASTNode node, FileWriter writer) throws IOException {
        int currentNodeId = counter++;
        String label = node.getClass().getSimpleName().replace("Node", "");
        
        // رسم النود الأساسية
        writer.write("  node" + currentNodeId + " [label=\"" + label + "\"];\n");

        // التعامل مع كل نوع من الـ Nodes
        if (node instanceof ProgramNode) {
            for (ASTNode child : ((ProgramNode) node).statements) {
                int childId = processNode(child, writer);
                writer.write("  node" + currentNodeId + " -> node" + childId + ";\n");
            }
        } 
        
        else if (node instanceof BlockNode) {
            // الـ Block هنا مجرد حاوية
            for (ASTNode stmt : ((BlockNode) node).statements) {
                int childId = processNode(stmt, writer);
                writer.write("  node" + currentNodeId + " -> node" + childId + ";\n");
            }
        }
        
        else if (node instanceof IfNode) {
            IfNode ifNode = (IfNode) node;
            
            // نود خاصة للـ Condition
            int condId = counter++;
            writer.write("  node" + condId + " [label=\"" + ifNode.condition + "\", shape=ellipse, color=red];\n");
            writer.write("  node" + currentNodeId + " -> node" + condId + " [label=\"Cond\"];\n");
            
            // Then
            int thenId = processNode(ifNode.thenBranch, writer);
            writer.write("  node" + currentNodeId + " -> node" + thenId + " [label=\"Then\"];\n");
            
            // Else
            if (ifNode.elseBranch != null) {
                int elseId = processNode(ifNode.elseBranch, writer);
                writer.write("  node" + currentNodeId + " -> node" + elseId + " [label=\"Else\"];\n");
            }
        }
        
        else if (node instanceof ForNode) {
            ForNode forNode = (ForNode) node;
            
            // Init
            int initId = processNode(forNode.init, writer);
            writer.write("  node" + currentNodeId + " -> node" + initId + " [label=\"Init\"];\n");
            
            // Cond
            int condId = counter++;
            writer.write("  node" + condId + " [label=\"" + forNode.condition + "\", shape=ellipse];\n");
            writer.write("  node" + currentNodeId + " -> node" + condId + " [label=\"Cond\"];\n");
            
            // Update
            int updateId = processNode(forNode.update, writer);
            writer.write("  node" + currentNodeId + " -> node" + updateId + " [label=\"Update\"];\n");
            
            // Body
            int bodyId = processNode(forNode.body, writer);
            writer.write("  node" + currentNodeId + " -> node" + bodyId + " [label=\"Body\"];\n");
        }
        
        else if (node instanceof AssignNode) {
            AssignNode assign = (AssignNode) node;
            
            // نود خاصة للـ ID
            int idNodeId = counter++;
            writer.write("  node" + idNodeId + " [label=\"" + assign.id + "\", shape=note];\n");
            writer.write("  node" + currentNodeId + " -> node" + idNodeId + " [label=\"Target\"];\n");
            
            // نود خاصة للـ Expression
            int exprId = processNode(assign.expression, writer);
            writer.write("  node" + currentNodeId + " -> node" + exprId + " [label=\"Expr\"];\n");
        }
        
        else if (node instanceof ExprNode) {
            // تعديل النود الحالية لتظهر قيمة الـ Expression
            writer.write("  node" + currentNodeId + " [label=\"" + ((ExprNode) node).value + "\", shape=plaintext];\n");
        }

        return currentNodeId;
    }
}