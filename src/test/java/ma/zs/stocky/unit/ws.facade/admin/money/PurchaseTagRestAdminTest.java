package ma.zs.stocky.unit.ws.facade.admin.money;

import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.service.impl.admin.money.PurchaseTagAdminServiceImpl;
import ma.zs.stocky.ws.facade.admin.money.PurchaseTagRestAdmin;
import ma.zs.stocky.ws.converter.money.PurchaseTagConverter;
import ma.zs.stocky.ws.dto.money.PurchaseTagDto;
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
public class PurchaseTagRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private PurchaseTagAdminServiceImpl service;
    @Mock
    private PurchaseTagConverter converter;

    @InjectMocks
    private PurchaseTagRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPurchaseTagTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PurchaseTagDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PurchaseTagDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePurchaseTagTest() throws Exception {
        // Mock data
        PurchaseTagDto requestDto = new PurchaseTagDto();
        PurchaseTag entity = new PurchaseTag();
        PurchaseTag saved = new PurchaseTag();
        PurchaseTagDto savedDto = new PurchaseTagDto();

        // Mock the converter to return the purchaseTag object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved purchaseTag DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PurchaseTagDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PurchaseTagDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved purchaseTag DTO
    }

}
