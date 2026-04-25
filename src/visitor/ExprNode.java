package visitor;

public class ExprNode extends ASTNode {
    public String value;

    public ExprNode(String value) {
        this.value = value;
    }
    @Override
public String toString() {
    return value; 
}


}