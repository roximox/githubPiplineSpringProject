package  ma.zs.stocky.ws.dto.money;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.stocky.ws.dto.commun.TagDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseTagDto  extends AuditBaseDto {


    private PurchaseDto purchase ;
    private TagDto tag ;



    public PurchaseTagDto(){
        super();
    }




    public PurchaseDto getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseDto purchase){
        this.purchase = purchase;
    }
    public TagDto getTag(){
        return this.tag;
    }

    public void setTag(TagDto tag){
        this.tag = tag;
    }






}
