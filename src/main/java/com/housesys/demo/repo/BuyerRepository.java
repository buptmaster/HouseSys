package com.housesys.demo.repo;

import com.housesys.demo.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {

    List<Buyer> findBuyersByHouseId(Integer houseId);

    @Transactional
    Integer deleteBuyerByIdNumber(String idNumber);
}
