package com.hackathon.service;

public interface SendMailService {
	
	public String sendEmailToUser(String hostUrl , String outputfilePath) throws Exception;

	public String sendEmailToUser(String jsonInput) throws Exception;

}
