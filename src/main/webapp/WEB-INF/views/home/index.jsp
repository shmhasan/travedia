<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head >
  <title>Home</title>
  <div th:replace="layout :: header-css"></div>
</head>
<body>
  <div th:replace="layout :: navigation"></div>
  <div class="container">
    <div th:replace="partials/create-post :: create-post"></div>
    <div th:if="${!loggedIn}">
        <a class="btn teal" href="/auth/login">Login</a>
    </div>

    <th:block th:each="post : ${posts}">
      <div class="row" >
        <div class="col s12 m7">
          <div class="card darken-1">
            <div class="card-content black-text">

              <h4 th:text="${post.author.username}"></h4>
              <small>at <span th:text="${post.location.name}"></span></small>
              <p th:text="${post.content}">

              </p>
              <p th:if="${loggedIn && post.author.username == loggedInUsername}">
                <a th:href="@{/post/edit?i=} + ${post.id}" >Edit Post</a>
                <a th:href="@{/posts/delete?id=} + ${post.id}" th:attr="data-id=${post.id}" class="delete-post">Delete</a>
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
