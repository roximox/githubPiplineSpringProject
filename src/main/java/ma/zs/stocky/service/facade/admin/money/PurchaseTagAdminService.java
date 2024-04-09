package ma.zs.stocky.service.facade.admin.money;

import java.util.List;
import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.dao.criteria.core.money.PurchaseTagCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface PurchaseTagAdminService extends  IService<PurchaseTag,PurchaseTagCriteria>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    long countByPurchaseReference(String reference);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);
    long countByTagCode(String code);




}
