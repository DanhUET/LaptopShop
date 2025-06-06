<%@ page pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <div id="spinner"
                class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
                <div class="spinner-grow text-primary" role="status"></div>
            </div>
            <!-- Spinner End -->


            <!-- Navbar start -->
            <div class="container-fluid fixed-top">
                <div class="container topbar bg-primary d-none d-lg-block">
                    <div class="d-flex justify-content-between">
                        <div class="top-info ps-2">
                            <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#"
                                    class="text-white">123 Street, New York</a></small>
                            <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#"
                                    class="text-white">Email@Example.com</a></small>
                        </div>
                        <div class="top-link pe-2">
                            <a href="#" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                            <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                            <a href="#" class="text-white"><small class="text-white ms-2">Sales and Refunds</small></a>
                        </div>
                    </div>
                </div>
                <div class="container px-0">
                    <nav class="navbar navbar-light bg-white navbar-expand-xl">
                        <p href="" class="navbar-brand">
                        <h1 class="text-primary display-6">Laptop Shop</h1>
                        </p>
                        <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarCollapse">
                            <span class="fa fa-bars text-primary"></span>
                        </button>
                        <div class="collapse navbar-collapse bg-white justify-content-between mx-5" id="navbarCollapse">
                            <div class="navbar-nav ">
                                <a href="/" class="nav-item nav-link ">Trang chủ</a>
                                <a href="/products" class="nav-item nav-link">Sản phẩm</a>


                                <a href="/contact" class="nav-item nav-link ">Contact</a>
                            </div>

                            <div class=" m-3 me-0">
                                <c:if test="${not empty pageContext.request.userPrincipal}">
                                    <div class="d-flex">

                                        <a href="/cart" class="position-relative me-4 my-auto ">
                                            <i class="fa fa-shopping-bag fa-2x"></i>
                                            <span
                                                class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                                                style="top: -5px; left: 15px; height: 20px; min-width: 20px;"
                                                id="sumCart">
                                                <fmt:formatNumber value="${sessionScope.sum}" type="number"
                                                    maxFractionDigits="2" />
                                            </span>
                                        </a>


                                        <div class="dropdown my-auto">
                                            <a href="#" class="dropdown" role="button" id="dropdownMenuLink"
                                                data-bs-toggle="dropdown" aria-expanded="false"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="fas fa-user fa-2x"></i>
                                            </a>

                                            <ul class="dropdown-menu dropdown-menu-end p-4" aria-
                                                labelledby="dropdownMenuLink">

                                                <li class="d-flex align-items-center flex-column"
                                                    style="min-width: 0px;">
                                                    <img style="width: 50px; height: 50px; border-radius: 50%; overflow: hidden;"
                                                        src="/images/avatar/${sessionScope.avatar}" />
                                                    <div class="text-center my-3">
                                                        <c:out value="${sessionScope.fullName}" />

                                                    </div>
                                                </li>
                                                <li><a class="dropdown-item" href="/userInfo/${sessionScope.id}">Quản
                                                        lý tài
                                                        khoản</a></li>
                                                <li><a class="dropdown-item" href="#">Lịch sử mua hàng</a></li>
                                                <li>
                                                    <hr class="dropdown-divider">
                                                </li>
                                                <li>
                                                    <form action="/logout" method="post">
                                                        <input type="hidden" name="${_csrf.parameterName}"
                                                            value="${_csrf.token}" />
                                                        <button class="dropdown-item">Đăng
                                                            xuất</button>
                                                    </form>
                                                </li>
                                            </ul>

                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${empty pageContext.request.userPrincipal}">
                                    <div class="flex">
                                        <a href="/login" class="a-login position-relative me-4 my-auto">
                                            Đăng nhập
                                        </a>
                                        <a href="/register" class="position-relative me-4 my-auto">
                                            Đăng ký
                                        </a>
                                    </div>
                                </c:if>
                            </div>


                        </div>
                    </nav>
                </div>
            </div>
            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    let navLinks = document.querySelectorAll(".navbar-nav .nav-link");
                    let currentURL = window.location.pathname;
                    navLinks.forEach(link => {
                        if (link.getAttribute("href") === currentURL) {
                            link.classList.add("active");
                        } else {
                            link.classList.remove("active");
                        }
                    });
                });
            </script>