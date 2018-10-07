<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../_include/header.jsp"%>
</head>

<body>

    <span id="user" style="display: none;"><s:property value ="#session.check" /></span>

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-3">
                </div>
                <div class="col-lg-6">
                    <table id="listOuvrage" class="display" style="width:100%">
                        <thead>
                        <tr>
                            <th>auteur</th>
                            <th>idOuvrage</th>
                            <th>nomOuvrage</th>
                            <th>nombreDispo</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                <div class="col-lg-3">
                </div>
            </div>
        </div>
    </div>

</body>

<script>
    $(document).ready(function() {
        $('#listOuvrage').DataTable( {
            "sAjaxSource": "listOuvrageAjax.action",
            "bProcessing": true,
            "sPaginationType": "full_numbers",
            "bJQueryUI": true
        } );
    } );
</script>

<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src=" https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"></script>

</html>
