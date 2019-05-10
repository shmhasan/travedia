<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" >
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div th:fragment="create-post">
        <div class="row">
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
                                    <option value="sylhet">Sylhet</option>
                                    <option value="dhaka">Dhaka</option>
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
        <script type="text/javascript">
            function post() {
                console.log("Posint");
                var status = document.getElementById("status").value;
                var location = document.getElementById("location").value;
                alert(status + location);
            }
        </script>
    </div>

</body>
</html>
