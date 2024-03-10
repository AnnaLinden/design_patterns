package org.example;

//development suggestions can be logged and prioritized
public class DevelopmentSuggestionHandler extends FeedbackHandler{

    @Override
    public void handleFeedback(Message message) {
        if (message.getMessageType() == Message.MessageType.DEVELOPMENT_SUGGESTION){
            System.out.println("Handling Development Suggestion: " + message.getMessageContent());
            System.out.println("Suggestion is logged and prioritized");
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
