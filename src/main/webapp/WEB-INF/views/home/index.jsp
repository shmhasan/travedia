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

    <div class="row">
      <div class="col s12 m7">
        <div class="card darken-1">
          <div class="card-content black-text">
            <p>
              <h4>Name</h4>
              status chillllldf fdljkdsf
            at Sylhet
            </p>
          </div>
        </div>
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
