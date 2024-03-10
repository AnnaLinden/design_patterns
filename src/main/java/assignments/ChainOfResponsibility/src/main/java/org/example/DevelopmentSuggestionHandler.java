package org.example;

//development suggestions can be logged and prioritized
public class DevelopmentSuggestionHandler extends FeedbackHandler{

    @Override
    public void handleFeedback(Message message) {
        System.out.println(message + " arrived to DevelopmentSuggestionHandler");
        if (message.getMessageType() == Message.MessageType.DEVELOPMENT_SUGGESTION){
            System.out.println("Handling Development Suggestion: " + message.getMessageContent());
            System.out.println("Suggestion is logged and prioritized");
        } else if (nextHandler != null) {
            System.out.println(message + " is forwarded");
            nextHandler.handleFeedback(message);
        }
    }
}
