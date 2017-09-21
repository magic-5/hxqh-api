package com.bjhxqh.common.security;

import com.bjhxqh.mybatis.mapper.SysAccountMapper;
import com.bjhxqh.mybatis.mapper.SysRoleMapper;
import com.bjhxqh.mybatis.model.po.SysAccount;
import com.bjhxqh.mybatis.model.po.SysResource;
import com.bjhxqh.mybatis.model.po.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityUserService implements UserDetailsService {


    @Autowired
    SysAccountMapper accountMapper;
    @Autowired
    SysRoleMapper roleMapper;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysAccount account = new SysAccount();
        account.setAccount(userName);
        account = accountMapper.selectOne(account);
        List<SysRole> roles = roleMapper.findRoleByUserId(account.getAccount());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysRole role : roles) {
            if (role != null && role.getName()!= null) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new User(account.getAccount(), account.getPassword(),grantedAuthorities);
    }
}