var initDesign = function () {
    $('.modal').modal();


    var sellHouseNotify = document.getElementById("sell-house-notify");

    map.controls[google.maps.ControlPosition.BOTTOM_CENTER].push(sellHouseNotify);

};
var initSellHouseProcess = function () {
    $("#sell-house-notify").show();
    listener = map.addListener("click",function (e) {
        $("#sell-house-notify").hide();
        app.handleSellHouseLocation(e.latLng.lat(), e.latLng.lng());
        listener.remove();
    });
};