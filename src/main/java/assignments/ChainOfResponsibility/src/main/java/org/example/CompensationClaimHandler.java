package org.example;

//compensation claims can be reviewed and approved or rejected
public class CompensationClaimHandler extends FeedbackHandler{
    @Override
    public void handleFeedback(Message message) {
        System.out.println(message + " arrived to CompensationComplainHandler");
        if (message.getMessageType() == Message.MessageType.COMPENSATION_CLAIM){
            System.out.println("Handling compensation claim: " + message.getMessageContent());
        } else if (nextHandler != null) {
            System.out.println(message + " is forwarded");
            nextHandler.handleFeedback(message);
        }
    }
}
