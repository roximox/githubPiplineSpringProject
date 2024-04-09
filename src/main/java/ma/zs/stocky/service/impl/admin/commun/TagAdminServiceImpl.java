package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Tag;
import ma.zs.stocky.dao.criteria.core.commun.TagCriteria;
import ma.zs.stocky.dao.facade.core.commun.TagDao;
import ma.zs.stocky.dao.specification.core.commun.TagSpecification;
import ma.zs.stocky.service.facade.admin.commun.TagAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TagAdminServiceImpl extends AbstractServiceImpl<Tag, TagCriteria, TagDao> implements TagAdminService {






    public Tag findByReferenceEntity(Tag t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<Tag> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Tag.class, TagSpecification.class);
    }



    public TagAdminServiceImpl(TagDao dao) {
        super(dao);
    }

}
