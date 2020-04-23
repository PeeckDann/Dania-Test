package ua.lviv.iot.seafood.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.seafood.dataaccess.SeafoodRepository;
import ua.lviv.iot.seafood.model.Seafood;

@Service
public class SeafoodService extends BaseService<Seafood> {

    @Autowired
    private SeafoodRepository seafoodRepository;

    @Override
    protected JpaRepository<Seafood, Integer> getRepository() {
        return seafoodRepository;
    }

    public boolean checkForSeafoodExistence(Integer seafoodId) {
        return seafoodRepository.existsById(seafoodId);
    }
}