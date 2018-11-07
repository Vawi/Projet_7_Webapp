package org.val.win.webapp.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.helper.CompareDate;
import org.val.win.model.bean.Emprunt;
import org.val.win.model.bean.Ouvrage;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.net.URL;
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


    private Utilisateur utilisateur;

    private Ouvrage ouvrage;

    private Emprunt emprunt;

    private Integer idUtilisateur;

    private Integer idOuvrage;

    private Integer idEmprunt;

    private XMLGregorianCalendar dateDebut;

    private XMLGregorianCalendar dateFin;

    private String etat;


    // ----- Eléments en sortie

    private List<Emprunt> listEmpruntUtil;

    private List<Ouvrage> listOuvrage;


    // ==================== Getters/Setters ====================

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

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

    public XMLGregorianCalendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(XMLGregorianCalendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public XMLGregorianCalendar getDateFin() {
        return dateFin;
    }

    public void setDateFin(XMLGregorianCalendar dateFin) {
        this.dateFin = dateFin;
    }

    // ==================== Méthodes ====================


    /**
     * Action récupérant une liste d'ouvrage
     * @return success
     */
    public String doListOuvrage() {
        utilisateur = (Utilisateur) session.get("user");
        if (utilisateur.getPrenom() == null ){
            utilisateur.setPrenom("anonymous");
        }
        listOuvrage = port.getListOuvrage(utilisateur).getItem();
        return ActionSupport.SUCCESS;
    }

    /**
     * Action récupérant une liste d'ouvrage disponible
     * @return success
     */
    public String doListOuvrageDispo() {
        utilisateur = (Utilisateur) session.get("user");
        if (utilisateur == null) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setPrenom("anonymous");
        }
        listOuvrage = port.getListDispo(utilisateur).getItem();
        return ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de prolonger un emprunt
     * @return success ou login
     */
    public String prolongerEmprunt() {
        Emprunt pEmprunt = new Emprunt();
        pEmprunt.setIdEmprunt(idEmprunt);
        utilisateur = (Utilisateur) session.get("user");
        if(session.get("user") == null){
            return ActionSupport.LOGIN; }
        else {
            String vResult = Action.INPUT;
            if (!this.hasErrors()) {
                port.prolongationEmprunt(pEmprunt, utilisateur);
                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("Emprunt prolongé avec succes");
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
        listOuvrage = port.getListOuvrage(utilisateur).getItem();
        for(Emprunt emprunt:listEmpruntUtil){
            emprunt.setProlongeable(CompareDate.compareDate(emprunt.getDateDebut(), emprunt.getDateFin()));
            System.out.println(emprunt.getProlongeable());
            for(Ouvrage ouvrage:listOuvrage){
                if(emprunt.getIdOuvrage() == ouvrage.getIdOuvrage()){
                    emprunt.setNomOuvrage(ouvrage.getNomOuvrage());
                }
            }
        }
        return ActionSupport.SUCCESS;
    }

}
