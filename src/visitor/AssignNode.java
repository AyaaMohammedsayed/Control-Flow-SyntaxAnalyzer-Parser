package visitor;

public class AssignNode extends ASTNode {

    public String id;
    public ExprNode expression;

    public AssignNode(String id, ExprNode expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return id + " = " + expression;
    }
}