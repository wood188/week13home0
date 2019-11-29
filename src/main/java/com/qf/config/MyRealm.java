package com.qf.config;

import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.service.PermissionService;
import com.qf.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        //查询该用户的 权限
        List<Permission> permissions = permissionService.selectPer(primaryPrincipal);
      if(permissions!=null&&permissions.size()>0){
          Collection list = new HashSet<>();
          for (Permission per : permissions
          ) {
              list.add(per.getPname());
          }
          SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
          simpleAuthorizationInfo.addStringPermissions(list);
          return simpleAuthorizationInfo;
      }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取当前用户登录的用户名名
        String username = (String) token.getPrincipal();
        User user1 = new User();
        user1.setUname(username);
        User user = userService.selectOne(user1);
        //通过用户名去数据查询正确的密码
        if (user != null) {
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUname(), user.getUpass(), getName());
            return info;
        }
        return null;
    }
}
