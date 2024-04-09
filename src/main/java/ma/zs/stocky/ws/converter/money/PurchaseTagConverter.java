package  ma.zs.stocky.ws.converter.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.money.PurchaseConverter;
import ma.zs.stocky.ws.converter.commun.TagConverter;

import ma.zs.stocky.bean.core.money.Purchase;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.money.PurchaseTag;
import ma.zs.stocky.ws.dto.money.PurchaseTagDto;

@Component
public class PurchaseTagConverter extends AbstractConverter<PurchaseTag, PurchaseTagDto> {

    @Autowired
    private PurchaseConverter purchaseConverter ;
    @Autowired
    private TagConverter tagConverter ;
    private boolean purchase;
    private boolean tag;

    public  PurchaseTagConverter() {
        super(PurchaseTag.class, PurchaseTagDto.class);
        init(true);
    }

    @Override
    public PurchaseTag toItem(PurchaseTagDto dto) {
        if (dto == null) {
            return null;
        } else {
        PurchaseTag item = new PurchaseTag();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getPurchase() != null && dto.getPurchase().getId() != null){
                item.setPurchase(new Purchase());
                item.getPurchase().setId(dto.getPurchase().getId());
                item.getPurchase().setReference(dto.getPurchase().getReference());
            }

            if(this.tag && dto.getTag()!=null)
                item.setTag(tagConverter.toItem(dto.getTag())) ;




        return item;
        }
    }

    @Override
    public PurchaseTagDto toDto(PurchaseTag item) {
        if (item == null) {
            return null;
        } else {
            PurchaseTagDto dto = new PurchaseTagDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(this.purchase && item.getPurchase()!=null) {
                dto.setPurchase(purchaseConverter.toDto(item.getPurchase())) ;

            }
            if(this.tag && item.getTag()!=null) {
                dto.setTag(tagConverter.toDto(item.getTag())) ;

            }


        return dto;
        }
    }

    public void copy(PurchaseTagDto dto, PurchaseTag t) {
    super.copy(dto, t);
    if (dto.getPurchase() != null)
        purchaseConverter.copy(dto.getPurchase(), t.getPurchase());
    if (dto.getTag() != null)
        tagConverter.copy(dto.getTag(), t.getTag());
    }



    public void initObject(boolean value) {
        this.purchase = value;
        this.tag = value;
    }


    public PurchaseConverter getPurchaseConverter(){
        return this.purchaseConverter;
    }
    public void setPurchaseConverter(PurchaseConverter purchaseConverter ){
        this.purchaseConverter = purchaseConverter;
    }
    public TagConverter getTagConverter(){
        return this.tagConverter;
    }
    public void setTagConverter(TagConverter tagConverter ){
        this.tagConverter = tagConverter;
    }
    public boolean  isPurchase(){
        return this.purchase;
    }
    public void  setPurchase(boolean purchase){
        this.purchase = purchase;
    }
    public boolean  isTag(){
        return this.tag;
    }
    public void  setTag(boolean tag){
        this.tag = tag;
    }
}
