/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gr4.ticketmanagement.log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author hailo
 */

public interface Loggable{

	default Logger getLogger() {
		return LogManager.getLogger(this.getClass());
	};

	default Logger getLogger(String name) {
		return LogManager.getLogger(name);
	}
}
