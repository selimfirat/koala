var ownHouses;
var openMyOwnProperties = function (houses) {

    $("#my-own-properties").modal("open");
    ownHouses = houses;

    var item = $(".own-property-item:last").clone().wrap("<li class='collection-item own-property-item'></li>");
    $(".own-property-item").remove();

    app.error(item.html());

    for(var i = 0; i < houses.length; i++) {
        var house = houses[i];

        $("#my-own-properties ul").append(item);
        $(".own-property-item:last .title").text(house.houseFeatures.title);
        $(".own-property-item:last .edit").attr("data-index", i);
        $(".own-property-item:last .remove").attr("data-index", i);

        item = item.clone().wrap("<li class='collection-item own-property-item'></li>");
    }

    $("#my-own-properties .edit").click(function () {
        var index = $(this).attr("data-index");

        if (app)
            app.editHouse(JSON.stringify(ownHouses[index]));

        $("#my-own-properties").modal("close");
    });

    $("#my-own-properties .remove").click(function () {
        var index = $(this).attr("data-index");

        if (app)
            app.removeHouse(ownHouses[index].id);

        $("#my-own-properties").modal("close");
    });


};