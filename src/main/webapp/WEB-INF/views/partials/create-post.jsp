<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" >
<html>
<head>
    <title>Title</title>
    <style>

    </style>
</head>
<body>
    <div th:fragment="create-post" >
        <div class="row" th:if="${loggedIn}">

            <div class="col s12">
                <form class="status" name="createpostForm" method="post" action="/" id="createUpdatePost">
                    <span class="card-title">Create Post</span>

                    <div class="content">
                        <div id="errorCreatePost">

                        </div>

                        <div class="row">
                            <div class="input-field col s12">
                                <textarea name="status" id="status" class="materialize-textarea" cols="30" rows="10"></textarea>
                                <label for="status">Status</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s3">
                                <i class="material-icons prefix">add_location</i>
                                <select name="location" id="location">
                                    <option value="" selected>Select location</option>
                                </select>
                                <label for="location">Location</label>
                            </div>
                            <div class="input-field col s3">
                                <i class="material-icons prefix">settings</i>
                                <select name="location" id="privacy">
                                    <option value="1" selected>Public</option>
                                    <option value="2">Private</option>
                                </select>
                                <label for="location">Privacy</label>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col s6">
                                <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </div>

                    </div>

                </form>
            </div>
        </div>
        <script src="/static/app/post.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                initCreateOrUpdatePost();
                $.get("/rest/location", function (data) {
                    console.log(data);
                    var dom = "";


                    for(var i=0; i< data.length; i++) {
                        var item = data[i];

                        dom += '<option value="'+item.id+'">'+item.name+'</option>';
                    };
                     $("#location").append(dom);
                    var elems = document.querySelectorAll('select');
                    var options = {};
                    var instances = M.FormSelect.init(elems, options);
                });
            });
        </script>
    </div>

</body>
</html>
