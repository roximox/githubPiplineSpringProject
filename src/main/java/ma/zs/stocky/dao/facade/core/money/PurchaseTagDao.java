package ma.zs.stocky.dao.facade.core.money;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.money.PurchaseTag;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PurchaseTagDao extends AbstractRepository<PurchaseTag,Long>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    long countByPurchaseReference(String reference);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);
    long countByTagCode(String code);


}
