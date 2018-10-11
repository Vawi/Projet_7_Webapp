<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css"/>
</head>

<body>
<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
            <h5> Pour voir ne voir que les ouvrages disponibles, cliquez ici :
                <a href="<s:url namespace="/" action="listOuvrageDispo"></s:url>">
                    <button type="button" class="btn btn-info"> <span> Ouvrage dispo </span></button>
                </a>
            </h5>
            <br/>
            <h5> Pouvoir voir l'intégralité des ouvrages de la bibliotheque, cliquez ici :
                <a href="<s:url namespace="/" action="listOuvrage"></s:url>">
                    <button type="button" class="btn btn-info"> <span> Ouvrage </span></button>
                </a>
            </h5>
            <br/>
            <table id="listOuvrage" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Nom de l'ouvrage</th>
                    <th>Auteur</th>
                    <th>Nombre disponible</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="listOuvrage">
                    <tr>
                        <td><s:property value ="nomOuvrage" /></td>
                        <td><s:property value ="auteur" /></td>
                        <td><s:property value ="nombreDispo" /></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>

</body>

<script>
    $(document).ready(function() {
        $('#listOuvrage').DataTable( {
                "language": {
                    "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json" }
            }
        );
    });
</script>
<script src="${pageContext.request.contextPath}/JS/main.js"></script>
<script src=" https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<link href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css" rel="stylesheet" />

</html>
