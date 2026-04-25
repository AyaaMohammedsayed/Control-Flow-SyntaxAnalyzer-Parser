package visitor;

public class AssignNode extends ASTNode {
    public String id;
    public ExprNode expression; // تغيير النوع من String إلى ExprNode

    public AssignNode(String id, ExprNode expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Assign(" + id + ")";
    }
}