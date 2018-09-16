package org.val.win.service;

import org.val.win.model.bean.Utilisateur;
import org.val.win.model.bean.*;
import org.val.win.model.exception.NotFoundException_Exception;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-09-16T14:32:20.248+02:00
 * Generated source version: 3.2.6
 *
 */
@WebService(targetNamespace = "http://contract.service.win.val.org/", name = "P7Service")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface P7Service {

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/retardEmpruntRequest", output = "http://contract.service.win.val.org/P7Service/retardEmpruntResponse")
    public void retardEmprunt(
        @WebParam(partName = "arg0", name = "arg0")
                Emprunt arg0
    );

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/getListDispoRequest", output = "http://contract.service.win.val.org/P7Service/getListDispoResponse")
    @WebResult(name = "return", targetNamespace = "http://contract.service.win.val.org/", partName = "return")
    public OuvrageArray getListDispo();

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/getListEmpruntRequest", output = "http://contract.service.win.val.org/P7Service/getListEmpruntResponse")
    @WebResult(name = "return", targetNamespace = "http://contract.service.win.val.org/", partName = "return")
    public EmpruntArray getListEmprunt();

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/utilisateurLoginRequest", output = "http://contract.service.win.val.org/P7Service/utilisateurLoginResponse")
    @WebResult(name = "return", targetNamespace = "http://contract.service.win.val.org/", partName = "return")
    public Utilisateur utilisateurLogin(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/getOuvrageRequest", output = "http://contract.service.win.val.org/P7Service/getOuvrageResponse", fault = {@FaultAction(className = NotFoundException_Exception.class, value = "http://contract.service.win.val.org/P7Service/getOuvrage/Fault/NotFoundException")})
    @WebResult(name = "return", targetNamespace = "http://contract.service.win.val.org/", partName = "return")
    public Ouvrage getOuvrage(
        @WebParam(partName = "arg0", name = "arg0")
        int arg0
    ) throws NotFoundException_Exception;

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/empruntRequest", output = "http://contract.service.win.val.org/P7Service/empruntResponse", fault = {@FaultAction(className = NotFoundException_Exception.class, value = "http://contract.service.win.val.org/P7Service/emprunt/Fault/NotFoundException")})
    public void emprunt(
        @WebParam(partName = "arg0", name = "arg0")
        Emprunt arg0,
        @WebParam(partName = "arg1", name = "arg1")
        Utilisateur arg1,
        @WebParam(partName = "arg2", name = "arg2")
        Ouvrage arg2
    ) throws NotFoundException_Exception;

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/getListEmpruntUtilisateurRequest", output = "http://contract.service.win.val.org/P7Service/getListEmpruntUtilisateurResponse")
    @WebResult(name = "return", targetNamespace = "http://contract.service.win.val.org/", partName = "return")
    public EmpruntArray getListEmpruntUtilisateur(
        @WebParam(partName = "arg0", name = "arg0")
        Utilisateur arg0
    );

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/getListOuvrageRequest", output = "http://contract.service.win.val.org/P7Service/getListOuvrageResponse")
    @WebResult(name = "return", targetNamespace = "http://contract.service.win.val.org/", partName = "return")
    public OuvrageArray getListOuvrage();

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/prolongationEmpruntRequest", output = "http://contract.service.win.val.org/P7Service/prolongationEmpruntResponse")
    public void prolongationEmprunt(
        @WebParam(partName = "arg0", name = "arg0")
        Emprunt arg0
    );

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/fermerEmpruntRequest", output = "http://contract.service.win.val.org/P7Service/fermerEmpruntResponse", fault = {@FaultAction(className = NotFoundException_Exception.class, value = "http://contract.service.win.val.org/P7Service/fermerEmprunt/Fault/NotFoundException")})
    public void fermerEmprunt(
        @WebParam(partName = "arg0", name = "arg0")
        Emprunt arg0
    ) throws NotFoundException_Exception;

    @WebMethod
    @Action(input = "http://contract.service.win.val.org/P7Service/getUtilisateurRequest", output = "http://contract.service.win.val.org/P7Service/getUtilisateurResponse")
    @WebResult(name = "return", targetNamespace = "http://contract.service.win.val.org/", partName = "return")
    public Utilisateur getUtilisateur(
        @WebParam(partName = "arg0", name = "arg0")
        int arg0
    );
}
