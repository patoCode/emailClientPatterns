
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import behaviors.IBehavior;
import behaviors.Move;
import elements.Message;
import elements.EmailClient;
import elements.Folder;
import rules.SimpleCondition;

/**
 *
 * @author
 */
public class TestClient {
    
    public static void main(String[] args) throws Exception {

        /* ============================================================= */
        /*  CONFIG  */
        /* ============================================================= */
        String folderPrincipal ="DESTACADOS";
        String folderSocial ="SOCIAL";
        String folderNotifications ="NOTIFICATIONS";
        String folderForos ="FOROS";

        String mailMe = "me@mail.com";
        String mailTest = "test@mail.com";
        String mailAmigo = "amigo@mail.com";
        String mailForo = "foro@mail.com";
        String mailNotification = "notification@mail.com";
        String mailSocial = "social@mail.com";

        String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";
        /* EMAILS */
        Message mail1 = new Message(mailTest,"Feliz dia amigos!!!", mailAmigo, body);
        Message mail2 = new Message(mailMe,"Saludos A todos los del FORO", mailForo, body);
        Message mail3 = new Message(mailMe,"Aviso Importante", mailNotification, body);
        Message mail4 = new Message(mailNotification,"NOTIFICATION!!!", mailSocial, body);
        Message mailSent = new Message(mailMe, "Solciitud de Información", mailForo, body);
        /* ============================================================= */

        Folder main = new Folder (folderPrincipal);
        Folder social = new Folder(folderSocial);
        Folder notifications = new Folder(folderNotifications);
        Folder foros = new Folder(folderForos);

        EmailClient emailClient = new EmailClient();

        emailClient.addFolder(main);
        emailClient.addFolder(social);
        emailClient.addFolder(notifications);
        emailClient.addFolder(foros, social);

        IBehavior moveable = new Move();
        SimpleCondition c1 = new SimpleCondition(1,"Notificaciones", mailNotification,"from" , notifications, moveable);
//        SimpleCondition c2 = new SimpleCondition(2,"Foros", mailForo,"from", foros, moveable);
//        SimpleCondition c3 = new SimpleCondition(3,"Social", mailSocial,"from", social, moveable);
//        SimpleCondition c4 = new SimpleCondition(4,"Social CC", mailSocial,"cc", social, moveable);

        emailClient.addRule(emailClient.getInbox(), c1);
//        emailClient.addRule(emailClient.getInbox(), c2);
//        emailClient.addRule(emailClient.getInbox(), c3);
//        emailClient.addRule(emailClient.getInbox(), c4);

        emailClient.receive(mail1);
        emailClient.receive(mail2);
        emailClient.receive(mail3);
        emailClient.receive(mail4);

        emailClient.print();

        System.out.println(">>>>>>>>>>> ENVIO DE EMAILS <<<<<<<<<<<<<<<<<<<");
        System.out.println("Se enviara el mail:");
        mailSent.print();
        emailClient.send(mailSent);
        emailClient.getSent().print();
        System.out.println("Buscando emails....");


    }
}
