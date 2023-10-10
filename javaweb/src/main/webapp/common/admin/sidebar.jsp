<div class="sidebar">
    <!-- Sidebar user panel (optional) -->
    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
            <img src="<c:url value='/template/admin/dist/img/user2-160x160.jpg'/> " class="img-circle elevation-2"
                alt="User Image">
        </div>
        <div class="info">
            <a href="#" class="d-block"><c:if test="${not empty USERMODEL}">
							${USERMODEL.fullname}
						</c:if></a>
        </div>
    </div>

    <!-- SidebarSearch Form -->
    <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
            <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
            <div class="input-group-append">
                <button class="btn btn-sidebar">
                    <i class="fas fa-search fa-fw"></i>
                </button>
            </div>
        </div>
    </div>

    <!-- Sidebar Menu -->
    <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
            <li class="nav-item"><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Category <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-category?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Category</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-category?action=insert'/>" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>Add Category</p>
                        </a></li>

                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Brand <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-brand?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Brand</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-brand?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Brand</p>
                        </a></li>

                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Color <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-color?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Color</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-color?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Color</p>
                        </a></li>

                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Size <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-size?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Size</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-size?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Size</p>
                        </a></li>
                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Tag <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-tag?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Tag</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-tag?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Tag</p>
                        </a></li>

                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Role <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-role?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Role</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-role?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Role</p>
                        </a></li>

                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Slider <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-slider?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Slider</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-slider?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Slider</p>
                        </a></li>

                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Product <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-product?page=1&maxPageItem=4&sortName=name&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Product</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-product?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Product</p>
                        </a></li>

                </ul>
            </li>
            <li class="nav-item "><a href="#" class="nav-link active"> <i class="nav-icon fas fa-tachometer-alt"></i>
                    <p>
                        Product Detail <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item"><a
                            href="<c:url value = '/admin-product-detail?page=1&maxPageItem=4&sortName=product_id&sortBy=desc'/>"
                            class="nav-link active"> <i class="far fa-circle nav-icon"></i>
                            <p>List Product Detail</p>
                        </a></li>
                    <li class="nav-item"><a href="<c:url value = '/admin-product-detail?action=insert'/>" class="nav-link"> <i
                                class="far fa-circle nav-icon"></i>
                            <p>Add Product Detail</p>
                        </a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <!-- /.sidebar-menu -->
</div>