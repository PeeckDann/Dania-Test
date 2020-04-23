package ua.lviv.iot.seafood.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ua.lviv.iot.seafood.dataaccess.SeafoodSupplierRepository;
import ua.lviv.iot.seafood.model.SeafoodSupplier;

@Service
public class SeafoodSupplierService extends BaseService<SeafoodSupplier>{

    @Autowired
    private SeafoodSupplierRepository seafoodSupplierRepository;

    @Override
    public JpaRepository<SeafoodSupplier, Integer> getRepository() {
        return seafoodSupplierRepository;
    }

    public boolean checkForSeafoodSupplierExistence(Integer supplierId) {
        return seafoodSupplierRepository.existsById(supplierId);
    }
}