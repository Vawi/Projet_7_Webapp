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
            alert("Pas de commentaire");
        });
}