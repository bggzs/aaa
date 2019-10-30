package com.bgg.ssm.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.swing.ListModel;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.bgg.ssm.entity.Teacher;
import com.bgg.ssm.service.UserService;

public class CustomRealm extends AuthorizingRealm{
	@Resource
	private UserService UserService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("授权.......");
		String username=(String) principals.getPrimaryPrincipal();
		List<Teacher> res=UserService.findTeacherById(username);
		Teacher teacher=res.get(0);
		Set<String> roles=new HashSet<>();
		roles.add(teacher.getUser_name());
		Set<String> permission =new HashSet<>();
		permission.add(teacher.getUser_name());
		System.out.println("授权....."+teacher.getUser_name());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(roles);
		authorizationInfo.setStringPermissions(permission);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("认证.......");
		String username=(String) token.getPrincipal();
		
		
		List<Teacher> res=UserService.findTeacherById(username);
		System.out.println(res.size());
		Teacher teacher=res.get(0);
		System.out.println(teacher.getUser_id()+" "+teacher.getUser_password());
		String password=teacher.getUser_password();
		if(password==null || username==null) {
			return null;
		}
		
		 return new SimpleAuthenticationInfo(username,password,getName());
	}

}
