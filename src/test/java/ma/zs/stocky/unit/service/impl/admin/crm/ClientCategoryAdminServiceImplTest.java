package ma.zs.stocky.unit.service.impl.admin.crm;

import ma.zs.stocky.bean.core.crm.ClientCategory;
import ma.zs.stocky.dao.facade.core.crm.ClientCategoryDao;
import ma.zs.stocky.service.impl.admin.crm.ClientCategoryAdminServiceImpl;

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
class ClientCategoryAdminServiceImplTest {

    @Mock
    private ClientCategoryDao repository;
    private AutoCloseable autoCloseable;
    private ClientCategoryAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ClientCategoryAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllClientCategory() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveClientCategory() {
        // Given
        ClientCategory toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteClientCategory() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetClientCategoryById() {
        // Given
        Long idToRetrieve = 1L; // Example ClientCategory ID to retrieve
        ClientCategory expected = new ClientCategory(); // You need to replace ClientCategory with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ClientCategory result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ClientCategory constructSample(int i) {
		ClientCategory given = new ClientCategory();
        given.setReference("reference-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
