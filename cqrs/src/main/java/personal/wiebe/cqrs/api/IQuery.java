package personal.wiebe.cqrs.api;

/**
 * An interface to denote the implementing type is an ICommand handleable by a CQRS command handler.
 * @param <R> The type of data this query returns
 */
public interface IQuery<R> extends IMessage<R> { }
