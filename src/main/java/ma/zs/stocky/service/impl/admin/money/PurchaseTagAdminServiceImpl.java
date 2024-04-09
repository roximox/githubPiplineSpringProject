package ma.zs.stocky.service.impl.admin.money;


import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.dao.criteria.core.money.PurchaseTagCriteria;
import ma.zs.stocky.dao.facade.core.money.PurchaseTagDao;
import ma.zs.stocky.dao.specification.core.money.PurchaseTagSpecification;
import ma.zs.stocky.service.facade.admin.money.PurchaseTagAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.money.PurchaseAdminService ;
import ma.zs.stocky.bean.core.money.Purchase ;
import ma.zs.stocky.service.facade.admin.commun.TagAdminService ;
import ma.zs.stocky.bean.core.commun.Tag ;

import java.util.List;
@Service
public class PurchaseTagAdminServiceImpl extends AbstractServiceImpl<PurchaseTag, PurchaseTagCriteria, PurchaseTagDao> implements PurchaseTagAdminService {






    public void findOrSaveAssociatedObject(PurchaseTag t){
        if( t != null) {
            t.setPurchase(purchaseService.findOrSave(t.getPurchase()));
            t.setTag(tagService.findOrSave(t.getTag()));
        }
    }

    public List<PurchaseTag> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }
    public long countByPurchaseReference(String reference){
        return dao.countByPurchaseReference(reference);
    }
    public List<PurchaseTag> findByTagId(Long id){
        return dao.findByTagId(id);
    }
    public int deleteByTagId(Long id){
        return dao.deleteByTagId(id);
    }
    public long countByTagCode(String code){
        return dao.countByTagCode(code);
    }






    public void configure() {
        super.configure(PurchaseTag.class, PurchaseTagSpecification.class);
    }


    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private TagAdminService tagService ;

    public PurchaseTagAdminServiceImpl(PurchaseTagDao dao) {
        super(dao);
    }

}
