<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>

<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-2">
            <legend> Detail de l'utilisateur : </legend>
            <br />
            <br />
            <div class="description">
                <ul>
                    <li>Nom : <s:property value="#session.user.nom" /></li>
                    <br />
                    <li>Prénom : <s:property value="#session.user.prenom" /></li>
                    <br />
                    <li>Mail : <s:property value="#session.user.mail" /></li>
                    <br />
                    <li>Pseudonyme : <s:property value = "#session.user.pseudonyme" /></li>
                </ul>
            </div>
        </div>
        <div class="col-lg-6">
            <legend> Emprunt de l'utilisateur : </legend>
            <table id="listEmpruntUtil" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Nom de l'ouvrage</th>
                    <th>date du début de l'emprunt</th>
                    <th>date de fin de l'emprunt</th>
                    <th>Etat de l'emprunt</th>
                    <th>Prolongation</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="listEmpruntUtil">
                    <span id="spanIdOuvrage" style="display: none;"><s:property value ="listEmpruntUtil.IdOuvrage" /></span>
                    <tr>
                        <td><s:property value ="nomOuvrage" /></td>
                        <td><s:property value ="dateDebut" /></td>
                        <td><s:property value ="dateFin" /></td>
                        <td><s:property value ="etat"/></td>
                        <s:if test="prolongeable">
                            <td><s:a action="prolongerEmprunt">
                                <s:param name="idEmprunt" value="%{idEmprunt}" />
                                <button type="button" class="btn btn-info"> <span class="glyphicon glyphicon-ok"></span></button>
                            </s:a></td>
                        </s:if>
                        <s:else>
                            <td>
                                <span class="glyphicon glyphicon-remove"></span>
                            </td>
                        </s:else>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
</div>

<br/>
<br/>

</body>
<script>
    $(document).ready(function() {
        $('#listEmpruntUtil').DataTable( {
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