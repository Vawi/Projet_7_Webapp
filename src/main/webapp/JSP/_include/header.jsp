<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <meta charset="utf-8" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css"/>
</head>

<header>

    <body>
    <div class="container">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" >La Bibliotheque</a>
                </div>
                <ul class="nav navbar-nav">
                    <li> <a href="index.action">Accueil</a> </li>
                    <li> <a href="listOuvrage.action">Liste d'ouvrage</a> </li>
                    <s:if test="#session.check == 'true'">
                        <li> <a href="utilisateur_detail.action">Details et Emprunts </a> </li>
                    </s:if>
                </ul>
                <s:if test="#session.check == 'true'">
                    <s:a action="logout" class="navbar-form navbar-right inline-form" theme="simple">
                        <span> Deconnection </span>
                    </s:a>
                </s:if>
                <s:else >
                    <s:form action="login" class="navbar-form navbar-right inline-form" theme="simple">
                        <s:textfield name="login" label="Identifiant" requiredLabel="true" class="input-sm form-control" theme="simple"/>
                        <s:password name="password" label="Mot de passe" requiredLabel="true" type="password" class="input-sm form-control" theme="simple"/>
                        <s:submit value="Connexion" class="btn btn-primary btn-sm" type="submit" theme="simple"/>
                    </s:form>
                </s:else>
            </div>
        </nav>
    </div>
    </body>

</header>

<script src="${pageContext.request.contextPath}/JS/main.js"></script>

<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
</html>
