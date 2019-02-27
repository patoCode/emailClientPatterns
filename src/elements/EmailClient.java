package elements;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import behaviors.HardDelete;
import behaviors.IBehavior;
import behaviors.Move;
import behaviors.SoftDelete;
import rules.SimpleCondition;

import java.util.List;


/**
 *
 * @author
 */
public class EmailClient{
    private Folder inbox;
    private Folder sent;
    private Folder trash;
    private Folder root;
    private List<Folder> folders;

    IBehavior hardDelete = new HardDelete();
    IBehavior move = new Move();
    IBehavior  soft = new SoftDelete();

    public EmailClient() {
        // ROOT:  Parent folder, es la raiz de todos los folders
        root = new Folder("root");

        setInbox(root.addFolder("imbox"));
        setSent(root.addFolder("sent"));
        setTrash(root.addFolder("trash"));

        getInbox().addBehavior(move);
        getInbox().addBehavior(soft);

        getSent().addBehavior(move);
        getSent().addBehavior(soft);

        getTrash().addBehavior(move);
        getTrash().addBehavior(hardDelete);
    }
    public void receive(Message message) throws Exception {
        try{
            // Notify observers
            SimpleCondition applyCondition = getRoot().getInspector().evaluar(message, getRoot().getFolders());
            if( applyCondition != null ){
                Folder destiny = getRoot().find(applyCondition.getDestiny().getName());
                destiny.addEmail(message);
            }else{
                getInbox().addEmail(message);
            }
        }catch(Exception e){
            getInbox().addEmail(message);
        }
    }
    public void send(Message message) throws Exception {
        try{
            getSent().addEmail(message);
        }
        catch(Exception e){
            System.out.println("ERROR DE ENVIO!!! se envio el message a Trash");
            getTrash().addEmail(message);
        }
    }
    public Folder addFolder(Folder folder) {
        return root.addFolder(folder.getName());
    }
    public void addFolder(Folder child, Folder parent) {
        try{
            Folder parentFolder = getFolderByName(parent);
            if(parentFolder != null)
                parentFolder.addFolder(child.getName());
        }catch(Exception e){
            System.out.println("Exception  " + e.getMessage());
        }
    }
    public Folder getFolderByName(Folder folder) throws Exception{
        return root.find(folder.getName());
    }
    public void addRule(Folder folder, SimpleCondition condition ) {
        try{
            Folder target = getRoot().find(folder.getName());
            target.addRule(condition);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void print(){
        root.print();
    }
    public Folder getRoot(){
        return root;
    }
    public Folder getInbox() {
        return inbox;
    }
    public void setInbox(Folder inbox) {
        this.inbox = inbox;
    }
    public Folder getSent() {
        return sent;
    }
    public void setSent(Folder sent) {
        this.sent = sent;
    }
    public Folder getTrash() {
        return trash;
    }
    public void setTrash(Folder trash) {
        this.trash = trash;
    }
    public List<Folder> getFolders() {
        return folders;
    }
    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
