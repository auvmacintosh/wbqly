package info.natebowang.wbqly.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(insertable=false)
    private Long id;

    @NotNull
    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(insertable=false)
    private LocalDateTime lmt;

}
