package edu.mum.cs.cs525.labs.visitor;

public class Leaf extends Component{

    public Leaf(Double value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
