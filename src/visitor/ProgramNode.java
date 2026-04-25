package visitor;
import java.util.List;

public class ProgramNode extends ASTNode {
    public List<ASTNode> statements;

    public ProgramNode(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "Program(" + statements + ")";
    }
}