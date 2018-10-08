<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%@ include file="../_include/header.jsp"%>
</head>

<body>

    <span id="user" style="display: none;"><s:property value ="#session.check" /></span>

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="col-lg-1">
                </div>
                <div class="col-lg-10">
                    <ul class="list-group" id="listOuvrage">
                        <li> </li>
                    </ul>
                    <!--
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
                    -->
                </div>
                </div>
                <div id="page_navigation"> </div>
                <div class="col-lg-1">
                </div>
            </div>
        </div>
    </div>

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>

    <script>

        getListOuvrageAjax();

        var show_per_page = 10;
        var current_page = 0;

        function set_display(first, last) {
            $('#listOuvrage').children().css('display', 'none');
            $('#listOuvrage').children().slice(first, last).css('display', 'block');
        }

        function previous(){
            if($('.active').prev('.page_link').length) go_to_page(current_page - 1);
        }

        function next(){
            if($('.active').next('.page_link').length) go_to_page(current_page + 1);
        }

        function go_to_page(page_num){
            current_page = page_num;
            start_from = current_page * show_per_page;
            end_on = start_from + show_per_page;
            set_display(start_from, end_on);
            $('.active').removeClass('active');
            $('#id' + page_num).addClass('active');
        }

        $(document).ready(function() {

            var number_of_pages = Math.ceil($('#listOuvrage').children().length / show_per_page);

            var nav = '<ul class="pagination"><li><a href="javascript:previous();">&laquo;</a>';

            var i = -1;
            while(number_of_pages > ++i){
                nav += '<li class="page_link'
                if(!i) nav += ' active';
                nav += '" id="id' + i +'">';
                nav += '<a href="javascript:go_to_page(' + i +')">'+ (i + 1) +'</a>';
            }
            nav += '<li><a href="javascript:next();">&raquo;</a></ul>';

            $('#page_navigation').html(nav);
            set_display(0, show_per_page);

        });

    </script>

</body>

</html>
