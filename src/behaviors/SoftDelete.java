package behaviors;

import elements.IContainer;

public class SoftDelete implements IBehavior {
    @Override
    public void apply(IContainer elemento) {
        System.out.println("SOFT DELETE");
    }
}
