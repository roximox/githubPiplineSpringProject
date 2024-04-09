package  ma.zs.stocky.ws.converter.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.money.PurchaseTagConverter;
import ma.zs.stocky.ws.converter.commun.PurchaseStateConverter;
import ma.zs.stocky.ws.converter.catalog.ProductConverter;
import ma.zs.stocky.ws.converter.commun.TagConverter;
import ma.zs.stocky.ws.converter.money.PurchaseItemConverter;
import ma.zs.stocky.ws.converter.crm.ClientConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.money.Purchase;
import ma.zs.stocky.ws.dto.money.PurchaseDto;

@Component
public class PurchaseConverter extends AbstractConverter<Purchase, PurchaseDto> {

    @Autowired
    private PurchaseTagConverter purchaseTagConverter ;
    @Autowired
    private PurchaseStateConverter purchaseStateConverter ;
    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private TagConverter tagConverter ;
    @Autowired
    private PurchaseItemConverter purchaseItemConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    private boolean client;
    private boolean purchaseState;
    private boolean purchaseItems;
    private boolean purchaseTags;

    public  PurchaseConverter() {
        super(Purchase.class, PurchaseDto.class);
        init(true);
    }

    @Override
    public Purchase toItem(PurchaseDto dto) {
        if (dto == null) {
            return null;
        } else {
        Purchase item = new Purchase();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getPurchaseDate()))
                item.setPurchaseDate(DateUtil.stringEnToDate(dto.getPurchaseDate()));
            if(StringUtil.isNotEmpty(dto.getImage()))
                item.setImage(dto.getImage());
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.purchaseState && dto.getPurchaseState()!=null)
                item.setPurchaseState(purchaseStateConverter.toItem(dto.getPurchaseState())) ;


            if(this.purchaseItems && ListUtil.isNotEmpty(dto.getPurchaseItems()))
                item.setPurchaseItems(purchaseItemConverter.toItem(dto.getPurchaseItems()));
            if(this.purchaseTags && ListUtil.isNotEmpty(dto.getPurchaseTags()))
                item.setPurchaseTags(purchaseTagConverter.toItem(dto.getPurchaseTags()));


        return item;
        }
    }

    @Override
    public PurchaseDto toDto(Purchase item) {
        if (item == null) {
            return null;
        } else {
            PurchaseDto dto = new PurchaseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getPurchaseDate()!=null)
                dto.setPurchaseDate(DateUtil.dateTimeToString(item.getPurchaseDate()));
            if(StringUtil.isNotEmpty(item.getImage()))
                dto.setImage(item.getImage());
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(this.client && item.getClient()!=null) {
                dto.setClient(clientConverter.toDto(item.getClient())) ;

            }
            if(this.purchaseState && item.getPurchaseState()!=null) {
                dto.setPurchaseState(purchaseStateConverter.toDto(item.getPurchaseState())) ;

            }
        if(this.purchaseItems && ListUtil.isNotEmpty(item.getPurchaseItems())){
            purchaseItemConverter.init(true);
            purchaseItemConverter.setPurchase(false);
            dto.setPurchaseItems(purchaseItemConverter.toDto(item.getPurchaseItems()));
            purchaseItemConverter.setPurchase(true);

        }
        if(this.purchaseTags && ListUtil.isNotEmpty(item.getPurchaseTags())){
            purchaseTagConverter.init(true);
            purchaseTagConverter.setPurchase(false);
            dto.setPurchaseTags(purchaseTagConverter.toDto(item.getPurchaseTags()));
            purchaseTagConverter.setPurchase(true);

        }


        return dto;
        }
    }

    public void copy(PurchaseDto dto, Purchase t) {
    super.copy(dto, t);
    if (dto.getClient() != null)
        clientConverter.copy(dto.getClient(), t.getClient());
    if (dto.getPurchaseState() != null)
        purchaseStateConverter.copy(dto.getPurchaseState(), t.getPurchaseState());
    if (dto.getPurchaseItems() != null)
        t.setPurchaseItems(purchaseItemConverter.copy(dto.getPurchaseItems()));
    if (dto.getPurchaseTags() != null)
        t.setPurchaseTags(purchaseTagConverter.copy(dto.getPurchaseTags()));
    }


    public void initList(boolean value) {
        this.purchaseItems = value;
        this.purchaseTags = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.purchaseState = value;
    }


    public PurchaseTagConverter getPurchaseTagConverter(){
        return this.purchaseTagConverter;
    }
    public void setPurchaseTagConverter(PurchaseTagConverter purchaseTagConverter ){
        this.purchaseTagConverter = purchaseTagConverter;
    }
    public PurchaseStateConverter getPurchaseStateConverter(){
        return this.purchaseStateConverter;
    }
    public void setPurchaseStateConverter(PurchaseStateConverter purchaseStateConverter ){
        this.purchaseStateConverter = purchaseStateConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public TagConverter getTagConverter(){
        return this.tagConverter;
    }
    public void setTagConverter(TagConverter tagConverter ){
        this.tagConverter = tagConverter;
    }
    public PurchaseItemConverter getPurchaseItemConverter(){
        return this.purchaseItemConverter;
    }
    public void setPurchaseItemConverter(PurchaseItemConverter purchaseItemConverter ){
        this.purchaseItemConverter = purchaseItemConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isPurchaseState(){
        return this.purchaseState;
    }
    public void  setPurchaseState(boolean purchaseState){
        this.purchaseState = purchaseState;
    }
    public boolean  isPurchaseItems(){
        return this.purchaseItems ;
    }
    public void  setPurchaseItems(boolean purchaseItems ){
        this.purchaseItems  = purchaseItems ;
    }
    public boolean  isPurchaseTags(){
        return this.purchaseTags ;
    }
    public void  setPurchaseTags(boolean purchaseTags ){
        this.purchaseTags  = purchaseTags ;
    }
}
