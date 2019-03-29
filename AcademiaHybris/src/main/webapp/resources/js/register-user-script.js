var afterDelete = function () {
    console.log("Passou aqui: " + ctx.contextPath + '/users');
    location.replace(ctx.contextPath + '/users');
};

var errorOnDelete = function () {
    console.log('errorOnDelete');
};

var deleteUser = function () {
    var sendRemoveUser = function () {
        var id = $("#id_user").val();

        $.ajax({
            type: "POST",
            url: ctx.contextPath + '/user/delete/' + id,
            data: {},
            success: afterDelete,
            error: errorOnDelete
        });
    };

    openDialog('#confirm-dialog', function () {
        sendRemoveUser()
    });

};

$(window).on('load', function () {
    $(".js-delete-user").bind("click", deleteUser);
});


