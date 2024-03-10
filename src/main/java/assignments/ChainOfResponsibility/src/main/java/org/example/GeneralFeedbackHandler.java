package org.example;

//general feedback can be analyzed and responded to.
public class GeneralFeedbackHandler extends FeedbackHandler{
    @Override
    public void handleFeedback(Message message) {
        System.out.println(message + " arrived to GeneralFeedbackHandler");
        if (message.getMessageType()== Message.MessageType.GENERAL_FEEDBACK) {
            System.out.println("Handling General Feedback message: " + message.getMessageContent());
            System.out.println("General Feedback is analyzes and responded to.");
        }
        else if(nextHandler != null){
            System.out.println(message + " is forwarded");
            nextHandler.handleFeedback(message);
        }
    }
}
