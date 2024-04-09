package  ma.zs.stocky.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commun.Tag;
import ma.zs.stocky.dao.criteria.core.commun.TagCriteria;
import ma.zs.stocky.service.facade.admin.commun.TagAdminService;
import ma.zs.stocky.ws.converter.commun.TagConverter;
import ma.zs.stocky.ws.dto.commun.TagDto;
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
@RequestMapping("/api/admin/tag/")
public class TagRestAdmin  extends AbstractController<Tag, TagDto, TagCriteria, TagAdminService, TagConverter> {



    @Operation(summary = "upload one tag")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple tags")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all tags")
    @GetMapping("")
    public ResponseEntity<List<TagDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all tags")
    @GetMapping("optimized")
    public ResponseEntity<List<TagDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a tag by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<TagDto> findByReference(@PathVariable String reference) {
        return super.findByReferenceEntity(new Tag(reference));
    }

    @Operation(summary = "Saves the specified  tag")
    @PostMapping("")
    public ResponseEntity<TagDto> save(@RequestBody TagDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  tag")
    @PutMapping("")
    public ResponseEntity<TagDto> update(@RequestBody TagDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of tag")
    @PostMapping("multiple")
    public ResponseEntity<List<TagDto>> delete(@RequestBody List<TagDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified tag")
    @DeleteMapping("")
    public ResponseEntity<TagDto> delete(@RequestBody TagDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified tag")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple tags by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a tag and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TagDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds tags by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TagDto>> findByCriteria(@RequestBody TagCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated tags by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TagCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports tags by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TagCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets tag data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TagCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TagRestAdmin (TagAdminService service, TagConverter converter) {
        super(service, converter);
    }




}
