package visitor;

public class IfNode extends ASTNode {
    public String condition;
    public ASTNode thenBranch; // الجزء اللي بعد الـ IF
    public ASTNode elseBranch; // الجزء اللي بعد الـ ELSE (ممكن يكون null)

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