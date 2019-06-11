package decimal.dao;

import java.util.List;

public interface ProjectDAOInterface<T> {
    public void persist(T enity);

    public void update(T enity);

    public T findById(Long id);

    public void delete(T enity);

    public List<T> findByName(String enity);
}
