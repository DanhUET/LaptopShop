<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Dashboard - Hỏi Dân IT</title>
                <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
                <link href="/admin/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/navigation.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage User</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">User</li>
                                </ol>
                                <div class="row">
                                    <div class="col-md-6 col-12 mx-auto">
                                        <h3>Update user with id=${user.id}</h3>
                                        <hr>
                                        <form:form method="post" action="/admin/user/update/${user.id}"
                                            modelAttribute="user">
                                            <div class="mb-3" style="display: none;">
                                                <label for="id" class="form-label">Id</label>
                                                <form:input type="text" class="form-control" id="phone" path="id" />
                                            </div>
                                            <div class=" col-12 mb-3 col-md-6">
                                                <label for="email" class="form-label">Email:</label>
                                                <form:input type="email" class="form-control" id="email"
                                                    value="${user.email}" path="email" />
                                            </div>
                                            <div class="col-12 mb-3 col-md-6">
                                                <label for="fullname" class="form-label">Full Name:</label>
                                                <form:input type="text" class="form-control" id="fullname"
                                                    value="${user.fullName}" path="fullName" />
                                            </div>
                                            <div class="col-12 mb-3 col-md-6">
                                                <label for="phone" class="form-label">Phone:</label>
                                                <form:input type="text" class="form-control" id="phone"
                                                    value="${user.phone}" path="phone" />
                                            </div>
                                            <div class="col-12 mb-3 col-md-6">
                                                <label for="address" class="form-label">Address:</label>
                                                <form:input type="text" class="form-control" id="address"
                                                    value="${user.address}" path="address" />
                                            </div>
                                            <button type="submit" class="btn btn-warning">Update</button>
                                        </form:form>
                                    </div>
                                </div>

                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/admin/js/scripts.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
                    crossorigin="anonymous"></script>

                <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                    crossorigin="anonymous"></script>
                <script src="/admin/js/datatables-simple-demo.js"></script>
            </body>

            </html>