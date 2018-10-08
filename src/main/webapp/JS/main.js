function getListOuvrageAjax() {
    // URL de l'action AJAX
    var url = "listOuvrageAjax";
    // Action AJAX en POST
    jQuery.post(
        url,
        function (data) {
            var $listOuvrage = jQuery("#listOuvrage");
            $listOuvrage.empty();
            console.log(data);
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