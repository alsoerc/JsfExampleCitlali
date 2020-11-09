package idao;

import java.util.List;

/**
 *
 * @author alsorc
 */
public interface IDao<T, V> {
    public boolean insertRecord(T t);
    public boolean deleteRecord(V v);
    public boolean updateRecord(T t, V v);
    public T readOneRecord(V v);
    public List<T> readRecords();
    
}
