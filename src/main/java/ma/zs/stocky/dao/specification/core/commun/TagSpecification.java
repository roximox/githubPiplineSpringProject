package  ma.zs.stocky.dao.specification.core.commun;

import ma.zs.stocky.dao.criteria.core.commun.TagCriteria;
import ma.zs.stocky.bean.core.commun.Tag;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class TagSpecification extends  AbstractSpecification<TagCriteria, Tag>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public TagSpecification(TagCriteria criteria) {
        super(criteria);
    }

    public TagSpecification(TagCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
