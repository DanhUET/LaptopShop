<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <title>Chi tiết sản phẩm</title>
                    <meta content="width=device-width, initial-scale=1.0" name="viewport">
                    <meta content="" name="keywords">
                    <meta content="" name="description">

                    <!-- Google Web Fonts -->
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link
                        href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap"
                        rel="stylesheet">

                    <!-- Icon Font Stylesheet -->
                    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
                        rel="stylesheet">

                    <!-- Libraries Stylesheet -->
                    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
                    <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


                    <!-- Customized Bootstrap Stylesheet -->
                    <link href="/client/css/bootstrap.min.css" rel="stylesheet">

                    <!-- Template Stylesheet -->
                    <link href="/client/css/style.css" rel="stylesheet">
                    <style>
                        .page-link.disabled {
                            color: var(--bs-pagination-disabled-color);
                            pointer-events: none;
                            background-color: var(--bs-pagination-disabled-bg);
                        }
                    </style>
                </head>

                <body>

                    <!-- Spinner Start -->
                    <jsp:include page="../layout/header.jsp" />
                    <!-- Modal Search End -->
                    <div class="pt-5"></div>
                    <div class="container-fluid fruite py-5">
                        <div class="container py-5 mt-4">
                            <div class="mb-4 mt-4">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Chi Tiết Sản Phẩm
                                        </li>
                                    </ol>
                                </nav>
                            </div>
                            <div class="row g-4">
                                <div class="col-lg-12">
                                    <div class="row g-4">
                                        <div class="col-lg-3">
                                            <form class="row g-4">
                                                <div class="col-12" id="factoryFilter">
                                                    <div class="mb-2"><b>Hãng sản xuất</b></div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="factory-1"
                                                            value="APPLE" name="factory">
                                                        <label class="form-check-label" for="factory-1">Apple</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="factory-2"
                                                            value="ASUS" name="factory">
                                                        <label class="form-check-label" for="factory-2">Asus</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="factory-3"
                                                            value="LENOVO" name="factory">
                                                        <label class="form-check-label" for="factory-3">Lenovo</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="factory-4"
                                                            value="DELL" name="factory">
                                                        <label class="form-check-label" for="factory-4">Dell</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="factory-5"
                                                            value="LG" name="factory">
                                                        <label class="form-check-label" for="factory-5">LG</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="factory-6"
                                                            value="ACER" name="factory">
                                                        <label class="form-check-label" for="factory-6">Acer</label>
                                                    </div>

                                                </div>
                                                <div class="col-12" id="targetFilter">
                                                    <div class="mb-2"><b>Mục đích sử dụng</b></div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="target-1"
                                                            value="GAMING" name="target">
                                                        <label class="form-check-label" for="target-1">Gaming</label>
                                                    </div>

                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="target-2"
                                                            value="SINHVIEN-VANPHONG" name="target">
                                                        <label class="form-check-label" for="target-2">Sinh viên - văn
                                                            phòng</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="target-3"
                                                            value="THIET-KE-DO-HOA" name="target">
                                                        <label class="form-check-label" for="target-3">Thiết kế đồ
                                                            họa</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="target-4"
                                                            value="MONG-NHE" name="target">
                                                        <label class="form-check-label" for="target-4">Mỏng nhẹ</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="target-5"
                                                            value="DOANH-NHAN" name="target">
                                                        <label class="form-check-label" for="target-5">Doanh
                                                            nhân</label>
                                                    </div>


                                                </div>
                                                <div class="col-12" id="priceFilter">
                                                    <div class="mb-2"><b>Mức giá</b></div>

                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="price-2"
                                                            value="duoi-10-trieu" name="price">
                                                        <label class="form-check-label" for="price-2">Dưới 10
                                                            triệu</label>
                                                    </div>

                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="price-3"
                                                            value="10-15-trieu" name="price">
                                                        <label class="form-check-label" for="price-3">Từ 10 - 15
                                                            triệu</label>
                                                    </div>

                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="price-4"
                                                            value="15-20-trieu" name="price">
                                                        <label class="form-check-label" for="price-4">Từ 15 - 20
                                                            triệu</label>
                                                    </div>

                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="checkbox" id="price-5"
                                                            value="tren-20-trieu" name="price">
                                                        <label class="form-check-label" for="price-5">Trên 20
                                                            triệu</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="mb-2"><b>Sắp xếp</b></div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" id="sort-1"
                                                            value="gia-tang-dan" name="radio-sort">
                                                        <label class="form-check-label" for="sort-1">Giá tăng
                                                            dần</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" id="sort-2"
                                                            value="gia-giam-dan" name="radio-sort">
                                                        <label class="form-check-label" for="sort-2">Giá giảm
                                                            dần</label>
                                                    </div>

                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" id="sort-3" checked
                                                            value="gia-nothing" name="radio-sort">
                                                        <label class="form-check-label" for="sort-3">Không sắp
                                                            xếp</label>
                                                    </div>

                                                </div>
                                                <div class="col-12">
                                                    <button
                                                        class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4"
                                                        id="btnFilter">
                                                        Lọc Sản Phẩm
                                                    </button>
                                                </div>
                                            </form>

                                        </div>
                                        <div class="col-lg-9">

                                            <div class="row g-4 justify-content-start">
                                                <c:if test="${empty products}">
                                                    <div>Không tìm thấy sản phẩm</div>
                                                </c:if>
                                                <c:forEach items="${products}" var="product">
                                                    <div class="col-md-6 col-lg-6 col-xl-4">
                                                        <div class="rounded position-relative fruite-item">
                                                            <div class="fruite-img">
                                                                <img src="/images/product/${product.image}"
                                                                    class="img-fluid w-100 rounded-top" alt="">
                                                            </div>
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                                                style="top: 10px; left: 10px;">${product.factory}</div>
                                                            <div
                                                                class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                                <div><a
                                                                        href="/product/${product.id}">${product.name}</a>
                                                                </div>
                                                                <p>${product.detailDesc}</p>
                                                                <div
                                                                    class="d-flex justify-content-between flex-lg-wrap">
                                                                    <p class="text-dark fs-5 fw-bold mb-0">
                                                                        <fmt:formatNumber type="number"
                                                                            pattern="###,###,###"
                                                                            value="${product.price}" var="myNum" />
                                                                        ${myNum} đ
                                                                    </p>
                                                                    <form action="/add-product-to-cart/${product.id}"
                                                                        method="post">
                                                                        <input type="hidden"
                                                                            name="${_csrf.parameterName}"
                                                                            value="${_csrf.token}" />
                                                                        <button
                                                                            class="btn border border-secondary rounded-pill px-2 py-1 text-primary small"><i
                                                                                class="fa fa-shopping-bag me-2 text-primary"></i>
                                                                            Add to cart</button>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                            <div class="mt-4">
                                                <c:if test="${not empty products}">
                                                    <nav aria-label="Page navigation example">
                                                        <ul class="pagination justify-content-center d-flex">
                                                            <li
                                                                class="page-item ${currentPage eq  1 ? 'disabled' : ''}">
                                                                <a class="page-link  " href="?page=${currentPage - 1}"
                                                                    aria-label="Previous">
                                                                    <span aria-hidden="true">&laquo;</span>
                                                                </a>
                                                            </li>
                                                            <c:forEach begin="0" end="${totalPages - 1}"
                                                                varStatus="loop">
                                                                <li class="page-item"><a
                                                                        class="page-link ${loop.index + 1 eq currentPage ? 'active' : ''}"
                                                                        href="?page=${loop.index + 1}">${loop.index +
                                                                        1}</a>
                                                                </li>
                                                            </c:forEach>
                                                            <li
                                                                class="page-item ${currentPage eq totalPages ? 'disabled' : ''}">
                                                                <a class="page-link " href="?page=${currentPage + 1}"
                                                                    aria-label="Next">
                                                                    <span aria-hidden="true">&raquo;</span>
                                                                </a>
                                                            </li>
                                                        </ul>
                                                    </nav>
                                                </c:if>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Copyright End -->
                    <jsp:include page="../layout/footer.jsp" />


                    <!-- Back to Top -->
                    <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i
                            class="fa fa-arrow-up"></i></a>


                    <!-- JavaScript Libraries -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="/client/lib/easing/easing.min.js"></script>
                    <script src="/client/lib/waypoints/waypoints.min.js"></script>
                    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
                    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>
                    <script src="/client/js/main.js"></script>
                    <script
                        src="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.js"></script>

                    <!-- Template Javascript -->

                    <script>

                        $(document).ready(function () {
                            const searchParams = new URL(window.location.href).searchParams;

                            // Factory
                            const factoryParams = searchParams.getAll("factory");

                            if (factoryParams) {
                                // const factoryList = factoryParams.split(",");
                                factoryParams.forEach(function (value) {
                                    $('#factoryFilter .form-check-input[value="' + value + '"]').prop("checked", true);
                                });
                            }

                            // Target
                            const targetParams = searchParams.getAll("target");
                            if (targetParams) {
                                // const targetList = targetParams.split(",");
                                targetParams.forEach(function (value) {
                                    $('#targetFilter .form-check-input[value="' + value + '"]').prop("checked", true);
                                });
                            }

                            // Price
                            const priceParams = searchParams.getAll("price");
                            if (priceParams) {
                                // const priceList = priceParams.split(",");
                                priceParams.forEach(function (value) {
                                    $('#priceFilter .form-check-input[value="' + value + '"]').prop("checked", true);
                                });
                            }

                            // Sort radio
                            const sortValue = searchParams.get("radio-sort");
                            if (sortValue) {
                                $('input[name="radio-sort"][value="' + sortValue + '"]').prop("checked", true);
                            }
                        });

                    </script>
                </body>

                </html>