package personal.wiebe.cqrs.api;

import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.spi.CDI;
import personal.wiebe.cqrs.core.CommandHandlerBase;
import personal.wiebe.cqrs.core.QueryHandlerBase;

import java.io.IOException;
import java.sql.SQLException;

/**
 * An interface to denote the implementing type is a CQRS mediator.
 * @see <a href="https://martinfowler.com/bliki/CQRS.html">CQRS by Martin Fowler</a>
 */
@Default
public class CqrsMediator {
    /**
     * Send a command request down the pipeline.
     *
     * @param command the command to send.
     * @return the amount of rows affected
     */
    public int executeCommand(ICommand command) throws SQLException, IOException {
        var handler = (CommandHandlerBase) CDI.current().select(command.getHandledBy()).get();
        return (int) handler.handle(command);
    }

    /**
     * Send a query request down the pipeline
     *
     * @param query the query request to send.
     * @param <T> the type of data to return
     * @return Data of type T
     */
    public <T> T executeQuery(IQuery<T> query) throws SQLException, IOException {
        var handler = (QueryHandlerBase) CDI.current().select(query.getHandledBy()).get();
        return (T) handler.handle(query);
    }
}
