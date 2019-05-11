<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" >
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div th:fragment="create-post" >
        <div class="row" th:if="${loggedIn}">
            <div class="col s12 m7">
                <div class="card darken-1">

                    <div class="card-content black-text">
                        <span class="card-title">Create Post</span>
                        <div class="row">
                            <div class="input-field col s12">
                                <textarea name="status" id="status" cols="30" rows="10"></textarea>
                                <label for="status">Status</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">
                                <select name="location" id="location">
                                    <option value="" selected>Select location</option>
                                </select>
                                <label for="location">Location</label>
                            </div>
                        </div>
                    </div>
                    <div class="card-action">
                        <button class="btn btn-block" onclick="post()" >Post</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="/static/app/post.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
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
