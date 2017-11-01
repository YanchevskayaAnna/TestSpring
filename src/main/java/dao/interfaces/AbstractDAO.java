package dao.interfaces;

import model._IDEntity;
import java.util.List;

public interface AbstractDAO<E extends _IDEntity> {

    public List<E> getAll();

    public E getEntityById(Integer id);

    public boolean update(E entity);

    public boolean create(E entity);

    public boolean delete(E entity);

}
