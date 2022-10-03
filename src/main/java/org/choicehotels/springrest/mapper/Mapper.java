package org.choicehotels.springrest.mapper;

public interface Mapper<S, T> {

    T map(S source);
}
