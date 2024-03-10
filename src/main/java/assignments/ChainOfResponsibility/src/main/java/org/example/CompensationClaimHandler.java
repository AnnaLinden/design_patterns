package org.example;

//compensation claims can be reviewed and approved or rejected
public class CompensationClaimHandler extends FeedbackHandler{
    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == Message.MessageType.COMPENSATION_CLAIM){
            System.out.println("Handling compensation claim: " + message.getMessageContent());
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
