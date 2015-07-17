package com.eseetwo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.eseetwo.client.EC2Client;
import com.eseetwo.service.EC2Service;

@Service
public class EC2ServiceImpl implements EC2Service {

	@Autowired
	EC2Client client;

	public List<Instance> getAllInstances() {
		List<Instance> instanceList = new ArrayList<Instance>();
		DescribeInstancesResult result = client.describeInstances();
		List<Reservation> reservations = result.getReservations();
		for (Reservation reservation : reservations) {
			List<Instance> instances = reservation.getInstances();
			for (Instance instance : instances) {
				instanceList.add(instance);
			}
		}
		return instanceList;

	}

	public List<Instance> getInstanceById(String instanceId) {
		List<Instance> instanceById = new ArrayList<Instance>();
		DescribeInstancesResult result = client.describeInstances();
		List<Reservation> reservations = result.getReservations();
		for (Reservation reservation : reservations) {
			List<Instance> instances = reservation.getInstances();
			for (Instance instance : instances) {
				if (instance.getInstanceId().matches((instanceId)))
					instanceById.add(instance);
			}
		}
		return instanceById;
	}

}
