package com.spotitube.libraries.cqrs.api;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * A factory that produces an SQL connection to use
 */
public interface IConnectionFactory {
    /**
     * Produce an SQL connection.
     * @return An alive SQL connection.
     * @throws SQLException When the SQL connection could not be established.
     */
    Connection getConnection() throws SQLException;
}
