<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
    <div th:replace="layout :: header-css"></div>
</head>
<body style="background: #722d96 !important;">


<div class="container">
    <div class="row">
        <div th:if="${hasError}">
            You have error in form
        </div>
        <form class="col s12 m6 offset-m3 l4 offset-l3" style="margin-top: 7%;" id="registraionForm" th:action="@{/auth/register}" th:object="${user}" method="post">
            <div class="card blue-grey darken-1">
                <div class="card-content white-text">
                    <div class="row">
                        <div class="input-field col s12">
                            <input type="email" th:field="*{email}" class="validate" autocomplete="off" required="true" minlength="3">
                            <label for="email">Email</label>
                            <span th:if="${#fields.hasErrors('email')}" th:errors="*{email}">Email Error
                                Error</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input th:field="*{username}" type="text" class="validate" autocomplete="off" required="true" minlength="5" maxlength="20">
                            <label for="username">Username</label>
                            <span th:if="${#fields.hasErrors('username')}" th:errors="*{username}">Username Error
                                Error</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input th:field="*{firstname}" type="text" class="validate" autocomplete="off" required="true" minlength="3" maxlength="30">
                            <label for="firstname">First Name</label>
                            <span th:if="${#fields.hasErrors('firstname')}" th:errors="*{firstname}">First Name Error</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input th:field="*{lastname}" type="text" class="validate" autocomplete="off" required="true" minlength="3" maxlength="30">
                            <label for="lastname">Last Name</label>
                            <span th:if="${#fields.hasErrors('lastname')}" th:errors="*{lastname}">Lastname Error
                                Error</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input th:field="*{password}" type="password" name="password" class="validate" autocomplete="off" required="true" minlength="6" maxlength="20">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <button class="btn purple darken-3" style="width: 100%;" type="submit">Register</button>
                    <strong>Please </strong><a href="/auth/login">Login</a>, <strong>if you are registered user</strong>
                </div>
            </div>
        </form>
        <script>
            $(document).ready(function () {
                console.log("Validation");
                initRegistraionForm();
            });
        </script>
    </div>
</div>

<div th:replace="layout :: footer-scripts"></div>
<script src="/static/app/app.js"></script>
</body>
</html>
