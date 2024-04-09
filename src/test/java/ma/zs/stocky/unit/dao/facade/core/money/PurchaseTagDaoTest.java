package ma.zs.stocky.unit.dao.facade.core.money;

import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.dao.facade.core.money.PurchaseTagDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.stocky.bean.core.money.Purchase ;
import ma.zs.stocky.bean.core.commun.Tag ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PurchaseTagDaoTest {

@Autowired
    private PurchaseTagDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        PurchaseTag entity = new PurchaseTag();
        entity.setId(id);
        underTest.save(entity);
        PurchaseTag loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        PurchaseTag entity = new PurchaseTag();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        PurchaseTag loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<PurchaseTag> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<PurchaseTag> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        PurchaseTag given = constructSample(1);
        PurchaseTag saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private PurchaseTag constructSample(int i) {
		PurchaseTag given = new PurchaseTag();
        given.setPurchase(new Purchase(1L));
        given.setTag(new Tag(1L));
        return given;
    }

}
