package org.val.win.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.val.win.helper.Sha2;
import org.val.win.model.bean.Utilisateur;
import org.val.win.service.P7Service;
import org.val.win.service.P7ServiceImplService;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Map;

public class GestionLoginAction extends ActionSupport implements SessionAware {

    /**
     * Connection au webservice
     */
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
     * login de l'utilisateur
     */
    private String login;
    /**
     * mot de passe de l'utilisateur
     */
    private String password;
    /**
     * Objet Utilisateur
     */
    private Utilisateur utilisateur;


    // ==================== Getters/Setters ====================

    /**
     * Recuperer le login
     * @return le login
     */
    public String getLogin() {
        return login;
    }

    /**
     * modifier le login
     * @param pLogin le nouveau login
     */
    public void setLogin(String pLogin) {
        login = pLogin;
    }

    /**
     * recuperer le mot de passe
     * @return le mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * modifier le mot de passe
     * @param pPassword le nouveau mot de passe
     */
    public void setPassword(String pPassword) {
        password = pPassword;
    }

    /**
     * Recuperer un utilisateur
     * @return un utilisateur
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Recuperer la session de l'tuilisateur
     * @return
     */
    public Map<String, Object> getSession(){
        return session;
    }

    // ==================== Méthodes ====================

    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     **/
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
            String passwordSha = Sha2.getSHA512(password);

            try {
                utilisateur = port.utilisateurLogin(login, passwordSha);
                // Ajout de l'utilisateur en session
                this.session.put("user", utilisateur);
                this.session.put("idUtilisateur", utilisateur.getIdUtilisateur());
                this.session.put("pseudonyme", utilisateur.getPseudonyme());
                this.session.put("check", "true");
                this.addActionMessage("Vous etes bien connecté");
                vResult = ActionSupport.SUCCESS;
            } catch (Exception pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }


    /**
     * Action de déconnexion d'un utilisateur
     * @return success
     **/
    public String doLogout() {
        // Suppression de l'utilisateur en session
        this.session.remove("user");
        this.session.remove("check");
        return ActionSupport.SUCCESS;
    }

}
