var styles = { };
var initStyles = function () {

};

var setStyle = function (style) {
    map.setOptions({
        styles: styles[style]
    });
};