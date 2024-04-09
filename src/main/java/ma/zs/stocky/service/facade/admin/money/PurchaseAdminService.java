package ma.zs.stocky.service.facade.admin.money;

import java.util.List;
import ma.zs.stocky.bean.core.money.Purchase;
import ma.zs.stocky.dao.criteria.core.money.PurchaseCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface PurchaseAdminService extends  IService<Purchase,PurchaseCriteria>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientEmail(String email);
    List<Purchase> findByPurchaseStateId(Long id);
    int deleteByPurchaseStateId(Long id);
    long countByPurchaseStateCode(String code);




}
