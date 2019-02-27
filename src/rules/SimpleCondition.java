package rules;

import behaviors.IBehavior;
import elements.Message;
import elements.Folder;

import java.util.ArrayList;


public class SimpleCondition  extends Condition{
    public SimpleCondition(int prioridad, String name, String value, String operator, Folder attribute, IBehavior action) {
        this.setPrioridad(prioridad);
        this.setName(name);
        this.setDestiny(attribute);
        this.setAction(action);
        this.setOperator(operator);
        this.setValue(value);
        this.setBody(new ArrayList<Condition>());
    }
    @Override
    public boolean apply(Message message, Condition condition) {
        boolean res = false;
        //TODO logica de operacion, por ahoras solo se implementar el igual y se comparar el campo from y cc
        if(condition.getOperator().equals("cc")){
            if(condition.getValue().equalsIgnoreCase(message.getCc())){
                res = true;
            }
        }else{
            if(condition.getOperator().equals("from")){
                if(condition.getValue().equalsIgnoreCase(message.getFrom())){
                    res = true;
                }
            }
        }
        return res;
    }
}
