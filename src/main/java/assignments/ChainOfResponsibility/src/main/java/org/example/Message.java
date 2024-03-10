//Message Class: Create a message class that represents a customer feedback message.
// The message class should include the following attributes: message type,
// message content, and sender email. Create an enumerated type
// (enum) for the message type to represent different forms of feedback.
package org.example;

import java.awt.*;

public class Message {

    public enum MessageType {COMPENSATION_CLAIM, CONTACT_REQUEST, DEVELOPMENT_SUGGESTION, GENERAL_FEEDBACK};
    private MessageType messageType;
    private String messageContent;
    private String senderEmail;

    //constructor
    public Message(MessageType messageType, String messageContext, String senderEmail){
        this.messageType = messageType;
        this.messageContent = messageContext;
        this.senderEmail = senderEmail;
    }

    // Getters
    public MessageType getMessageType(){
        return messageType;
    }

    public String getMessageContent(){
        return messageContent;
    }

    public String getSenderEmail(){
        return senderEmail;
    }

}
