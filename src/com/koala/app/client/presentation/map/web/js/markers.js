var houseClusterer;

var createMarker = function (location) {

    var marker = new google.maps.Marker({
        position: location
    });

    return marker;
};

var currentHouse;

var addHouseMapMarker = function (house) {

    var marker = createMarker({
        lat: house.location.latitude,
        lng: house.location.longitude
    });

    marker.addListener("click", function () {


        $("#house-details").modal("open");
        currentHouse = house;

        for (key in house.houseFeatures) {
            var val = house.houseFeatures[key];

            if (houseOptions[key])
                $("#house-details ." + key).text(houseOptions[key][val]);
            else
                $("#house-details ." + key).html(val);
        }

        app.error(JSON.stringify(house.seller));
        app.error(JSON.stringify(house.houseFeatures));

        $(".isFurnished").text(house.houseFeatures.furnished ? "Yes" : "No");
        app.error(JSON.stringify(house.houseFeatures));

        ["fullName", "phoneNumber", "email"].forEach(function (el) {
            app.error(el);
            app.error(house.seller[el]);
            $("#house-details").find("." + el).text(house.seller[el]);
        });



    });

    houseClusterer.addMarker(marker);

    return marker;

};

var removeAllMarkers = function () {
    houseClusterer.clearMarkers();
};

var initMarkers = function () {
    initMarkersClusterer();

};

var initMarkersClusterer = function () {
    houseClusterer = new MarkerClusterer(map, [],
        { imagePath: 'images/clusters/m' });
    houseClusterer.setMaxZoom(20);
};