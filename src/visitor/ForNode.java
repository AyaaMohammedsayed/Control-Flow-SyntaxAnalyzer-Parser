package visitor;

public class ForNode extends ASTNode {
    public ASTNode init;
    public String condition;
    public ASTNode update;
    public ASTNode body;

    public ForNode(ASTNode init, String condition, ASTNode update, ASTNode body) {
        this.init = init;
        this.condition = condition;
        this.update = update;
        this.body = body;
    }
    @Override
public String toString() {
    return "For(" + condition + ")";
}
}