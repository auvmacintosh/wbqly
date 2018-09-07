package info.natebowang.wbqly;

import info.natebowang.wbqly.article.Article;
import info.natebowang.wbqly.article.ArticleRepository;
import info.natebowang.wbqly.category.Category;
import info.natebowang.wbqly.category.CategoryRepository;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WbqlyApplicationTests {
    @Autowired
    private ArticleRepository ar;

    @Autowired
    private CategoryRepository cr;

    @Test
    @Transactional
    public void contextLoads() {
        Article a = ar.findById(2L).get();
        Category c = cr.findById(1L).get();
        a.getCategories().add(c);
        System.out.println(a);
        ar.save(a);

    }

}
