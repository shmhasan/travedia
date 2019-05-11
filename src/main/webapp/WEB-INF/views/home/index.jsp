<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head >
  <title>Home</title>
  <div th:replace="layout :: header-css"></div>
</head>
<body>
  <div th:replace="layout :: navigation"></div>
  <div class="container-fluid">
    <div th:replace="partials/create-post :: create-post"></div>

    <div class="row">
      <div class="col s12 m6 l6 offset-m3 offset-l3">
        <strong>News Feed</strong>
        <hr>
      </div>
    </div>

    <th:block th:each="post : ${posts}">
      <div class="row" >
        <div class="col s12 m6 l6 offset-m3 offset-l3">

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
              <p th:if="${loggedIn && post.author.username == loggedInUsername}">
                <a th:href="@{/post/edit?i=} + ${post.id}" ><i class="material-icons small">create</i></a>
                <a th:href="@{/posts/delete?id=} + ${post.id}" th:attr="data-id=${post.id}" class="delete-post"><i class="material-icons small">delete</i></a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </th:block>

  </div>

<div th:replace="layout :: footer-scripts"></div>
  <script>
    document.addEventListener('DOMContentLoaded', function() {
      var elems = document.querySelectorAll('select');
      var options = {};
      var instances = M.FormSelect.init(elems, options);
    });

    $(document).on('click', '.delete-post', function (e) {
        e.preventDefault();
        var id = $(e.target).data('id');

        console.log("Delete ID", id);
        $.ajax({
            url: '/posts/delete?id='+id,
            type: 'DELETE',
            success: function(result) {
                // Do something with the result
                console.log("delete",result);
                if(result && result.code === 200) {
                    window.location.reload();
                }else {
                    alert("Could not delete post");
                }
            }
        });

    });


  </script>
</body>
</html>
