package com.github.tiagomac.authentication;

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
    public boolean checkUserRole(String rollen) {
        if (rollen == null)
            return false;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        for (String s : rollen.trim().split(",")) {
        	//Wenn die Rollen aus JBoss kommen, werden sie mit Praefix 'ROLE_' bezeichnet.
            if (authentication != null && authentication.getAuthorities().stream().anyMatch(p -> p.getAuthority().equals(s) || p.getAuthority().equals("ROLE_"+s))) {
                return true;
            }
        }

        return false;
    }


}
