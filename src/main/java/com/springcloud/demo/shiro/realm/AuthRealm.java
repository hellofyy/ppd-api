package com.springcloud.demo.shiro.realm;

import com.springcloud.demo.shiro.dao.UserDAO;
import com.springcloud.demo.shiro.entity.Module;
import com.springcloud.demo.shiro.entity.Role;
import com.springcloud.demo.shiro.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class AuthRealm extends AuthorizingRealm {


    @Resource
    private UserDAO userDAO;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        User user = userDAO.queryUserByName(username);
        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //获取session中的用户
        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissions=new ArrayList<>();
        Set<Role> roles = user.getRoles();
        List<String> rolesStr = new ArrayList<>();
        if(roles.size()>0) {
            for(Role role : roles) {
                rolesStr.add(role.getRname());
                Set<Module> modules = role.getModules();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //将权限放入shiro中.
        info.addStringPermissions(permissions);
        info.addRoles(rolesStr);
        return info;
    }


}
