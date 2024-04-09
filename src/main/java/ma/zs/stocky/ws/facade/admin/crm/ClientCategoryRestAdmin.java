package  ma.zs.stocky.ws.facade.admin.crm;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.crm.ClientCategory;
import ma.zs.stocky.dao.criteria.core.crm.ClientCategoryCriteria;
import ma.zs.stocky.service.facade.admin.crm.ClientCategoryAdminService;
import ma.zs.stocky.ws.converter.crm.ClientCategoryConverter;
import ma.zs.stocky.ws.dto.crm.ClientCategoryDto;
import ma.zs.stocky.zynerator.controller.AbstractController;
import ma.zs.stocky.zynerator.dto.AuditEntityDto;
import ma.zs.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/clientCategory/")
public class ClientCategoryRestAdmin  extends AbstractController<ClientCategory, ClientCategoryDto, ClientCategoryCriteria, ClientCategoryAdminService, ClientCategoryConverter> {



    @Operation(summary = "upload one clientCategory")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple clientCategorys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all clientCategorys")
    @GetMapping("")
    public ResponseEntity<List<ClientCategoryDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all clientCategorys")
    @GetMapping("optimized")
    public ResponseEntity<List<ClientCategoryDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a clientCategory by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ClientCategoryDto> findByReference(@PathVariable String reference) {
        return super.findByReferenceEntity(new ClientCategory(reference));
    }

    @Operation(summary = "Saves the specified  clientCategory")
    @PostMapping("")
    public ResponseEntity<ClientCategoryDto> save(@RequestBody ClientCategoryDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  clientCategory")
    @PutMapping("")
    public ResponseEntity<ClientCategoryDto> update(@RequestBody ClientCategoryDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of clientCategory")
    @PostMapping("multiple")
    public ResponseEntity<List<ClientCategoryDto>> delete(@RequestBody List<ClientCategoryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified clientCategory")
    @DeleteMapping("")
    public ResponseEntity<ClientCategoryDto> delete(@RequestBody ClientCategoryDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified clientCategory")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple clientCategorys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a clientCategory and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClientCategoryDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds clientCategorys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ClientCategoryDto>> findByCriteria(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated clientCategorys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports clientCategorys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets clientCategory data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ClientCategoryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ClientCategoryRestAdmin (ClientCategoryAdminService service, ClientCategoryConverter converter) {
        super(service, converter);
    }




}
