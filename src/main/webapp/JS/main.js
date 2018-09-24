function getListOuvrage() {
    // URL de l'action AJAX
    var url = "listOuvrage";
    // Action AJAX en POST
    jQuery.post(
        url,
        function (data) {
            var $selectOuvrage = jQuery("#selectOuvrage");
            $selectOuvrage.empty();
            console.log(data);
            jQuery.each(data, function (key, val) {
                $selectOuvrage.append(
                    jQuery("<option>")
                        .text(val.nomOuvrage)
                        .text(val.auteur)
                        .val(val.idOuvrage)
                );
            });
        })
        .fail(function (data) {
            if (typeof data.responseJSON === 'object') {
                console.log(data.responseJSON);
            } else {
                console.log(data);
            }
            alert("Oh zut, la bibliothèque n'a pas d'ouvrage");
        });
}