package github.mariapas235.model.dao;

import java.io.Closeable;
import java.util.List;


public interface DAO<T,K,I> extends Closeable{
        T insert (T entity);

        T update (T entity);
        T delete (T entity);

        T findById (I key);



        List<T> findAll();

    }

