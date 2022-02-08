<%@include file="/jsp/header.jsp" %>
<title>Register</title>
</head>
<body>
<section class="vh-100 bg-image" style="background: #8fd19e">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                            <form method="post" action="<c:url value="/register"/>">

                                <div class="form-outline mb-4">
                                    <input type="text" name="firstName" required class="form-control form-control-lg"/>
                                    <label class="form-label">Your First Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="text" name="lastName" required class="form-control form-control-lg"/>
                                    <label class="form-label">Your Last Name</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" name="username" required class="form-control form-control-lg"/>
                                    <label class="form-label">Your username</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" name="password" required class="form-control form-control-lg"/>
                                    <label class="form-label">Password</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" name="checkPassword" required class="form-control form-control-lg"/>
                                    <label class="form-label">Repeat your password</label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
                                        Register
                                    </button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a
                                        href="<c:url value="/login"/>"
                                        class="fw-bold text-body"><u>Login
                                    here</u></a></p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
