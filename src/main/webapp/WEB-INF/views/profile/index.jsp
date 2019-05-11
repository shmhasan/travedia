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
            <div class="card">
                <div class="card-content black-text">
                    <div class="row">
                        <div class="col s3">
                            <img src="/static/images/img_avatar.png" class="avatar" alt="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12">
                            <table>
                               <tr>
                                   <th>Username</th>
                                   <td><span th:text="${profile.username}"></span></td>
                               </tr>
                                <tr>
                                    <th>Firstname</th>
                                    <td><span th:text="${profile.firstname}"></span></td>
                                </tr>
                                <tr>
                                    <th>Lastname</th>
                                    <td><span th:text="${profile.lastname}"></span></td>
                                </tr>
                                <tr>
                                    <th>Email</th>
                                    <td><span th:text="${profile.email}"></span></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col s9">
            <h4>My Posts</h4>
            <hr>
            <th:block th:each="post : ${posts}">
                <div class="row" >
                    <div class="col s12">

                        <div class="card darken-1">
                            <div class="card-content black-text">
                                <div class="row">
                                    <div class="col s3">
                                        <img src="/static/images/img_avatar.png" class="avatar" alt="">
                                        <div class="information">
                                            <strong th:text="${post.author.username}"></strong>
                                            <br>
                                            <small><strong><i class="tiny material-icons">location_city</i> <span th:text="${post.location.name}"></span></strong></small>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <p th:text="${post.content}">

                                </p>
                                <p th:if="${loggedIn && post.author.username == profile.username}">
                                    <a th:href="@{/post/edit?i=} + ${post.id}" ><i class="material-icons small">create</i></a>
                                    <a th:href="@{/posts/delete?id=} + ${post.id}" th:attr="data-id=${post.id}" class="delete-post"><i class="material-icons small">delete</i></a>
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
</body>
</html>