package ua.lviv.iot.seafood.business;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T> {

    protected abstract JpaRepository<T, Integer> getRepository();

    public List<T> getAll() {
        List<T> list = getRepository().findAll();
        for (T t : list) {
            System.out.println(t);
        }
        return getRepository().findAll();
    }

    public T getById(int id) {
        if (getRepository().existsById(id)) {
            System.out.println(getRepository().findById(id).get());
            T t = (T) getRepository().findById(id).get();
            return t;
        }
        return null;
    }

    public T add(T t) {
        return getRepository().save(t);
    }

    public void update(T t) {
        getRepository().save(t);
    }

    public boolean deleteById(int id) {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }
}