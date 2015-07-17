package com.eseetwo.client;

import org.springframework.stereotype.Component;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.eseetwo.credentials.EC2Credentials;

@Component
public class EC2Client extends AmazonEC2Client {

	public AmazonEC2Client getCredentials() {
		EC2Credentials awscreds = new EC2Credentials();
		AmazonEC2Client ec2api = new AmazonEC2Client(awscreds.getCredentials());
		return ec2api;
	}
}