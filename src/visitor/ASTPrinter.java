package visitor;

public class ASTPrinter {

    public static void print(ASTNode node, String indent) {
        if (node == null) return; 

        if (node instanceof ProgramNode) {
            System.out.println(indent + "Program");
            for (ASTNode child : ((ProgramNode) node).statements) {
                print(child, indent + "  ");
            }
        } 
        
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

        else if (node instanceof ForNode) {
            ForNode forNode = (ForNode) node;
            System.out.println(indent + "For (Init: " + forNode.init + 
                               "; Cond: " + forNode.condition + 
                               "; Update: " + forNode.update + ")");
            print(forNode.body, indent + "  ");
        }

        else if (node instanceof BlockNode) {
            BlockNode block = (BlockNode) node;
            System.out.println(indent + "Block {");
            for (ASTNode stmt : block.statements) {
                print(stmt, indent + "  ");
            }
            System.out.println(indent + "}");
        }

        else if (node instanceof AssignNode) {
            AssignNode assign = (AssignNode) node;
            System.out.println(indent + "Assign: " + assign.id + " = " + assign.expression);
        }
    }
}