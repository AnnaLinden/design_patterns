package org.example;

//contact requests can be forwarded to the appropriate department
public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        System.out.println(message + " arrived to ContactRequestHandler");
        if (message.getMessageType() == Message.MessageType.CONTACT_REQUEST){
            System.out.println("Handling Contact Request: " + message.getMessageContent());
            System.out.println("Contact requests is forwarded to the appropriate department");
        } else if (nextHandler != null) {
            System.out.println(message + " is forwarded");
            nextHandler.handleFeedback(message);
        }


    }
}
