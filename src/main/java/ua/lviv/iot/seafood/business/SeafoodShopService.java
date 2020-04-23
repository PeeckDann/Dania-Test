package ua.lviv.iot.seafood.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.seafood.dataaccess.SeafoodShopRepository;
import ua.lviv.iot.seafood.model.SeafoodShop;

@Service
public class SeafoodShopService extends BaseService<SeafoodShop>{
    
    @Autowired
    private SeafoodShopRepository seafoodShopRepository;

    @Override
    public JpaRepository<SeafoodShop, Integer> getRepository() {
        return seafoodShopRepository;
    }
    
    public boolean checkForSeafoodShopExistence(Integer shopId) {
        return seafoodShopRepository.existsById(shopId);
    }
}
