package com.cg.EAuction.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 *@author Aditya
 * Description : Audit Trail Implementation
 */
public class AuditorAwareImpl implements AuditorAware<String> {


	/**
	 * @author Aditya
	 * @return Auditor Name
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 
		/*
		 * if (authentication == null || !authentication.isAuthenticated()) { return
		 * null; }
		 */
 
        return getCurrentAuditor();
		
	}

}
