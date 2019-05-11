function fetchAll() {
    $.get('/posts', function (data) {

    });
}

function alertMessage(location, message, errorClass) {
    $(location).html(message);
    $(location).show();
    setTimeout(function() {
        $(location).hide(100);
    }, 3000);
}

function initCreateOrUpdatePost(e) {

    $(document).on("submit", "#createUpdatePost", function (e) {
        e.preventDefault();
        var status = document.getElementById("status").value;
        var location = document.getElementById("location").value;
        var privacy = document.getElementById("privacy").value;

        if(status === '') {
            alertMessage("#errorCreatePost", "You should write something before you proceed", "");
            return;
        }

        if(location === '') {
            alertMessage("#errorCreatePost", "Please select a location", "");
            return;
        }
        var data = {
            status: status,
            location: location,
            privacy: privacy
        };
        console.log("Post going to save ", data);

        $.post({
            url : '/posts',
            data : data,
            success : function(res) {

                window.location.reload();
            }
        })

    })
    $(document).on("submit", "#updatePostForm", function (e) {
        e.preventDefault();
        var id = document.getElementById("id").value;
        var status = document.getElementById("status").value;
        var privacy = document.getElementById("privacy").value;

        if(status === '') {
            alertMessage("#errorCreatePost", "You should write something before you proceed", "");
            return;
        }

        if(location === '') {
            alertMessage("#errorCreatePost", "Please select a location", "");
            return;
        }
        var data = {
            id: id,
            status: status,
            privacy: privacy
        };

        $.post({
            url : '/post/edit',
            data : data,
            success : function(res) {
                console.log("Response UPdate", res);
                if(res && res.code === 200) {
                    window.location.href = "/profile";
                }else {
                    alert("Could not update");
                }
                // window.location.reload();
            }
        })

    })





    //validate status
    //ajax call to post

    //fetch last and append to UI
}