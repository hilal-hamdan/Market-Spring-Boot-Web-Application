package com.example.market.service;


import com.example.market.model.Address;
import com.example.market.model.Bid;
import com.example.market.model.User;
import com.example.market.model.UserProfile;
import com.example.market.repository.BidRepository;
import com.example.market.repository.UserRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BidRepository bidRepository;

    public UserProfile getUserProfile(HttpSession session) {

        UserProfile userProfile = new UserProfile();

        User user = (User) session.getAttribute("loggedInUser");

        userProfile.setName(user.getName());
        userProfile.setMobileNumber(user.getMobileNumber());
        userProfile.setEmail(user.getEmail());

        if (user.getAddress() != null && user.getAddress().getAddressId() > 0) {

            userProfile.setAddress1(user.getAddress().getAddress1());
            userProfile.setAddress2(user.getAddress().getAddress2());
            userProfile.setCity(user.getAddress().getCity());
            userProfile.setState(user.getAddress().getState());
            userProfile.setZipCode(user.getAddress().getZipCode());
        }

        return userProfile;
    }

    public void updateUserProfile(UserProfile userProfile, HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        user.setName(userProfile.getName());
        user.setEmail(userProfile.getEmail());
        user.setMobileNumber(userProfile.getMobileNumber());

        if (user.getAddress() == null || !(user.getAddress().getAddressId() > 0))
            user.setAddress(new Address());

        user.getAddress().setAddress1(userProfile.getAddress1());
        user.getAddress().setAddress2(userProfile.getAddress2());
        user.getAddress().setCity(userProfile.getCity());
        user.getAddress().setState(userProfile.getState());
        user.getAddress().setZipCode(userProfile.getZipCode());

        userRepository.save(user);

        session.setAttribute("loggedInUser", user);

    }

    public List<Bid> getUserBidList(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        List<Bid> userBidsList =  IterableUtils.toList(bidRepository.findByUserId(user.getUserId()));
        for(Bid bid : userBidsList) System.out.println(bid.toString());

        return userBidsList;
    }
}
