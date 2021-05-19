$(window).load(function () {

    $("#reviewBtn").click(function () {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");
        let content = $("#reviewInput").val();
        if (!content || content === '') {
            alert("내용이 하나라도 있어야 합니다.");
            return false;
        }
        let data = {
            'content': content,
            'heritageId': $("#heritageInput").val()
        };
        $.ajax({
            url: '/saveReview',
            method: "POST",
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8;',
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (res) {
                if (res.msg) {
                    alert("로그인을 먼저 해주세요.");
                    return false;
                }
                $("#reviewBody").empty();
                let html = '';
                [].forEach.call(res.list, heritage => {
                    html += `
                        <div>
                            <span>작성자 : ${heritage.writer}</span>
                            <span style="font-size: 16px; margin-left: 30px;">${heritage.created_at}</span><br>
                            <span>내용 : ${heritage.content}</span>
                        </div>
                    `;
                });
                $("#reviewBody").append(html);
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    });

});