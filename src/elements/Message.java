/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.util.HashMap;

/**
 *
 * @author
 */
public class Message implements IContainer{
	private String from;
	private String sent;
	private String subject;
	private String cc;
	private String body;

	public Message(String from, String subject, String cc, String body) {
		this.setFrom(from);
		this.setSubject(subject);
		this.setCc(cc);
		this.setBody(body);
	 }
	public void print(){
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("From: "+from);
            System.out.println("CC: "+cc);
            System.out.println("Subject: "+subject);
            System.out.println(body);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }

	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
		this.sent = sent;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
