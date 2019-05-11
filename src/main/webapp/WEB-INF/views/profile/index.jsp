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
        <div class="col s3">
            User Information
            <ul class="collection">
                <li class="collection-item avatar">
                    <img src="images/yuna.jpg" alt="" class="circle">
                    <span class="title" th:text="${profile.firstname}"></span>
                    <span class="title" th:text="${profile.lastname}"></span>
                    <p>
                        <small th:text="${profile.username}"></small>
                        <br>
                        <small th:text="${profile.email}"></small>
                    </p>
                </li>
            </ul>
        </div>
        <div class="col s9">
            <h4>Posts</h4>
            <hr>
            <th:block th:each="post : ${posts}">
                <div class="row" >
                    <div class="col s12">
                        <div class="card darken-1">
                            <div class="card-content black-text">

                                <h4 th:text="${post.author.username}"></h4>
                                <small>at <span th:text="${post.location.name}"></span></small>
                                <p th:text="${post.content}">

                                </p>
                                <p th:if="${loggedIn && post.author.username == profile.username}">
                                    <a th:href="@{/post/edit?i=} + ${post.id}" >Edit Post</a>
                                    <a th:href="@{/posts/delete?id=} + ${post.id}" th:attr="data-id=${post.id}" class="delete-post">Delete</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </th:block>

        </div>
    </div>
</div>


<div th:replace="layout :: footer-scripts"></div>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('select');
        var options = {};
        var instances = M.FormSelect.init(elems, options);
    });


</script>
</body>
</html>