package rules;

import behaviors.IBehavior;
import elements.Message;
import elements.Folder;

import java.util.List;

public abstract class Condition {
    private int prioridad;
    private String name;
    private String operator;
    private String value;
    private Folder destiny;
    private IBehavior action;
    private List<Condition> body;

    public abstract boolean apply(Message message, Condition condition);

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Folder getDestiny() {
        return destiny;
    }

    public void setDestiny(Folder destiny) {
        this.destiny = destiny;
    }

    public IBehavior getAction() {
        return action;
    }

    public void setAction(IBehavior action) {
        this.action = action;
    }

    public List<Condition> getBody() {
        return body;
    }

    public void setBody(List<Condition> body) {
        this.body = body;
    }
}
