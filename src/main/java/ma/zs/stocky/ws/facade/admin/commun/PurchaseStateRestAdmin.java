package  ma.zs.stocky.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commun.PurchaseState;
import ma.zs.stocky.dao.criteria.core.commun.PurchaseStateCriteria;
import ma.zs.stocky.service.facade.admin.commun.PurchaseStateAdminService;
import ma.zs.stocky.ws.converter.commun.PurchaseStateConverter;
import ma.zs.stocky.ws.dto.commun.PurchaseStateDto;
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
@RequestMapping("/api/admin/purchaseState/")
public class PurchaseStateRestAdmin  extends AbstractController<PurchaseState, PurchaseStateDto, PurchaseStateCriteria, PurchaseStateAdminService, PurchaseStateConverter> {



    @Operation(summary = "upload one purchaseState")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple purchaseStates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all purchaseStates")
    @GetMapping("")
    public ResponseEntity<List<PurchaseStateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all purchaseStates")
    @GetMapping("optimized")
    public ResponseEntity<List<PurchaseStateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a purchaseState by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<PurchaseStateDto> findByReference(@PathVariable String reference) {
        return super.findByReferenceEntity(new PurchaseState(reference));
    }

    @Operation(summary = "Saves the specified  purchaseState")
    @PostMapping("")
    public ResponseEntity<PurchaseStateDto> save(@RequestBody PurchaseStateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  purchaseState")
    @PutMapping("")
    public ResponseEntity<PurchaseStateDto> update(@RequestBody PurchaseStateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of purchaseState")
    @PostMapping("multiple")
    public ResponseEntity<List<PurchaseStateDto>> delete(@RequestBody List<PurchaseStateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified purchaseState")
    @DeleteMapping("")
    public ResponseEntity<PurchaseStateDto> delete(@RequestBody PurchaseStateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified purchaseState")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple purchaseStates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a purchaseState and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PurchaseStateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds purchaseStates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PurchaseStateDto>> findByCriteria(@RequestBody PurchaseStateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated purchaseStates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PurchaseStateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports purchaseStates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PurchaseStateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets purchaseState data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PurchaseStateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PurchaseStateRestAdmin (PurchaseStateAdminService service, PurchaseStateConverter converter) {
        super(service, converter);
    }




}
