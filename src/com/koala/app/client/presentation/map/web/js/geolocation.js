
var initGeolocation = function () {

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            map.setCenter(pos);
        }, function() {
            console.log("Geolocation service failed!");
        });
    } else {
        console.log("Browser's geolocation is not enabled!");
    }

};
