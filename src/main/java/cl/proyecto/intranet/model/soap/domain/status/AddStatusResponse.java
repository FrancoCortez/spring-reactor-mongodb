//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 02:15:11 PM CLST 
//


package cl.proyecto.intranet.model.soap.domain.status;

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
 *         &lt;element name="serviceStatus" type="{http://www.sermaluc.cl/intranet/model/soap/domain/status}serviceStatus"/&gt;
 *         &lt;element name="statusInfo" type="{http://www.sermaluc.cl/intranet/model/soap/domain/status}statusInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "serviceStatus",
        "statusInfo"
})
@XmlRootElement(name = "addStatusResponse")
public class AddStatusResponse {

    @XmlElement(required = true)
    protected ServiceStatus serviceStatus;
    @XmlElement(required = true)
    protected StatusInfo statusInfo;

    /**
     * Obtiene el valor de la propiedad serviceStatus.
     *
     * @return possible object is
     * {@link ServiceStatus }
     */
    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Define el valor de la propiedad serviceStatus.
     *
     * @param value allowed object is
     *              {@link ServiceStatus }
     */
    public void setServiceStatus(ServiceStatus value) {
        this.serviceStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad statusInfo.
     *
     * @return possible object is
     * {@link StatusInfo }
     */
    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    /**
     * Define el valor de la propiedad statusInfo.
     *
     * @param value allowed object is
     *              {@link StatusInfo }
     */
    public void setStatusInfo(StatusInfo value) {
        this.statusInfo = value;
    }

}
