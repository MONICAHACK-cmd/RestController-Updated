package com.hackathon.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailInput {
	private String[] to;
	private String[] cc;
	private String from;
	private String subject;
	private String content;
}
