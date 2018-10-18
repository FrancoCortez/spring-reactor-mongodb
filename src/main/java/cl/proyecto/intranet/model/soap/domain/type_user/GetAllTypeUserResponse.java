//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 02:15:11 PM CLST 
//


package cl.proyecto.intranet.model.soap.domain.type_user;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="typeUserInfo" type="{http://www.sermaluc.cl/intranet/model/soap/domain/type-user}typeUserInfo" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "typeUserInfo"
})
@XmlRootElement(name = "getAllTypeUserResponse")
public class GetAllTypeUserResponse {

    @XmlElement(required = true)
    protected List<TypeUserInfo> typeUserInfo;

    /**
     * Gets the value of the typeUserInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeUserInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeUserInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeUserInfo }
     */
    public List<TypeUserInfo> getTypeUserInfo() {
        if (typeUserInfo == null) {
            typeUserInfo = new ArrayList<TypeUserInfo>();
        }
        return this.typeUserInfo;
    }

}
