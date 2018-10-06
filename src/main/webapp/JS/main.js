function getListOuvrageAjax() {
    var url = "listOuvrageAjax";
    jQuery.post(
        url,
        function (data) {
            console.log(data);
            var $listOuvrage = jQuery("#listOuvrage");
            $listOuvrage.empty();
            jQuery.each(data, function (key, val) {
                $listOuvrage.append(
                    jQuery("<th>")
                        .append(val.nomOuvrage)
                        .append(val.auteur)
                        .append(val.nombreDispo)
                );
            });
        })
        .fail(function () {
            alert("Pas d'ouvrage");
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