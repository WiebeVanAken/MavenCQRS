package personal.wiebe.cqrs.api;

/**
 * An interface to denote the implementing type is an ICommand handleable by a CQRS command handler.
 * A 'command' always returns an Integer value stating how many rows were affected.
 */
public interface ICommand extends IMessage<Integer> { }
