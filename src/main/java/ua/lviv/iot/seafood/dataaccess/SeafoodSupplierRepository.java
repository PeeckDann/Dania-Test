package ua.lviv.iot.seafood.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.seafood.model.SeafoodSupplier;

@Repository
public interface SeafoodSupplierRepository extends JpaRepository<SeafoodSupplier, Integer> {

}