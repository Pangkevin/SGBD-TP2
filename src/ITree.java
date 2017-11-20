import java.util.Collection;

public interface ITree<T> {

	T remove(T value);

	boolean add(T value);

	void clear();

	boolean contains(T value);

	boolean validate();

	Collection<T> toCollection();

	int size();

	
	
}
