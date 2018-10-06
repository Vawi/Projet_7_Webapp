<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>

    <span id="user" style="display: none;"><s:property value ="#session.check" /></span>

    <div class="container-fluid">
        <div class="row">
            <div class="col-lg">
                <table id="listOuvrage" class="display" style="width:100%">
                    <thead>
                    <tr>
                        <th>nomOuvrage</th>
                        <th>auteur</th>
                        <th>nombreDispo</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="col-lg">
                Information de la bibliotheque
            </div>
        </div>
    </div>


    <script>
        $(document).ready(function() {
            $('#listOuvrage').DataTable( {
                "bServerSide": true,
                "sAjaxSource": "listOuvrageAjax.action",
                "bProcessing": true,
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            } );
        } );
    </script>

</body>

<script src=" https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet" />

</html>
