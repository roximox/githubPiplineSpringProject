package ma.zs.stocky.unit.ws.facade.admin.commun;

import ma.zs.stocky.bean.core.commun.Tag;
import ma.zs.stocky.service.impl.admin.commun.TagAdminServiceImpl;
import ma.zs.stocky.ws.facade.admin.commun.TagRestAdmin;
import ma.zs.stocky.ws.converter.commun.TagConverter;
import ma.zs.stocky.ws.dto.commun.TagDto;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TagRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TagAdminServiceImpl service;
    @Mock
    private TagConverter converter;

    @InjectMocks
    private TagRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTagTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TagDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TagDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTagTest() throws Exception {
        // Mock data
        TagDto requestDto = new TagDto();
        Tag entity = new Tag();
        Tag saved = new Tag();
        TagDto savedDto = new TagDto();

        // Mock the converter to return the tag object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved tag DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TagDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TagDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved tag DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getReference(), responseBody.getReference());
    }

}
