package ua.hrynko.projectcv.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hrynko.projectcv.db.dao.MySqlUsersDAO;
import ua.hrynko.projectcv.db.models.Roles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MySqlUsersDAO mySqlUsersDAO;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        ua.hrynko.projectcv.db.models.Users user = mySqlUsersDAO.findUserByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

        return buildUserForAuthentication(user, authorities);
    }

    // Converts  ua.hrynko.projectcv.db.dto.Users user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(ua.hrynko.projectcv.db.models.Users user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(), true,
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Roles role) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        setAuths.add(new SimpleGrantedAuthority(role.getName()));

        List<GrantedAuthority> Result = new ArrayList<>(setAuths);

        return Result;
    }

}