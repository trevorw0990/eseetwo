package com.eseetwo.service;

import java.util.List;

import com.amazonaws.services.ec2.model.Instance;

public interface EC2Service {

	public List<Instance> getAllInstances();
	
	public List<Instance> getInstanceById(String instanceId);
	
	
}
