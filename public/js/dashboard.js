$(document).ready(
    function () {
        $.getJSON("/ops/serviceInfo", function (serviceInfo) {
            $('#info').html('<h1>' + serviceInfo.info + '</h1>');
            $('#systemInfo').html(
                '<h1>Hostname = ' + serviceInfo.hostname + ', IP = '
                + serviceInfo.ip + '<h1>');
            $('#timeInfo').html(
                '<pre>Start Time = '
                + new Date(serviceInfo.startTimeMillis)
                    .toLocaleString() + ',	Refesh Time = '
                + new Date().toLocaleString() + '</pre>');
        });
    });