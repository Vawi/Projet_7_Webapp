package org.val.win.webapp.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GestionWebappAction extends ActionSupport implements SessionAware {

    private static final QName SERVICE_NAME = new QName("http://impl.service.win.val.org/", "P7ServiceImplService");
    URL wsdlURL = P7ServiceImplService.WSDL_LOCATION;
    P7ServiceImplService ss = new P7ServiceImplService(wsdlURL, SERVICE_NAME);
    P7Service port = ss.getP7ServiceImplPort();

    /**
     * creer une session
     */
    private Map<String, Object> session;

    /**
     * Setteur pour la session
     * @param pSession session de l'utilisateur
     */
    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


    // ==================== Attributs ====================


    // ----- Paramètres en entrée


    /**
     * utilisateur
     */
    private Utilisateur utilisateur;

    private Ouvrage ouvrage;

    private Emprunt emprunt;

    private Integer id;

    private Integer idOuvrage;

    private Integer idEmprunt;


    // ----- Eléments en sortie

    private List<Emprunt> listEmpruntUtil;

    private List<Ouvrage> listOuvrage;


    // ==================== Getters/Setters ====================

    public Integer getIdOuvrage() {
        return idOuvrage;
    }

    public void setIdOuvrage(Integer idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public Integer getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(Integer idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public List<Ouvrage> getListOuvrage() {
        return listOuvrage;
    }

    public void setListOuvrage(List<Ouvrage> listOuvrage) {
        this.listOuvrage = listOuvrage;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Emprunt> getListEmpruntUtil() {
        return listEmpruntUtil;
    }

    public void setListEmpruntUtil(List<Emprunt> listEmpruntUtil) {
        this.listEmpruntUtil = listEmpruntUtil;
    }

    // ==================== Méthodes ====================


    public String doListOuvrage() {
        listOuvrage = port.getListOuvrage().getItem();
        return ActionSupport.SUCCESS;
    }

    public String doListOuvrageDispo() {
        listOuvrage = port.getListDispo().getItem();
        return ActionSupport.SUCCESS;
    }

    public String prolongerEmprunt() {
        emprunt.setIdEmprunt(idEmprunt);
        emprunt.setIdOuvrage(idOuvrage);
        utilisateur = (Utilisateur) session.get("user");
        if(session.get("user") == null){
            return ActionSupport.LOGIN;
        }
        else {
            String vResult = Action.INPUT;
            if (!this.hasErrors()) {
                    port.prolongationEmprunt(emprunt);
                    vResult = ActionSupport.SUCCESS;
            }
            return vResult;
        }
    }

    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetailUtilisateur() {
        utilisateur = (Utilisateur) session.get("user");
        listEmpruntUtil = port.getListEmpruntUtilisateur(utilisateur).getItem();
        listOuvrage = port.getListOuvrage().getItem();
        for(Emprunt emprunt:listEmpruntUtil){
            for(Ouvrage ouvrage:listOuvrage){
                if(emprunt.getIdOuvrage() == ouvrage.getIdOuvrage()){
                    emprunt.setNomOuvrage(ouvrage.getNomOuvrage());
                }
            }
        }
        return ActionSupport.SUCCESS;
    }
}
