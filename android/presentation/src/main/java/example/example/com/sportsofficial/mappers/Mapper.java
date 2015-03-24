package example.example.com.sportsofficial.mappers;

import java.util.Collection;

public interface Mapper<T, F> {
    public T transform(F from);
    public Collection<T> transform(Collection<F> collection);
}
