<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="_include/header.jsp"%>
</head>

<body>

    <ul id="listOuvrage">
        <li >
            <em> ouvrage </em>
        </li>
    </ul>


    <script>
        $( document ).ready(function() {
            getListOuvrageAjax();
        });
    </script>

</body>

</html>
