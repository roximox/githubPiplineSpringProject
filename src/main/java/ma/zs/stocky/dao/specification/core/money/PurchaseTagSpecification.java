package  ma.zs.stocky.dao.specification.core.money;

import ma.zs.stocky.dao.criteria.core.money.PurchaseTagCriteria;
import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class PurchaseTagSpecification extends  AbstractSpecification<PurchaseTagCriteria, PurchaseTag>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("purchase","id", criteria.getPurchase()==null?null:criteria.getPurchase().getId());
        addPredicateFk("purchase","id", criteria.getPurchases());
        addPredicateFk("purchase","reference", criteria.getPurchase()==null?null:criteria.getPurchase().getReference());
        addPredicateFk("tag","id", criteria.getTag()==null?null:criteria.getTag().getId());
        addPredicateFk("tag","id", criteria.getTags());
        addPredicateFk("tag","code", criteria.getTag()==null?null:criteria.getTag().getCode());
    }

    public PurchaseTagSpecification(PurchaseTagCriteria criteria) {
        super(criteria);
    }

    public PurchaseTagSpecification(PurchaseTagCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
