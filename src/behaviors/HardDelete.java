/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviors;

import elements.IContainer;

/**
 *
 * @author
 */
public class HardDelete implements  IBehavior{

    @Override
    public void apply(IContainer container) {
        System.out.println("Hard delete");
    }
    
}
