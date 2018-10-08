function getListOuvrageAjax() {
    // URL de l'action AJAX
    var url = "listOuvrageAjax";
    // Action AJAX en POST
    jQuery.post(
        url,
        function (data) {
            var $listOuvrage = jQuery("#listOuvrage");
            $listOuvrage.empty();
            jQuery.each(data, function (key, val) {
                $listOuvrage.append(
                    jQuery("<li class=\"list-group-item\">")
                        .append("<p> Nom de l'ouvrage : " + val.nomOuvrage + "<br /> </p>")
                        .append("<p> Auteur : " + val.auteur + "<br /> </p>")
                        .append("<p> Nombre disponible : " + val.nombreDispo + "<br /> </p>")

                );
            });
        })
        .fail(function (data) {
            if (typeof data.responseJSON === 'object') {
                console.log(data.responseJSON);
            } else {
                console.log(data);
            }
            alert("Pas d'ouvrage en ligne");
        });
}

function getListEmpruntUtilAjax() {
    var url = "listEmpruntUtilAjax";
    jQuery.post(
        url,
        function (data) {
            console.log(data);
            var $listEmpruntUtil = jQuery("#listEmpruntUtil");
            $listEmpruntUtil.empty();
            jQuery.each(data, function (key, val) {
                $listEmpruntUtil.append(
                    jQuery("<li>")
                        .append(val.dateDebut)
                        .append(val.dateFin)

                );
            });
        })
        .fail(function () {
            alert("Pas d'emprunt en cours");
        });
}

function paginationOuvrage() {

    var items;

    $http.get('listOuvrageAjax')
        .success(function(data){
            items = data;
        });
    
    var pager = {};
    pager.items = JSON.parse(items);
    pager.itemsPerPage = 3;
    pagerInit(pager);

    function bindList() {
        var pgItems = pager.pagedItems[pager.currentPage];
        $("#listOuvrage").empty();
        for(var i = 0; i < pgItems.length; i++){
            var option = $('<li class="list-group-item">');
            for( var key in pgItems[i] ){
                option.html(pgItems[i][key]);
            }
            $("#listOuvrage").append(option);
        }
    }
    function prevPage(){
        pager.prevPage();
        bindList();
    }
    function nextPage(){
        pager.nextPage();
        bindList();
    }
    function pagerInit(p) {
        p.pagedItems = [];
        p.currentPage = 0;
        if (p.itemsPerPage === undefined) {
            p.itemsPerPage = 5;
        }
        p.prevPage = function () {
            if (p.currentPage > 0) {
                p.currentPage--;
            }
        };
        p.nextPage = function () {
            if (p.currentPage < p.pagedItems.length - 1) {
                p.currentPage++;
            }
        };
        init = function () {
            for (var i = 0; i < p.items.length; i++) {
                if (i % p.itemsPerPage === 0) {
                    p.pagedItems[Math.floor(i / p.itemsPerPage)] = [p.items[i]];
                } else {
                    p.pagedItems[Math.floor(i / p.itemsPerPage)].push(p.items[i]);
                }
            }
        };
        init();
    }
    $(function() {
        bindList();
    });
}