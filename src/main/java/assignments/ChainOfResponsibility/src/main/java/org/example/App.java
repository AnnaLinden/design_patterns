package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    private static FeedbackHandler getFeedbackHandlerChain() {
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactRequestHandler = new ContactRequestHandler();
        FeedbackHandler developmentSuggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);
        developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

        return compensationHandler;
    }
    public static void main( String[] args ){
        FeedbackHandler handlerChain = getFeedbackHandlerChain();

        handlerChain.handleFeedback(new Message(Message.MessageType.GENERAL_FEEDBACK, "I love your product!", "customer@example.com"));
        handlerChain.handleFeedback(new Message(Message.MessageType.COMPENSATION_CLAIM, "My product arrived damaged.", "angrycustomer@example.com"));
        handlerChain.handleFeedback(new Message(Message.MessageType.CONTACT_REQUEST, "I need help with my order.", "helpme@example.com"));
    }
}
