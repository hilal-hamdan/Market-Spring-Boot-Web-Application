package com.example.market.repository;

import com.example.market.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid,Integer>{
    Double findMaxBidAmountByIphoneId(Integer iphoneId);
    List<Bid> findByUserId(int userId);

}
