<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" >
<head >
    <title>Application</title>
  <div th:fragment="header-css">
    <link rel="stylesheet" href="/static/design/css/materialize.min.css">
    <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
  </div>
</head>
<body>

  <div th:if="${loggedIn}" th:fragment="navigation">
    <div th:if="${true}">
      <div class="navbar-fixed">
        <nav>
          <div class="nav-wrapper">
            <a href="#!" class="brand-logo">Travedia</a>
            <ul class="right hide-on-med-and-down">
              <li><a href="#/">Posts</a></li>
              <li><a href="#/">Profile</a></li>
              <li><a href="/logout">Logout</a></li>
            </ul>
          </div>
        </nav>
      </div>
    </div>
    <div th:unless="${1 == 1}">
      Not Logged in
    </div>
  </div>

<div th:fragment="footer-scripts">
  <script src="/static/design/js/materialize.min.js"></script>
</div>
</body>
</html>
