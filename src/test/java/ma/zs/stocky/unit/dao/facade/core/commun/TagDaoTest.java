package ma.zs.stocky.unit.dao.facade.core.commun;

import ma.zs.stocky.bean.core.commun.Tag;
import ma.zs.stocky.dao.facade.core.commun.TagDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TagDaoTest {

@Autowired
    private TagDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Tag entity = new Tag();
        entity.setCode(code);
        underTest.save(entity);
        Tag loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Tag entity = new Tag();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Tag loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Tag entity = new Tag();
        entity.setId(id);
        underTest.save(entity);
        Tag loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Tag entity = new Tag();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Tag loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Tag> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Tag> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Tag given = constructSample(1);
        Tag saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Tag constructSample(int i) {
		Tag given = new Tag();
        given.setCode("code-"+i);
        given.setReference("reference-"+i);
        return given;
    }

}
