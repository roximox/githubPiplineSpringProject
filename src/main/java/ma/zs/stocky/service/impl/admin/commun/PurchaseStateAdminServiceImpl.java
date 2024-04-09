package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.PurchaseState;
import ma.zs.stocky.dao.criteria.core.commun.PurchaseStateCriteria;
import ma.zs.stocky.dao.facade.core.commun.PurchaseStateDao;
import ma.zs.stocky.dao.specification.core.commun.PurchaseStateSpecification;
import ma.zs.stocky.service.facade.admin.commun.PurchaseStateAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class PurchaseStateAdminServiceImpl extends AbstractServiceImpl<PurchaseState, PurchaseStateCriteria, PurchaseStateDao> implements PurchaseStateAdminService {






    public PurchaseState findByReferenceEntity(PurchaseState t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<PurchaseState> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(PurchaseState.class, PurchaseStateSpecification.class);
    }



    public PurchaseStateAdminServiceImpl(PurchaseStateDao dao) {
        super(dao);
    }

}
