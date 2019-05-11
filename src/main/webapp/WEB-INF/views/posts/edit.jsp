<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head >
    <title>Home</title>
    <div th:replace="layout :: header-css"></div>
</head>
<body>
<div th:replace="layout :: navigation"></div>
<div class="container">
    <div class="row">
        <div class="col s12">

            <form class="status" name="updatePostForm" method="post" action="/" id="updatePostForm" th:object="${post}">
                <span class="card-title">Create Post</span>

                <div class="content">
                    <div id="errorCreatePost">

                    </div>

                    <input type="hidden" th:field="*{id}" th:value="${id}" id="id">
                    <div class="row">
                        <div class="input-field col s12">
                            <textarea name="status" id="status" th:text="*{status}" class="materialize-textarea" cols="30" rows="10"></textarea>
                            <label for="status">Status</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s3">
                            <i class="material-icons prefix">settings</i>
                            <select id="privacy" th:field="*{privacy}">
                                <option th:value="1" th:selected="${privacy == 1}">Public</option>
                                <option th:value="2" th:selected="${privacy == 2}">Private</option>
                            </select>
                            <label for="privacy">Privacy</label>
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
            // $.get("/rest/location", function (data) {
            //     console.log(data);
            //     var dom = "";
            //
            //
            //     for(var i=0; i< data.length; i++) {
            //         var item = data[i];
            //
            //         dom += '<option value="'+item.id+'">'+item.name+'</option>';
            //     };
            //     $("#location").append(dom);
            //     var elems = document.querySelectorAll('select');
            //     var options = {};
            //     var instances = M.FormSelect.init(elems, options);
            //
            //     $.get("/post/");
            // });

            var elems = document.querySelectorAll('select');
            var options = {};
            var instances = M.FormSelect.init(elems, options);
        });
    </script>

</div>

<div th:replace="layout :: footer-scripts"></div>

</body>
</html>
