package  visitor;

import java.util.List;

public class BlockNode extends ASTNode {
    public List<ASTNode> statements;

    public BlockNode(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "Block";
    }
}