package com.spotitube.libraries.cqrs.api;

import com.spotitube.libraries.cqrs.core.CqrsHandlerBase;

/**
 * An interface to denote the implementing type is a CQRS 'message', handleable by a specific CqrsHandler.
 * @param <T> The return type of this message.
 */
public interface IMessage<T>
{
    /**
     * Get the class of the handler that's capable of handling this query.
     * *MUST* be implemented as follows: 'return ExampleQueryHandler.class;'
     * @return The class of the message handler that handles this type of message.
     */
    default Class<? extends CqrsHandlerBase> getHandledBy() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("No handler has been defined for handling this message");
    }
}
