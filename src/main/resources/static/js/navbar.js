$(window).load(function () {
    $("#searchBtn").click(function () {
        let value = $("#searchInput").val();
        window.location.href = "/search?val="+value;
    });

});

function enterSearch() {
    if (event.keyCode === 13) {
        $("#searchBtn").trigger('click');
    }
}