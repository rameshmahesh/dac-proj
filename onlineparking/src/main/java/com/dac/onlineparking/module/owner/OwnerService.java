package com.dac.onlineparking.module.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
	@Autowired
	private OwnerDAO dao;

	public OwnerAddressInfoVO ownerAddress(int userId) {
		List<OwnerAddressInfoVO> list = dao.ownerAddress(userId);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}

	}// method
	public OwnerWalletVO  ownerWallet(int ownerId) {
		List<OwnerWalletVO> list=dao.ownerWallet(ownerId);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}	
	}

}
