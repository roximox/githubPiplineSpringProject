package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.Tag;
import ma.zs.stocky.ws.dto.commun.TagDto;

@Component
public class TagConverter extends AbstractConverter<Tag, TagDto> {


    public  TagConverter() {
        super(Tag.class, TagDto.class);
    }

    @Override
    public Tag toItem(TagDto dto) {
        if (dto == null) {
            return null;
        } else {
        Tag item = new Tag();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());



        return item;
        }
    }

    @Override
    public TagDto toDto(Tag item) {
        if (item == null) {
            return null;
        } else {
            TagDto dto = new TagDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
