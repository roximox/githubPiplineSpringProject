package ma.zs.stocky.unit.service.impl.admin.money;

import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.dao.facade.core.money.PurchaseTagDao;
import ma.zs.stocky.service.impl.admin.money.PurchaseTagAdminServiceImpl;

import ma.zs.stocky.bean.core.money.Purchase ;
import ma.zs.stocky.bean.core.commun.Tag ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class PurchaseTagAdminServiceImplTest {

    @Mock
    private PurchaseTagDao repository;
    private AutoCloseable autoCloseable;
    private PurchaseTagAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PurchaseTagAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPurchaseTag() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePurchaseTag() {
        // Given
        PurchaseTag toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePurchaseTag() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPurchaseTagById() {
        // Given
        Long idToRetrieve = 1L; // Example PurchaseTag ID to retrieve
        PurchaseTag expected = new PurchaseTag(); // You need to replace PurchaseTag with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        PurchaseTag result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private PurchaseTag constructSample(int i) {
		PurchaseTag given = new PurchaseTag();
        given.setPurchase(new Purchase(1L));
        given.setTag(new Tag(1L));
        return given;
    }

}
