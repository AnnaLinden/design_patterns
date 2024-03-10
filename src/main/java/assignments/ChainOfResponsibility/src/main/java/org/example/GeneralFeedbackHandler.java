package org.example;

//general feedback can be analyzed and responded to.
public class GeneralFeedbackHandler extends FeedbackHandler{
    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType()== Message.MessageType.GENERAL_FEEDBACK) {
            System.out.println("Handling General Feedback message: " + message.getMessageContent());
            System.out.println("General Feedback is analyzes and responded to.");
        }
        else if(nextHandler != null){
            nextHandler.handleFeedback(message);
        }
    }
}
