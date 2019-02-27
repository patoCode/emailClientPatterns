package elements;

import behaviors.IBehavior;
import rules.SimpleCondition;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IContainer{
    private String name;
    private List<Folder> folders;
    private List<IBehavior> behaviors;
    private List<Message> messages;
    private List<SimpleCondition> conditions;
    private RuleManager inspector;

    public Folder(String name) {
        this.setName(name);
        setMessages(new ArrayList<Message>());
        setBehaviors(new ArrayList<IBehavior>());
        setFolders(new ArrayList<Folder>());
        setConditions(new ArrayList<SimpleCondition>());
        setInspector(new RuleManager(name));
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addRule(SimpleCondition condition){
        this.getConditions().add(condition);
    }
    public void addBehavior(IBehavior behavior){
        getBehaviors().add(behavior);
    }
    public Folder addFolder(String name){ 
        Folder folder = new Folder(name);
        getFolders().add(folder);
        return folder;
    }
    public Folder addFolder(String name, String parent) throws Exception{
        Folder parentFolder = this.find(parent);
        if(parentFolder != null)
            return parentFolder.addFolder(name);
        return null;
    }
    public void addEmail(Message message) throws Exception {
        try{
            messages.add(message);
        }catch(Exception e){
            System.out.println("ERROR CONDICION " + e.getMessage());
        }

    }
    public List<Message> getMessages(){
        return messages;
    }
    public void print(){
        System.out.println(this.getName().toUpperCase());
        printRules();
        printMessages();
        for (Folder folder : getFolders()) {
            folder.print();    
        }
    }
    public Folder find(String name) throws Exception{
            for (Folder folder : getFolders()) {
                if(folder.getName().equals(name))
                    return folder;
                else 
                    if(folder.getFolders().size() > 0)
                        return folder.find(name);
            }    
        throw new Exception("No existe el folder!!");
    }
    public void printMessages(){
        System.out.println("Mensajes en folder: "+ getMessages().size()+" ");
        for (Message mail : getMessages()) {
            System.out.println("            ["+mail.getSubject()+"] FROM: "+ mail.getFrom() +" / CC: " +mail.getCc() );
        }
        System.out.println("------------------------------------------------");
    }
    public void printRules(){
        System.out.println(" Tiene [ "+getConditions().size()+" ]  filtros para aplicar");

    }
    /*GETTER SETTER */
    public String getName() {
        return name;
    }
    public List<Folder> getFolders() {
        return folders;
    }
    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
    public List<IBehavior> getBehaviors() {
        return behaviors;
    }
    public void setBehaviors(List<IBehavior> behaviors) {
        this.behaviors = behaviors;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public List<SimpleCondition> getConditions() {
        return conditions;
    }
    public void setConditions(List<SimpleCondition> conditions) {
        this.conditions = conditions;
    }
    public RuleManager getInspector() {
        return inspector;
    }
    public void setInspector(RuleManager inspector) {
        this.inspector = inspector;
    }
}
