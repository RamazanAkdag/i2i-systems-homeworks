package com.i2iSystems.SpringClientServer.RestApi;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i2iSystems.SpringClientServer.DataAccess.HibernateSubscriberDal;
import com.i2iSystems.SpringClientServer.DataAccess.ISubscriberDal;
import com.i2iSystems.SpringClientServer.Entities.SubscriberEntity;


@RestController
@RequestMapping("/api")
public class RestApi {
	
	private ISubscriberDal subscriberDal;

	@Autowired
	public RestApi(ISubscriberDal subscriberDal) {
		this.subscriberDal = subscriberDal;
	}
	
	
	@GetMapping("/subscribers")
	public List<SubscriberEntity> getAll(){
		return subscriberDal.getAll();
	}
	
	@PostMapping("/subscribers/add")
	public void add(@RequestBody Map<String, String> SubscriberMap) {
		
		String subsc_name= SubscriberMap.get("SUBSC_NAME");
		String subsc_surname=SubscriberMap.get("SUBSC_SURNAME");
		String msisdn=SubscriberMap.get("MSISDN");
		int tariff_id=Integer.parseInt(SubscriberMap.get("TARIFF_ID"));
		String start_date=SubscriberMap.get("START_DATE");
		
		subscriberDal.add(new SubscriberEntity(subsc_name,subsc_surname,msisdn,tariff_id,start_date));
		
		
	}
	
	
	

}
