package com.snapdeal.hack.model.rr;

import java.util.ArrayList;
import java.util.List;

import com.snapdeal.hack.model.Buyer;

public class AddFriendRequest {
	
	private Buyer buyer;
	private List<Buyer> friendList;
	
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public List<Buyer> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<Buyer> friendList) {
		this.friendList = friendList;
	}

	public AddFriendRequest() {
		friendList = new ArrayList<Buyer>();
	}
	
	public void addFriend(Buyer buyer) {
		friendList.add(buyer);
	}

}
