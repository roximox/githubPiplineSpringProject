package ma.zs.stocky.service.impl.admin.crm;


import ma.zs.stocky.bean.core.crm.ClientCategory;
import ma.zs.stocky.dao.criteria.core.crm.ClientCategoryCriteria;
import ma.zs.stocky.dao.facade.core.crm.ClientCategoryDao;
import ma.zs.stocky.dao.specification.core.crm.ClientCategorySpecification;
import ma.zs.stocky.service.facade.admin.crm.ClientCategoryAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClientCategoryAdminServiceImpl extends AbstractServiceImpl<ClientCategory, ClientCategoryCriteria, ClientCategoryDao> implements ClientCategoryAdminService {






    public ClientCategory findByReferenceEntity(ClientCategory t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<ClientCategory> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ClientCategory.class, ClientCategorySpecification.class);
    }



    public ClientCategoryAdminServiceImpl(ClientCategoryDao dao) {
        super(dao);
    }

}
