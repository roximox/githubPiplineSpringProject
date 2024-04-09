package ma.zs.stocky.service.impl.admin.money;


import ma.zs.stocky.bean.core.money.Purchase;
import ma.zs.stocky.dao.criteria.core.money.PurchaseCriteria;
import ma.zs.stocky.dao.facade.core.money.PurchaseDao;
import ma.zs.stocky.dao.specification.core.money.PurchaseSpecification;
import ma.zs.stocky.service.facade.admin.money.PurchaseAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.money.PurchaseTagAdminService ;
import ma.zs.stocky.bean.core.money.PurchaseTag ;
import ma.zs.stocky.service.facade.admin.commun.PurchaseStateAdminService ;
import ma.zs.stocky.bean.core.commun.PurchaseState ;
import ma.zs.stocky.service.facade.admin.catalog.ProductAdminService ;
import ma.zs.stocky.bean.core.catalog.Product ;
import ma.zs.stocky.service.facade.admin.money.PurchaseItemAdminService ;
import ma.zs.stocky.bean.core.money.PurchaseItem ;
import ma.zs.stocky.service.facade.admin.crm.ClientAdminService ;
import ma.zs.stocky.bean.core.crm.Client ;

import java.util.List;
@Service
public class PurchaseAdminServiceImpl extends AbstractServiceImpl<Purchase, PurchaseCriteria, PurchaseDao> implements PurchaseAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        if (t.getClient() != null) {
            t.getClient().setId(null);
            t.setClient(clientService.create(t.getClient()));
        }
        Purchase saved= super.create(t);
        if (saved != null && t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                if (element.getProduct() != null) {
                    element.getProduct().setId(null);
                    element.setProduct(productService.create(element.getProduct()));
                }
                element.setPurchase(saved);
                purchaseItemService.create(element);
            });
        }
        if (saved != null && t.getPurchaseTags() != null) {
                t.getPurchaseTags().forEach(element-> {
                element.setPurchase(saved);
                purchaseTagService.create(element);
            });
        }
        return saved;

    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
            result.setPurchaseTags(purchaseTagService.findByPurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
        purchaseTagService.deleteByPurchaseId(id);
    }


    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
            List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
            ListUtil.emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseItemService.update(resultPurchaseItems.get(0),true);
            List<List<PurchaseTag>> resultPurchaseTags= purchaseTagService.getToBeSavedAndToBeDeleted(purchaseTagService.findByPurchaseId(purchase.getId()),purchase.getPurchaseTags());
            purchaseTagService.delete(resultPurchaseTags.get(1));
            ListUtil.emptyIfNull(resultPurchaseTags.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseTagService.update(resultPurchaseTags.get(0),true);
        }
    }




    public Purchase findByReferenceEntity(Purchase t){
        return t==null? null : dao.findByReference(t.getReference());
    }
    public void findOrSaveAssociatedObject(Purchase t){
        if( t != null) {
            t.setClient(clientService.findOrSave(t.getClient()));
            t.setPurchaseState(purchaseStateService.findOrSave(t.getPurchaseState()));
        }
    }

    public List<Purchase> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientEmail(String email){
        return dao.countByClientEmail(email);
    }
    public List<Purchase> findByPurchaseStateId(Long id){
        return dao.findByPurchaseStateId(id);
    }
    public int deleteByPurchaseStateId(Long id){
        return dao.deleteByPurchaseStateId(id);
    }
    public long countByPurchaseStateCode(String code){
        return dao.countByPurchaseStateCode(code);
    }

    public List<Purchase> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Purchase.class, PurchaseSpecification.class);
    }


    @Autowired
    private PurchaseTagAdminService purchaseTagService ;
    @Autowired
    private PurchaseStateAdminService purchaseStateService ;
    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    @Autowired
    private ClientAdminService clientService ;

    public PurchaseAdminServiceImpl(PurchaseDao dao) {
        super(dao);
    }

}
