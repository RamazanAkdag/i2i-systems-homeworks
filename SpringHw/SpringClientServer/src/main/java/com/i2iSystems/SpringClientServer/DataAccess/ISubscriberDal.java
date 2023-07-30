package com.i2iSystems.SpringClientServer.DataAccess;

import java.util.List;

import com.i2iSystems.SpringClientServer.Entities.SubscriberEntity;


public interface ISubscriberDal {
	List<SubscriberEntity> getAll();
	void add(SubscriberEntity subscriber);

}
