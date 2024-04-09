package ma.zs.stocky.unit.service.impl.admin.commun;

import ma.zs.stocky.bean.core.commun.Tag;
import ma.zs.stocky.dao.facade.core.commun.TagDao;
import ma.zs.stocky.service.impl.admin.commun.TagAdminServiceImpl;

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
class TagAdminServiceImplTest {

    @Mock
    private TagDao repository;
    private AutoCloseable autoCloseable;
    private TagAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TagAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTag() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTag() {
        // Given
        Tag toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTag() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTagById() {
        // Given
        Long idToRetrieve = 1L; // Example Tag ID to retrieve
        Tag expected = new Tag(); // You need to replace Tag with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Tag result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Tag constructSample(int i) {
		Tag given = new Tag();
        given.setCode("code-"+i);
        given.setReference("reference-"+i);
        return given;
    }

}
