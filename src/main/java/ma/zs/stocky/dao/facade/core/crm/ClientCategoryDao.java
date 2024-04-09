package ma.zs.stocky.dao.facade.core.crm;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.crm.ClientCategory;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.crm.ClientCategory;
import java.util.List;


@Repository
public interface ClientCategoryDao extends AbstractRepository<ClientCategory,Long>  {
    ClientCategory findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ClientCategory(item.id,item.reference) FROM ClientCategory item")
    List<ClientCategory> findAllOptimized();

}
