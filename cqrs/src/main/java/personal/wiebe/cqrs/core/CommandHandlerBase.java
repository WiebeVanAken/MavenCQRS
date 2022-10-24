package personal.wiebe.cqrs.core;

import personal.wiebe.cqrs.api.ICommand;

/**
 * A base commandhandler, denotes that this class can handle ICommand objects.
 * @param <C> The command to execute, a command always returns an integer
 */
public abstract class CommandHandlerBase<C extends ICommand> extends CqrsHandlerBase<Integer, C> { }
