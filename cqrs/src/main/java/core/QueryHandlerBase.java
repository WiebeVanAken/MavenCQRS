package com.spotitube.libraries.cqrs.core;

import com.spotitube.libraries.cqrs.api.IQuery;

/**
 * A base queryhandler, denotes that this class can handle IQuery<T> objects.
 * @param <R> The type of data to return.
 * @param <Q> The query to execute (has type T as type parameter)
 */
public abstract class QueryHandlerBase<R, Q extends IQuery<R>> extends CqrsHandlerBase<R, Q> { }