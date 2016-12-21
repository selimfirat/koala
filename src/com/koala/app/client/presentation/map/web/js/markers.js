var houseClusterer;


var createMarker = function (location) {

    var marker = new google.maps.Marker({
        position: location
    });


    return marker;
};

var addHouseMapMarker = function (house) {

    var marker = createMarker({
        lat: house.location.latitude,
        lng: house.location.longitude
    });

    marker.addListener("click", function () {

        if (house) {
            $("#house-seller").text(house.seller);
            $("#house-title").text(house.title);
            $("#house-comment").text(house.comment);
        }

        $("#house-details").modal("open");

    });

    houseClusterer.addMarker(marker);

    return marker;

};

var removeAllMarkers = function () {
    houseClusterer.clearMarkers();
}

var initMarkers = function () {
    initMarkersClusterer();

};

var initMarkersClusterer = function () {
    houseClusterer = new MarkerClusterer(map, [],
        { imagePath: 'images/clusters/m' });
    houseClusterer.setMaxZoom(20);
};