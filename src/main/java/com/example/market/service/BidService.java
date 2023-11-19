package com.example.market.service;

import com.example.market.model.Bid;
import com.example.market.model.IphoneMobile;
import com.example.market.repository.BidRepository;
import com.example.market.repository.IphoneMobileRepository;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BidService {

    @Autowired
    private IphoneMobileRepository iphoneMobileRepository;

    @Autowired
    private BidRepository bidRepository;

    public IphoneMobile getIphoneMobile(int id) {
        return iphoneMobileRepository.findById(id).orElse(null);
    }

    public boolean addNewBid(Bid bid) {
        if (bid != null) {
            updateIphoneMobileBidAmount(bid.getIphoneId(), bid.getBidAmount());
            updateIphoneMobileupdatedAt(bid.getIphoneId(), LocalDateTime.now());
            updateIphoneMobileUpdatedBy(bid.getIphoneId(), "DBA");
            bidRepository.save(bid);
            return true;
        }
        return false;
    }

    private void updateIphoneMobileUpdatedBy(int id, String updatedBy) {
        iphoneMobileRepository.updateUpdatedByByiphoneId(updatedBy, id);
    }

    private void updateIphoneMobileupdatedAt(int id, LocalDateTime now) {
        iphoneMobileRepository.updateUpdatedAtByiphoneId(now, id);
    }

    private void updateIphoneMobileBidAmount(int id, double bidAmount) {
        iphoneMobileRepository.updateMaxBidAmountByiphoneId(bidAmount, id);
    }


    public List<IphoneMobile> getLiveIphoneList() {

        List<IphoneMobile> iphoneList = IterableUtils.toList(iphoneMobileRepository.findByMaxBidAmountGreaterThan(0));
        return iphoneList;

    }

    public boolean sellIphone(int iphoneId) {

        if(iphoneId>0) {
            updateIphoneMobileBidAmount(iphoneId, 0);
            updateIphoneMobileupdatedAt(iphoneId, LocalDateTime.now());
            updateIphoneMobileUpdatedBy(iphoneId, "ADMIN");
            return true;
        }


        return false;
    }
}
