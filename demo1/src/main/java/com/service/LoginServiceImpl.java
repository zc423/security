package com.service;

import com.entity.LoginUser;
import com.entity.UserEntity;
import com.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public String login(UserEntity userEntity) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userEntity.getName(), userEntity.getPassword());
        // 此处会调用UserDetailServiceImpl的实现 将结果返回到  Object credentials = authenticate.getCredentials();
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        if (ObjectUtils.isEmpty(authenticate)){
            throw new RuntimeException("认证失败");
        }
        String token = jwtTokenUtil.generateToken(loginUser);
        System.out.println(token);
        System.out.println(jwtTokenUtil.getUserNameFromToken(token));
        return token;
    }
}
