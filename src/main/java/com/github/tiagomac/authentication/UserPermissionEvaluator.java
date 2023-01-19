package com.github.tiagomac.authentication;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionEvaluator {

    /**
     * Prueft ob der Benutzer eine von den eingetragenen Rollen im Versicherungsobjekt hat. Das Versicherungsobjekt kann mehrere Rollen, die durch
     * Kommata getrennt sind, enthalten, z.B. migpool,vip
     * 
     * @param rollen
     * @return 'true' wenn der Benutzer eine von den eingetragenen Rollen im Versicherungsobjekt hat ansonsten 'false'
     */
	
	@Autowired
	private HttpServletRequest request;
	
    public boolean checkUserRole(String rollen) {
        if (rollen == null)
            return false;

        Boolean isUseInRole=request.isUserInRole(rollen);
        
        if(true)
        	throw new RuntimeException("request name......."+ request.getUserPrincipal() + " isUseInRole is:"+isUseInRole);
        
        return false;
    }

}
