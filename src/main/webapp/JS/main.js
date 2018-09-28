function getListOuvrageAjax() {
    var url = "listOuvrageAjax";
    jQuery.post(
        url,
        function (data) {
            var $listOuvrage = jQuery("#listOuvrage");
            $listOuvrage.empty();
            jQuery.each(data, function (key, val) {
                $listOuvrage.append(
                    jQuery("<li>")
                        .append(val.nomOuvrage)
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