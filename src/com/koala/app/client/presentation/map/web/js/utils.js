var initUtils = function () {

};

var setMapCenter = function (lat, lng) {
    var pos = new google.maps.LatLng(lat, lng);
    map.setCenter(pos);
};