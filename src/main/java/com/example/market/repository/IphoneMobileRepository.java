package com.example.market.repository;

import com.example.market.model.IphoneMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Repository
public interface IphoneMobileRepository extends JpaRepository<IphoneMobile,Integer> {

    Double findMaxBidAmountByiphoneId(int id);

    @Modifying
    @Transactional
    @Query("UPDATE IphoneMobile i SET i.maxBidAmount = :maxBidAmount WHERE i.iphoneId = :iphoneId")
    void updateMaxBidAmountByiphoneId(@Param("maxBidAmount") double maxBidAmount, @Param("iphoneId") int id);

    List<IphoneMobile> findByMaxBidAmountGreaterThan(double minBidAmount);

    @Modifying
    @Transactional
    @Query("UPDATE IphoneMobile i SET i.updatedAt = :now WHERE i.iphoneId = :iphoneId")
    void updateUpdatedAtByiphoneId(@Param("now") LocalDateTime now, @Param("iphoneId") int id);

    @Modifying
    @Transactional
    @Query("UPDATE IphoneMobile i SET i.updatedBy = :updatedBy WHERE i.iphoneId = :iphoneId")
    void updateUpdatedByByiphoneId(@Param("updatedBy") String updatedBy, @Param("iphoneId") int id);
}
