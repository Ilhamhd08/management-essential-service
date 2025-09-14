package id.co.projectjava.ip.me.util;


import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import id.co.projectjava.ip.me.dto.TokenAttribute;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeycloakTokenUtil {
    public static TokenAttribute attributeByJwt(Jwt jwt){
        var token = TokenAttribute.builder()
                .sub(jwt.getSubject())
                .sid(jwt.getClaimAsString("sid"))
                .name(jwt.getClaimAsString("name"))
                .givenName(jwt.getClaimAsString("given_name"))
                .familyName(jwt.getClaimAsString("family_name"))
                .email(jwt.getClaimAsString("email"))
                .username(jwt.getClaimAsString("preferred_username"))
                .build();

        var realmAccesses = TokenAttribute.Access.builder()
                .name("realm_access")
                .roles(new ArrayList<>())
                .build();
        var realmAccessMap = jwt.getClaimAsMap("realm_access");
        if(realmAccessMap.containsKey("roles")) {
            realmAccesses.setRoles((List<String>)  realmAccessMap.get("roles"));
        }
        token.setRealmAccess(realmAccesses);

        var resourceAccesses = (HashMap<String, Object>) jwt.getClaimAsMap("resource_access");
        if (!resourceAccesses.isEmpty()) {
            resourceAccesses.forEach((s, o) -> {
                token.getResourceAccess()
                        .add(TokenAttribute.Access.builder()
                                .name(s)
                                .roles((List<String>) ((LinkedTreeMap<String, Object>) o).get("roles"))
                                .build());
            });
        }
        return token;
    }
}
