package  ma.zs.stocky.ws.converter.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.crm.ClientCategoryConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.crm.Client;
import ma.zs.stocky.ws.dto.crm.ClientDto;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDto> {

    @Autowired
    private ClientCategoryConverter clientCategoryConverter ;
    private boolean clientCategory;

    public  ClientConverter() {
        super(Client.class, ClientDto.class);
        init(true);
    }

    @Override
    public Client toItem(ClientDto dto) {
        if (dto == null) {
            return null;
        } else {
        Client item = new Client();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getFullName()))
                item.setFullName(dto.getFullName());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(this.clientCategory && dto.getClientCategory()!=null)
                item.setClientCategory(clientCategoryConverter.toItem(dto.getClientCategory())) ;




        return item;
        }
    }

    @Override
    public ClientDto toDto(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientDto dto = new ClientDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getFullName()))
                dto.setFullName(item.getFullName());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(this.clientCategory && item.getClientCategory()!=null) {
                dto.setClientCategory(clientCategoryConverter.toDto(item.getClientCategory())) ;

            }


        return dto;
        }
    }

    public void copy(ClientDto dto, Client t) {
    super.copy(dto, t);
    if (dto.getClientCategory() != null)
        clientCategoryConverter.copy(dto.getClientCategory(), t.getClientCategory());
    }



    public void initObject(boolean value) {
        this.clientCategory = value;
    }


    public ClientCategoryConverter getClientCategoryConverter(){
        return this.clientCategoryConverter;
    }
    public void setClientCategoryConverter(ClientCategoryConverter clientCategoryConverter ){
        this.clientCategoryConverter = clientCategoryConverter;
    }
    public boolean  isClientCategory(){
        return this.clientCategory;
    }
    public void  setClientCategory(boolean clientCategory){
        this.clientCategory = clientCategory;
    }
}
