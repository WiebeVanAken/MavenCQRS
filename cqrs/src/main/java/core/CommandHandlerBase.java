package com.spotitube.libraries.cqrs.core;

import com.spotitube.libraries.cqrs.api.ICommand;

/**
 * A base commandhandler, denotes that this class can handle ICommand objects.
 * @param <C> The command to execute, a command always returns an integer
 */
public abstract class CommandHandlerBase<C extends ICommand> extends CqrsHandlerBase<Integer, C> { }
