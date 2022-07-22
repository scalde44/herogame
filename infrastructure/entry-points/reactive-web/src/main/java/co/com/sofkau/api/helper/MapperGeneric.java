package co.com.sofkau.api.helper;

import java.util.function.Function;

public interface MapperGeneric<D, M> {

    Function<D, M> mapToModel(String id);

    Function<M, D> mapToDTO();
}
