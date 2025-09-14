package id.co.projectjava.ip.me.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenAttribute {
    private String sub;
    private String sid;
    private String name;
    private String givenName;
    private String familyName;
    private String email;
    private String username;
    private List<Access> resourceAccess;
    private Access realmAccess;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Access{
        private String name;
        private List<String> roles;
    }
}
