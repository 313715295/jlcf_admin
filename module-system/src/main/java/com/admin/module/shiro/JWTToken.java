package com.admin.module.shiro;

import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationToken;

import static com.admin.module.shiro.JwtTokenUtil.CLAIM_KEY_USERID;


/**
 * shiro登录用户信息
 */
public class JWTToken  implements AuthenticationToken {

    // 用户id
    private Long userId;

    public JWTToken(Claims claims) {
        this.userId = Long.valueOf(String.valueOf(claims.get(CLAIM_KEY_USERID)));
    }

    public JWTToken(Long userId) {
        this.userId = userId;
    }

    @Override
    public Object getPrincipal() {
        return userId;
    }

    @Override
    public Object getCredentials() {
        return userId;
    }
}
