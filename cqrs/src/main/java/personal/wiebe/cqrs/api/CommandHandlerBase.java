package personal.wiebe.cqrs.api;

import personal.wiebe.cqrs.api.ICommand;
import personal.wiebe.cqrs.core.CqrsHandlerBase;

/**
 * A base commandhandler, denotes that this class can handle ICommand objects.
 * @param <C> The command to execute, a command always returns an integer
 */
public abstract class CommandHandlerBase<C extends ICommand> extends CqrsHandlerBase<Integer, C> { }
