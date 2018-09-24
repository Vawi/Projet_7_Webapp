<%--
  Created by IntelliJ IDEA.
  User: v.w
  Date: 22/09/2018
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <nav class="navbar navbar-dark bg-primary">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li> <a href="index.action">Accueil</a> </li>
                    <li> <a href="topo_list.action">Liste de topo</a> </li>
                    <li> <a href="topo_new.action"> Créer un nouveau topo </a> </li>
                </ul>
                <s:if test="#session.check == 'true'">
                    <span>Vous etes connecté <s:property value="#session.user.prenom"/> </span>
                    <br />
                    <s:a action="logout" theme="simple">
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
</html>
