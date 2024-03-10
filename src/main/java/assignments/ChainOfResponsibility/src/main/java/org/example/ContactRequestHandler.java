package org.example;

//contact requests can be forwarded to the appropriate department
public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == Message.MessageType.CONTACT_REQUEST){
            System.out.println("Handling Contact Request: " + message.getMessageContent());
            System.out.println("Contact requests is forwarded to the appropriate department");
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }


    }
}
