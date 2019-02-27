package elements;

import rules.SimpleCondition;
import java.util.List;

public class RuleManager {
    String name;

    public RuleManager(String name){
        this.name = "INSPECTOR: "+name;
    }

    public SimpleCondition evaluar(Message message, List<Folder> folders) throws Exception{
        SimpleCondition res = null;
        for (Folder folder: folders){
            if(folder.getConditions().size() > 0) {
                for (SimpleCondition condition : folder.getConditions()) {
                    if(condition.apply(message, condition)){
                        return condition;
                    }
                }
            }else{
                res = evaluar(message, folder.getFolders());
            }
        }
        throw new Exception("SIN REGLAS");
    }
}
