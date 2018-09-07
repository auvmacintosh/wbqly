package info.natebowang.wbqly.qlyuser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QlyuserDetailsService implements UserDetailsService {

    private QlyuserRepository userRepository;

    public QlyuserDetailsService(QlyuserRepository qlyuserRepository) {
        this.userRepository = qlyuserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Qlyuser qlyuser = userRepository.findByUsername(username);
        if (qlyuser != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            String[] auts = qlyuser.getAuthority().split(",");
            for (String aut : auts) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + aut));
            }

            boolean accountNonExpired = true;
            LocalDate expireDate = qlyuser.getExpireDate();
            if (expireDate != null) {
                if (expireDate.isBefore(LocalDate.now())) {
                    accountNonExpired = false;
                }
            }

            return new User(qlyuser.getUsername(),
                    qlyuser.getPassword(),
                    qlyuser.getEnabled(),
                    accountNonExpired,
                    true,
                    true,
                    authorities);
        }
        throw new UsernameNotFoundException(String.format("User '%s' not found", username));
    }
}
