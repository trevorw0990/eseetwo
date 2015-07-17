package com.eseetwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.ec2.model.Instance;
import com.eseetwo.service.EC2Service;

@RestController
public class EC2Controller {

	@Autowired
	EC2Service instanceList;

	@RequestMapping("/instances/all")
	public List<Instance> getAllInstances() {
		return instanceList.getAllInstances();
	}

	@RequestMapping("/instances/byId/{id}")
	public List<Instance> getInstanceById(@PathVariable("id") String instanceId) {
		return instanceList.getInstanceById(instanceId);
	}

}
