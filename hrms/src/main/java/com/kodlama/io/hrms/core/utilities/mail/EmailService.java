package com.kodlama.io.hrms.core.utilities.mail;

import com.kodlama.io.hrms.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String message);
}
