<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
    <div th:replace="layout :: header-css"></div>
</head>
<body>


  <div class="container">
    <div class="row">
      <form class="col lg6" name="f" action="/auth/login" method="post">
        <div th:if="${param.error}" class="alert alert-error">
          Invalid username and password.
        </div>
        <div th:if="${param.logout}" class="alert alert-success">
          You have been logged out.
        </div>
        <div class="card blue-grey darken-1">
          <div class="card-content white-text">
            <div class="row">
              <div class="input-field col s12">
                <input id="email" type="text" name="username" class="validate" autocomplete="off">
                <label for="email">Email</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <input id="password" type="password" name="password" class="validate" autocomplete="off">
                <label for="password">Password</label>
              </div>
            </div>
            <button class="btn teal" type="submit" style="width: 100%;">Login</button>
            <a href="/auth/register">Register</a>
          </div>
        </div>
      </form>
    </div>
  </div>

  <div th:replace="layout :: footer-scripts"></div>
</body>
</html>
