package com.dac.onlineparking.util;

public class OwnerQuery {
	public static final String OWNER_PROFILE_ADDRESS = "select o.id,o.houseNumber,o.age,o.districtName,o.talukaName,o.villageName,o.caste,o.category,o.parkingAreaId from ownerinfo o where userId=?";

	public static final String Owner_Wallet = "select id,amount, from ownerwolet where ownerId=?";
}
