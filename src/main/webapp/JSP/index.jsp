<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-sm">
                <ul id="listOuvrage">
                    <li >
                        <em> ouvrage </em>
                    </li>
                </ul>
            </div>
            <div class="col-sm">
                Emprunt de la bibliotheque
            </div>
            <div class="col-sm">
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
