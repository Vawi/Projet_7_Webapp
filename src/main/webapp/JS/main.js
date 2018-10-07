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