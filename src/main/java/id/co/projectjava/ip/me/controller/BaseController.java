package id.co.projectjava.ip.me.controller;

import id.co.projectjava.ip.me.dto.TokenAttribute;
import id.co.projectjava.ip.me.dto.response.ResponseDto;
import id.co.projectjava.ip.me.handler.ResponseStatusCode;
import id.co.projectjava.ip.me.util.KeycloakTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public abstract class BaseController {

    protected TokenAttribute tokenAttribute() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            return KeycloakTokenUtil.attributeByJwt((Jwt) auth.getPrincipal());
        } else {
            return null;
        }
    }

    protected <T>ResponseEntity<ResponseDto<T>> buildResponse(ResponseStatusCode responseStatusCode, T data, String message ) {
        return buildResponse(responseStatusCode, data, "");
    }

    protected <T> ResponseEntity<ResponseDto<T>> buildResponse(T data) {
        var responseStatusCode = ResponseStatusCode.SUCCESS;
        return buildResponse(responseStatusCode, data, "");
    }

    protected  <T> ResponseEntity<ResponseDto<T>> buildResponse(T data, String message) {
        var responseStatusCode = ResponseStatusCode.SUCCESS;
        return buildResponse(responseStatusCode, data, message);
    }
}
