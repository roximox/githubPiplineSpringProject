package ma.zs.stocky.bean.core.money;

import java.util.Objects;





import ma.zs.stocky.bean.core.money.Purchase;
import ma.zs.stocky.bean.core.commun.Tag;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "purchase_tag")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="purchase_tag_seq",sequenceName="purchase_tag_seq",allocationSize=1, initialValue = 1)
public class PurchaseTag   extends AuditBusinessObject     {

    private Long id;


    private Purchase purchase ;
    private Tag tag ;


    public PurchaseTag(){
        super();
    }

    public PurchaseTag(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="purchase_tag_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase")
    public Purchase getPurchase(){
        return this.purchase;
    }
    public void setPurchase(Purchase purchase){
        this.purchase = purchase;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag")
    public Tag getTag(){
        return this.tag;
    }
    public void setTag(Tag tag){
        this.tag = tag;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseTag purchaseTag = (PurchaseTag) o;
        return id != null && id.equals(purchaseTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

