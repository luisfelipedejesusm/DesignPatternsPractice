package edu.mum.cs.cs525.labs.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite extends Component{

    private List<Component> components = new ArrayList<>();

    public Composite() {
        super(null);
    }

    public List<Component> getComponents() {
        return Collections.unmodifiableList(components);
    }

    public void addToList(Component component){
        components.add(component);
    }

    @Override
    public void accept(Visitor visitor) {
        components.forEach(component -> component.accept(visitor));
    }
}
