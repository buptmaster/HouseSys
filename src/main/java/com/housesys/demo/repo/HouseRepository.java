package com.housesys.demo.repo;

import com.housesys.demo.model.House;
import com.housesys.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House,Integer> {
    House findHouseById(Integer houseId);

    List<House> findHousesByUser(User user);

    @Transactional
    Integer deleteHouseById(Integer id);
}
