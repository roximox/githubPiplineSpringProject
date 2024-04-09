package ma.zs.stocky.service.facade.admin.crm;

import java.util.List;
import ma.zs.stocky.bean.core.crm.Client;
import ma.zs.stocky.dao.criteria.core.crm.ClientCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ClientAdminService extends  IService<Client,ClientCriteria>  {

    List<Client> findByClientCategoryId(Long id);
    int deleteByClientCategoryId(Long id);
    long countByClientCategoryCode(String code);




}
