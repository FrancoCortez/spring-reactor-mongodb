//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 02:15:11 PM CLST 
//


package cl.proyecto.intranet.model.soap.domain.type_user;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="typeUserInfo" type="{http://www.sermaluc.cl/intranet/model/soap/domain/type-user}typeUserInfo"/&gt;
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
@XmlRootElement(name = "getTypeUserForIdResponse")
public class GetTypeUserForIdResponse {

    @XmlElement(required = true)
    protected TypeUserInfo typeUserInfo;

    /**
     * Obtiene el valor de la propiedad typeUserInfo.
     *
     * @return possible object is
     * {@link TypeUserInfo }
     */
    public TypeUserInfo getTypeUserInfo() {
        return typeUserInfo;
    }

    /**
     * Define el valor de la propiedad typeUserInfo.
     *
     * @param value allowed object is
     *              {@link TypeUserInfo }
     */
    public void setTypeUserInfo(TypeUserInfo value) {
        this.typeUserInfo = value;
    }

}
