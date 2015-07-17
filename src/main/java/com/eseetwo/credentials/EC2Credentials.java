package com.eseetwo.credentials;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;

	@Configuration
	@Component
	public class EC2Credentials {

		private String secretKey;
		private String accessKey;

		public AWSCredentials getCredentials() {

			AWSCredentials creds = new AWSCredentials() {
				public String getAWSSecretKey() {
					return secretKey;
				}

				public String getAWSAccessKeyId() {
					return accessKey;
				}
			};
			return creds;

		}
	}

