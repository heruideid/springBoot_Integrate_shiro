package realm;

import com.nostalgia.entity.Account;
import com.nostalgia.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class AccountRealm extends AuthorizingRealm {
    @Autowired
    AccountService accountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject= SecurityUtils.getSubject();
        Account account=(Account) subject.getPrincipal();
        Set<String> roles=new HashSet<>();
        roles.add(account.getRole());
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
        info.addStringPermission(account.getPerm());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        Account account=accountService.findByUserName(token.getUsername());
        if(account!=null){
            return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
        }
        return null;
    }
}
