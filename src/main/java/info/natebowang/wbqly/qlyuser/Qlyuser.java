package info.natebowang.wbqly.qlyuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Qlyuser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(insertable=false)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String authority;

    private LocalDate expireDate;

    private Boolean enabled;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(insertable=false)
    private LocalDateTime lmt;

    @PrePersist
    protected void onCreate() {
        if (authority == null) { authority = "USER"; }
        if (enabled == null) { enabled = true; }
    }

    public void setPassword(String rawPassword) {
        this.password=
                new BCryptPasswordEncoder().encode(rawPassword);
    }
}