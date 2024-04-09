package ma.zs.stocky.service.impl.admin.money;


import ma.zs.stocky.bean.core.money.PurchaseItem;
import ma.zs.stocky.dao.criteria.core.money.PurchaseItemCriteria;
import ma.zs.stocky.dao.facade.core.money.PurchaseItemDao;
import ma.zs.stocky.dao.specification.core.money.PurchaseItemSpecification;
import ma.zs.stocky.service.facade.admin.money.PurchaseItemAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.money.PurchaseAdminService ;
import ma.zs.stocky.bean.core.money.Purchase ;
import ma.zs.stocky.service.facade.admin.catalog.ProductAdminService ;
import ma.zs.stocky.bean.core.catalog.Product ;

import java.util.List;
@Service
public class PurchaseItemAdminServiceImpl extends AbstractServiceImpl<PurchaseItem, PurchaseItemCriteria, PurchaseItemDao> implements PurchaseItemAdminService {






    public void findOrSaveAssociatedObject(PurchaseItem t){
        if( t != null) {
            t.setProduct(productService.findOrSave(t.getProduct()));
            t.setPurchase(purchaseService.findOrSave(t.getPurchase()));
        }
    }

    public List<PurchaseItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public long countByProductCode(String code){
        return dao.countByProductCode(code);
    }
    public List<PurchaseItem> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }
    public long countByPurchaseReference(String reference){
        return dao.countByPurchaseReference(reference);
    }






    public void configure() {
        super.configure(PurchaseItem.class, PurchaseItemSpecification.class);
    }


    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private ProductAdminService productService ;

    public PurchaseItemAdminServiceImpl(PurchaseItemDao dao) {
        super(dao);
    }

}
