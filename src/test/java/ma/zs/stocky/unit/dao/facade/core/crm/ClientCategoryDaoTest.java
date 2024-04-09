package ma.zs.stocky.unit.dao.facade.core.crm;

import ma.zs.stocky.bean.core.crm.ClientCategory;
import ma.zs.stocky.dao.facade.core.crm.ClientCategoryDao;

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
public class ClientCategoryDaoTest {

@Autowired
    private ClientCategoryDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        ClientCategory entity = new ClientCategory();
        entity.setCode(code);
        underTest.save(entity);
        ClientCategory loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        ClientCategory entity = new ClientCategory();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        ClientCategory loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        ClientCategory entity = new ClientCategory();
        entity.setId(id);
        underTest.save(entity);
        ClientCategory loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ClientCategory entity = new ClientCategory();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ClientCategory loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ClientCategory> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ClientCategory> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ClientCategory given = constructSample(1);
        ClientCategory saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ClientCategory constructSample(int i) {
		ClientCategory given = new ClientCategory();
        given.setReference("reference-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
