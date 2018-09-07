package info.natebowang.wbqly.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import info.natebowang.wbqly.category.Category;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(insertable=false)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private LocalDateTime publishTime;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(insertable=false)
    private LocalDateTime lmt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ArticleCategory",
            joinColumns = {@JoinColumn(name = "articleId")},
            inverseJoinColumns = {@JoinColumn(name = "categoryId")})
    private Set<Category> categories = new HashSet<>();

}
