package visitor;

public class IfNode extends ASTNode {
    public String condition;
    public ASTNode thenBranch;
    public ASTNode elseBranch; 

    public IfNode(String condition, ASTNode thenBranch, ASTNode elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public String toString() {
        return "IF(" + condition + ", THEN=" + thenBranch + ", ELSE=" + elseBranch + ")";
    }
}