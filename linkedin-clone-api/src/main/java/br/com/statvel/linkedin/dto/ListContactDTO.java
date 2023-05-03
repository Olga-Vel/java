package br.com.statvel.linkedin.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListContactDTO {
    private List<ContactDTO> lista;

    public ListContactDTO() {
        lista=new ArrayList<ContactDTO>();
    }

    public List<ContactDTO> getLista() {
        return lista;
    }

    public void setLista(List<ContactDTO> lista) {
        this.lista = lista;
    }
    
}
