<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%@ include file="../_include/header.jsp"%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css"/>
    <style type="text/css">
        body { background-color:#DDD; }
        a:focus { outline:0; }
    </style>
</head>

<body>

    <span id="user" style="display: none;"><s:property value ="#session.check" /></span>

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-1">
                </div>
                <div class="col-lg-10">
                    <ul id="listOuvrage" class="list-group"></ul>
                    <ul class="pager">
                        <li class="previous"><a href="" onclick="prevPage(); return false;">«</a></li>
                        <li class="next"><a href="" onclick="nextPage(); return false;">»</a></li>
                    </ul>
                    <!--
                    <table id="listOuvrage" class="display" style="width:100%">
                        <thead>
                        <tr>
                            <th>Nom de l'ouvrage</th>
                            <th>auteur</th>
                            <th>nombre disponible</th>
                        </tr>
                        </thead>
                    </table>
                    -->
                </div>
                </div>
                <div id="page_navigation"> </div>
                <div class="col-lg-1">
                </div>
            </div>
        </div>
    </div>

</body>

<!--
<script src=" https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
-->


<script>
    $( document ).ready(function() {
        paginationOuvrage()
    })
</script>


</html>
