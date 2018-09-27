<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <meta charset="utf-8" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css"/>
    <link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="col-lg-12">
            <nav class="navbar navbar-dark bg-primary">
                <div class="container-fluid">
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
    </div>

    <script src="${pageContext.request.contextPath}/JS/main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</body>
</html>
