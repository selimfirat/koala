var map;
var bilkent = {lat: 39.876870, lng: 30.309906005859375};

var init = function () {
    $(document).ready(function () {
        initMap();
        initUtils();
        initSearch();
        initMarkers();
        initGeolocation();
        initStyles();
        initDesign();

        setStyle("night");

        addMarker(bilkent);

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
