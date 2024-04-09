package ma.zs.stocky.service.impl.admin.catalog;


import ma.zs.stocky.bean.core.catalog.Product;
import ma.zs.stocky.dao.criteria.core.catalog.ProductCriteria;
import ma.zs.stocky.dao.facade.core.catalog.ProductDao;
import ma.zs.stocky.dao.specification.core.catalog.ProductSpecification;
import ma.zs.stocky.service.facade.admin.catalog.ProductAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product, ProductCriteria, ProductDao> implements ProductAdminService {






    public Product findByReferenceEntity(Product t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<Product> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Product.class, ProductSpecification.class);
    }



    public ProductAdminServiceImpl(ProductDao dao) {
        super(dao);
    }

}
