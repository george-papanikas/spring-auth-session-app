package gr.aueb.cf.springauthsession5.service;

import gr.aueb.cf.springauthsession5.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService {
    User getUserByUsername(String username) throws UsernameNotFoundException;
}
