package com.spotitube.libraries.cqrs.core;

import com.spotitube.libraries.cqrs.api.IConnectionFactory;
import com.spotitube.libraries.cqrs.api.IMessage;
import jakarta.inject.Inject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * The abstract implementation of a CQRS messagehandler.
 * It's the base for both the command and queryhandler.
 * @param <R> The type of data to return.
 * @param <Q> The message to handle. Accepted types are IQuery<R> and ICommand
 */
public abstract class CqrsHandlerBase<R, Q extends IMessage> {
    /**
     * The connection to use to communicate with the database.
     */
    private IConnectionFactory connectionFactory;

    /**
     * Handle an CQRS message.
     * Abstract to make sure this method gets implemented correctly. The connection gets cleaned up after use.
     * @param connection The connection to use to communicate with the database (gets cleaned up after use)
     * @param message The message to send, must implement either IQuery or ICommand.
     * @return Data of type R.
     * @throws SQLException When an internal SQL error occurs.
     * @throws IOException When the database.properties file cannot be read.
     */
    protected abstract R handle(Connection connection, Q message) throws SQLException, IOException;

    /**
     * Handle an CQRS message.
     * @param message The message to send, must implement either IQuery or ICommand
     * @return Data of type R.
     * @throws SQLException When an internal SQL error occurs.
     * @throws IOException When the database.properties file cannot be read.
     */
    public R handle(Q message) throws SQLException, IOException {
        var connection = connectionFactory.getConnection();
        var result = handle(connection, message);
        connection.close();

        return result;
    }

    @Inject
    public void setConnectionFactory(IConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
}
