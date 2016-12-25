var map;
var app;
var init = function () {
    $(document).ready(function () {
        try {
            initMap();
            initUtils();
            initSearch();
            initMarkers();
            initGeolocation();
            initStyles();
            initDesign();

            setStyle("night");

            addHouseMapMarker({"id":"585d9f418fa3f829cc6ee5e7","seller":{"id":"58570e2b8fa3f829cc6edb63","fullName":"dsaasddsa","password":"3dc231ebed3a7acc761a0df580608897","email":"dasa@asdads.com","username":"mrsfy__","phoneNumber":""},"houseType":"FOR_SALE","location":{"longitude":32.766380310058594,"latitude":39.85520154639845},"houseFeatures":{"comments":null,"currentFloor":4,"totalFloor":4,"bathroomNumber":2,"furnished":true,"price":12321,"size":123,"ageOfBuilding":3,"roomNumber":1,"title":"asdas","age":3,"furnishedInfo":true}});
        } catch (err) {
            if (app)
                app.error(err.message)
            else
                console.log(err.message)
        }
    });
};

var initMap = function () {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: { lat: 0, lng: 0 },
        mapTypeControl: true,
        mapTypeControlOptions: {
            style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
            position: google.maps.ControlPosition.RIGHT_TOP
        },
        zoomControl: true,
        zoomControlOptions: {
            position: google.maps.ControlPosition.LEFT_BOTTOM
        },
        scaleControl: true,
        streetViewControl: true,
        streetViewControlOptions: {
            position: google.maps.ControlPosition.LEFT_BOTTOM
        },
        fullscreenControl: false,
        fullscreenControlOptions: {
            position: google.maps.ControlPosition.LEFT_BOTTOM
        }
    });

    google.maps.event.addListener(map, 'bounds_changed', function () {
        var sw = map.getBounds().getSouthWest();
        var ne = map.getBounds().getNorthEast();
        var center = map.getCenter();
        if (app)
            app.handle(sw.lat(), sw.lng(), ne.lat(), ne.lng(), center.lat(), center.lng());
    });
};
