package visitor;

public class ASTPrinter {

    public static void print(ASTNode node, String indent) {
        if (node == null) return; // حماية من أي null pointers

        // 1. Program Node (جذر الشجرة)
        if (node instanceof ProgramNode) {
            System.out.println(indent + "Program");
            for (ASTNode child : ((ProgramNode) node).statements) {
                print(child, indent + "  ");
            }
        } 
        
        // 2. If Node
        else if (node instanceof IfNode) {
            IfNode ifNode = (IfNode) node;
            System.out.println(indent + "If (Condition: " + ifNode.condition + ")");
            
            System.out.println(indent + "  Then:");
            print(ifNode.thenBranch, indent + "    ");
            
            if (ifNode.elseBranch != null) {
                System.out.println(indent + "  Else:");
                print(ifNode.elseBranch, indent + "    ");
            }
        }

        // 3. For Node (تأكدي أن الحقول مطابقة لـ ForNode.java لديكِ)
        else if (node instanceof ForNode) {
            ForNode forNode = (ForNode) node;
            System.out.println(indent + "For (Init: " + forNode.init + 
                               "; Cond: " + forNode.condition + 
                               "; Update: " + forNode.update + ")");
            print(forNode.body, indent + "  ");
        }

        // 4. Block Node (Scope)
        else if (node instanceof BlockNode) {
            BlockNode block = (BlockNode) node;
            System.out.println(indent + "Block {");
            for (ASTNode stmt : block.statements) {
                print(stmt, indent + "  ");
            }
            System.out.println(indent + "}");
        }

        // 5. Assignment Node
        else if (node instanceof AssignNode) {
            AssignNode assign = (AssignNode) node;
            System.out.println(indent + "Assign: " + assign.id + " = " + assign.expression);
        }
    }
}