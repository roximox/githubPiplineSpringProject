package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.PurchaseState;
import ma.zs.stocky.ws.dto.commun.PurchaseStateDto;

@Component
public class PurchaseStateConverter extends AbstractConverter<PurchaseState, PurchaseStateDto> {


    public  PurchaseStateConverter() {
        super(PurchaseState.class, PurchaseStateDto.class);
    }

    @Override
    public PurchaseState toItem(PurchaseStateDto dto) {
        if (dto == null) {
            return null;
        } else {
        PurchaseState item = new PurchaseState();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public PurchaseStateDto toDto(PurchaseState item) {
        if (item == null) {
            return null;
        } else {
            PurchaseStateDto dto = new PurchaseStateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
