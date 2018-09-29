<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>

    <div class="container-fluid">
        <div class="row">
            <div class="col-lg">
                <ul id="listOuvrage">
                    <li >
                        <em> ouvrage </em>
                    </li>
                </ul>
            </div>
            <div class="col-lg">
                Information de la bibliotheque
            </div>
            <s:if test="#session.check == 'true'">
                <!-- Condition pour lancer la recherche d'emprunt dès que l'utilisateur se connecte -->
            </s:if>
            <div class="col-lg">
                <ul id="listEmprunt">
                    <li >
                        <em> Emprunt de l'utilisateur </em>
                    </li>
                </ul>
            </div>
        </div>
    </div>


    <script>
        $( document ).ready(function() {
            getListOuvrageAjax();
        });
        $( document ).ready(function() {
            getListEmpruntUtilAjax();
        });
    </script>

</body>

</html>
