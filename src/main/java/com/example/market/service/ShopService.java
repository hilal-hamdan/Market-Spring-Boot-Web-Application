package com.example.market.service;

import com.example.market.model.IphoneMobile;
import com.example.market.repository.IphoneMobileRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private IphoneMobileRepository iphoneMobileRepository;

    public List<IphoneMobile> getIphonesList(){
        List<IphoneMobile> iphoneList = IterableUtils.toList(iphoneMobileRepository.findAll());
        return iphoneList;

    }
}
