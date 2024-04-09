package  ma.zs.stocky.ws.facade.admin.money;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.dao.criteria.core.money.PurchaseTagCriteria;
import ma.zs.stocky.service.facade.admin.money.PurchaseTagAdminService;
import ma.zs.stocky.ws.converter.money.PurchaseTagConverter;
import ma.zs.stocky.ws.dto.money.PurchaseTagDto;
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
@RequestMapping("/api/admin/purchaseTag/")
public class PurchaseTagRestAdmin  extends AbstractController<PurchaseTag, PurchaseTagDto, PurchaseTagCriteria, PurchaseTagAdminService, PurchaseTagConverter> {



    @Operation(summary = "upload one purchaseTag")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple purchaseTags")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all purchaseTags")
    @GetMapping("")
    public ResponseEntity<List<PurchaseTagDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  purchaseTag")
    @PostMapping("")
    public ResponseEntity<PurchaseTagDto> save(@RequestBody PurchaseTagDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  purchaseTag")
    @PutMapping("")
    public ResponseEntity<PurchaseTagDto> update(@RequestBody PurchaseTagDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of purchaseTag")
    @PostMapping("multiple")
    public ResponseEntity<List<PurchaseTagDto>> delete(@RequestBody List<PurchaseTagDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified purchaseTag")
    @DeleteMapping("")
    public ResponseEntity<PurchaseTagDto> delete(@RequestBody PurchaseTagDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified purchaseTag")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple purchaseTags by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by purchase id")
    @GetMapping("purchase/id/{id}")
    public List<PurchaseTagDto> findByPurchaseId(@PathVariable Long id){
        return findDtos(service.findByPurchaseId(id));
    }
    @Operation(summary = "delete by purchase id")
    @DeleteMapping("purchase/id/{id}")
    public int deleteByPurchaseId(@PathVariable Long id){
        return service.deleteByPurchaseId(id);
    }
    @Operation(summary = "find by tag id")
    @GetMapping("tag/id/{id}")
    public List<PurchaseTagDto> findByTagId(@PathVariable Long id){
        return findDtos(service.findByTagId(id));
    }
    @Operation(summary = "delete by tag id")
    @DeleteMapping("tag/id/{id}")
    public int deleteByTagId(@PathVariable Long id){
        return service.deleteByTagId(id);
    }

    @Operation(summary = "Finds a purchaseTag and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PurchaseTagDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds purchaseTags by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PurchaseTagDto>> findByCriteria(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated purchaseTags by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports purchaseTags by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets purchaseTag data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PurchaseTagCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PurchaseTagRestAdmin (PurchaseTagAdminService service, PurchaseTagConverter converter) {
        super(service, converter);
    }




}
