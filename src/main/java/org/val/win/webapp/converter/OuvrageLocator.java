package org.val.win.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.exception.NotFoundException_Exception;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Map;

public class OuvrageLocator extends StrutsTypeConverter {

    private static final QName SERVICE_NAME = new QName("http://impl.service.win.val.org/", "P7ServiceImplService");
    URL wsdlURL = P7ServiceImplService.WSDL_LOCATION;
    P7ServiceImplService ss = new P7ServiceImplService(wsdlURL, SERVICE_NAME);
    P7Service port = ss.getP7ServiceImplPort();

    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            : port.getOuvrage(new Integer(vValue));
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant de l'ouvrage invalide", pEx);
                } catch (NotFoundException_Exception pEx) {
                    throw new TypeConversionException("Ouvrage Introuvable", pEx);
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }
        return vRetour;
    }

    @Override
    public String convertToString(Map pContext, Object pObject) {
        String vString;
        if (pObject instanceof Ouvrage) {
            Ouvrage vOuvrage = (Ouvrage) pObject;
            vString
                    = vOuvrage.getIdOuvrage() != null
                    ? vOuvrage.getIdOuvrage().toString()
                    : "";
        } else {
            vString = "";
        }
        return vString;
    }

}
