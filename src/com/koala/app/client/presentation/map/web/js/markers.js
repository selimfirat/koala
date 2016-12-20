var markerClusterer;

var addMarker = function (location, house) {

    var marker = new google.maps.Marker({
        position: location
    });

    marker.addListener("click", function () {

        if (house) {
            $("#house-seller").text(house.seller);
            $("#house-title").text(house.title);
            $("#house-comment").text(house.comment);
        }

        $("#house-details").modal("open");

    });

    return markerClusterer.addMarker(marker);
};


var initMarkers = function () {
    initMarkersClusterer();

};

var initMarkersClusterer = function () {
    markerClusterer = new MarkerClusterer(map, [],
        { imagePath: 'images/clusters/m' });
    markerClusterer.setMaxZoom(20);
};