
$("#getAccount").click(onSubmit);

function onSubmit() {
    $(".hidden").show();
    $.ajax({
        url: "/getData?" + "ip="+ $("#ip").val()+ "&dbuser="+ $("#dbuser").val()+ "&dbpass="+ $("#dbpass").val(),
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        error: function (message) {
            $("#result").empty();
            var name = "UNKNOWN ERROR"
            try {
                name = message.responseJSON.message;
            }
            catch(err) {
                //nothing
            }
            $("#result").append("<li><span class='label label-danger'> Invalid data: </span><span>"+name.substring(name.indexOf(":")+1)+"</span></li>");
        },
        success: function (data) {

            var $result = $("#result");
            $result.empty();


            data.accounts.forEach(function (account) {
                var myclass = "label label-success";

                $result.append("<li><span>" + account.phone + "</span><span> " + account.name+ "</span></li>");


            })
        }
    });
}

