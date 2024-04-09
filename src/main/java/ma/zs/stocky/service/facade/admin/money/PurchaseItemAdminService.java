package ma.zs.stocky.service.facade.admin.money;

import java.util.List;
import ma.zs.stocky.bean.core.money.PurchaseItem;
import ma.zs.stocky.dao.criteria.core.money.PurchaseItemCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    long countByProductCode(String code);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    long countByPurchaseReference(String reference);




}
