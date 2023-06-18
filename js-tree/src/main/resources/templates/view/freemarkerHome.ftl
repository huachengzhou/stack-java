<html xmlns:c="http://www.w3.org/1999/html" xmlns:fmt="http://www.w3.org/1999/html">
<#--<#assign ww=JspTaglibs["/WEB-INF/webwork.tld"] />-->
<#--<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]/>-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>spring boot</title>
<#include "/baseStyle.ftl">
</head>
<body>

<div class="wrapper">


    <nav id="sidebar" class="sidebar">
        <div class="sidebar-content js-simplebar" data-simplebar="init">
            <div class="simplebar-wrapper" style="margin: 0px;">
                <div class="simplebar-height-auto-observer-wrapper">
                    <div class="simplebar-height-auto-observer"></div>
                </div>
                <div class="simplebar-mask">
                    <div class="simplebar-offset" style="right: 0px; bottom: 0px;">
                        <div class="simplebar-content-wrapper" style="height: 100%; overflow: hidden scroll;">
                            <div class="simplebar-content" style="padding: 0px;">
                                <a class="sidebar-brand" href="${request.contextPath}/sys/home">
                                    <span class="align-middle">数据中心</span>
                                </a>

                                <ul class="sidebar-nav">
                                    <li class="sidebar-header">
                                        数据采集
                                    </li>

                                    <li class="sidebar-item">
                                        <a class="sidebar-link" target="_blank" href="http://www.stats.gov.cn/">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                 viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                 stroke-linecap="round" stroke-linejoin="round"
                                                 class="feather feather-sliders align-middle">
                                                <line x1="4" y1="21" x2="4" y2="14"></line>
                                                <line x1="4" y1="10" x2="4" y2="3"></line>
                                                <line x1="12" y1="21" x2="12" y2="12"></line>
                                                <line x1="12" y1="8" x2="12" y2="3"></line>
                                                <line x1="20" y1="21" x2="20" y2="16"></line>
                                                <line x1="20" y1="12" x2="20" y2="3"></line>
                                                <line x1="1" y1="14" x2="7" y2="14"></line>
                                                <line x1="9" y1="8" x2="15" y2="8"></line>
                                                <line x1="17" y1="16" x2="23" y2="16"></line>
                                            </svg>
                                            <span class="align-middle">国家统计局</span>
                                        </a>
                                    </li>

                                    <li class="sidebar-item">
                                        <a class="sidebar-link" target="_blank" href="http://www.xinhuanet.com/">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                 viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                 stroke-linecap="round" stroke-linejoin="round"
                                                 class="feather feather-user align-middle">
                                                <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                                                <circle cx="12" cy="7" r="4"></circle>
                                            </svg>
                                            <span class="align-middle">新华网</span>
                                        </a>
                                    </li>

                                    <li class="sidebar-item">
                                        <a class="sidebar-link" target="_blank" href="javascript:void(0);">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                 viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                 stroke-linecap="round" stroke-linejoin="round"
                                                 class="feather feather-settings align-middle">
                                                <circle cx="12" cy="12" r="3"></circle>
                                                <path d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path>
                                            </svg>
                                            <span class="align-middle">设置</span>
                                        </a>
                                    </li>

                                    <li class="sidebar-item">
                                        <a class="sidebar-link" target="_blank" href="http://pfscnew.agri.gov.cn/">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                 viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                 stroke-linecap="round" stroke-linejoin="round"
                                                 class="feather feather-credit-card align-middle">
                                                <rect x="1" y="4" width="22" height="16" rx="2" ry="2"></rect>
                                                <line x1="1" y1="10" x2="23" y2="10"></line>
                                            </svg>
                                            <span class="align-middle">农业价格</span>
                                        </a>
                                    </li>

                                    <li class="sidebar-item">
                                        <a class="sidebar-link" target="_blank" href="http://www.shfe.com.cn/">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                 viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                 stroke-linecap="round" stroke-linejoin="round"
                                                 class="feather feather-book align-middle">
                                                <path d="M4 19.5A2.5 2.5 0 0 1 6.5 17H20"></path>
                                                <path d="M6.5 2H20v20H6.5A2.5 2.5 0 0 1 4 19.5v-15A2.5 2.5 0 0 1 6.5 2z"></path>
                                            </svg>
                                            <span class="align-middle">上海期货交易网</span>
                                        </a>
                                    </li>

                                    <li class="sidebar-header">
                                        求职 &amp; 职位数据
                                    </li>
                                    <li class="sidebar-item active">
                                        <a href="#ui" data-toggle="collapse" class="sidebar-link">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                 viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                                 stroke-linecap="round" stroke-linejoin="round"
                                                 class="feather feather-briefcase align-middle">
                                                <rect x="2" y="7" width="20" height="14" rx="2" ry="2"></rect>
                                                <path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"></path>
                                            </svg>
                                            <span class="align-middle">职位抓取</span>
                                        </a>
                                        <ul id="ui" class="sidebar-dropdown list-unstyled collapse show"
                                            data-parent="#sidebar">
                                            <li class="sidebar-item"><a target="_blank" class="sidebar-link"
                                                                        href="https://www.51job.com/">前程无忧51job</a></li>
                                            <li class="sidebar-item "><a target="_blank" class="sidebar-link"
                                                                         href="https://www.zhaopin.com/">智联</a>
                                            </li>
                                            <li class="sidebar-item"><a target="_blank" class="sidebar-link"
                                                                        href="https://www.zhipin.com/">boos直聘</a>
                                            </li>
                                            <li class="sidebar-item"><a target="_blank" class="sidebar-link"
                                                                        href="https://www.lagou.com/">拉勾网</a></li>
                                            <li class="sidebar-item"><a target="_blank" class="sidebar-link"
                                                                        href="https://www.liepin.com/">猎聘网</a>
                                            </li>
                                            <li class="sidebar-item"><a target="_blank" class="sidebar-link"
                                                                        href="https://www.linkedin.com/">领英(国外)</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="simplebar-placeholder" style="width: auto; height: 1151px;"></div>
            </div>
            <div class="simplebar-track simplebar-horizontal" style="visibility: hidden;">
                <div class="simplebar-scrollbar" style="width: 0px; display: none;"></div>
            </div>
            <div class="simplebar-track simplebar-vertical" style="visibility: visible;">
                <div class="simplebar-scrollbar"
                     style="height: 132px; transform: translate3d(0px, 0px, 0px); display: block;"></div>
            </div>
        </div>
    </nav>


    <div class="main">
        <nav class="navbar navbar-expand navbar-light navbar-bg">
            <a class="sidebar-toggle d-flex">
                <i class="hamburger align-self-center"></i>
            </a>

            <form class="form-inline d-none d-sm-inline-block">
                <div class="input-group input-group-navbar">
                    <input type="text" class="form-control" placeholder="Search…" aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn" type="button">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-search align-middle">
                                <circle cx="11" cy="11" r="8"></circle>
                                <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                            </svg>
                        </button>
                    </div>
                </div>
            </form>

            <div class="navbar-collapse collapse">
                <ul class="navbar-nav navbar-align">



                    <li class="nav-item dropdown">
                        <a class="nav-icon dropdown-toggle" href="javascript:void(0);" id="messagesDropdown" data-toggle="dropdown">
                            <div class="position-relative">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-message-square align-middle">
                                    <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"></path>
                                </svg>
                            </div>
                        </a>
                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right py-0"
                             aria-labelledby="messagesDropdown">
                            <div class="dropdown-menu-header">
                                <div class="position-relative">
                                    数据抓取
                                </div>
                            </div>
                            <div class="list-group">
                                <a href="javascript:void(0);" class="list-group-item">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col-2">
                                            <img src="${request.contextPath}/static/adminKit/img/avatars/avatar-5.jpg"
                                                 class="avatar img-fluid rounded-circle"
                                                 alt="Vanessa Tucker">
                                        </div>
                                        <div class="col-10 pl-2">
                                            <div class="text-dark">前程无忧51job</div>
                                            <div class="text-muted small mt-1">职位分析
                                            </div>
                                            <div class="text-muted small mt-1">软件工程师</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="dropdown-menu-footer">
                                <a href="javascript:void(0);" class="text-muted">更多操作</a>
                            </div>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-toggle="dropdown">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-settings align-middle">
                                <circle cx="12" cy="12" r="3"></circle>
                                <path d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path>
                            </svg>
                        </a>

                        <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-toggle="dropdown">
                            <img src="${request.contextPath}/static/adminKit/img/avatars/avatar.jpg"
                                 class="avatar img-fluid rounded mr-1" alt="Charles Hall">
                            <span class="text-dark">Charles Hall</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="javascript:void(0);">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-user align-middle mr-1">
                                    <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                                    <circle cx="12" cy="7" r="4"></circle>
                                </svg>
                                Profile</a>
                            <a class="dropdown-item" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-pie-chart align-middle mr-1">
                                    <path d="M21.21 15.89A10 10 0 1 1 8 2.83"></path>
                                    <path d="M22 12A10 10 0 0 0 12 2v10z"></path>
                                </svg>
                                Analytics</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="javascript:void(0);">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-settings align-middle mr-1">
                                    <circle cx="12" cy="12" r="3"></circle>
                                    <path d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path>
                                </svg>
                                Settings &amp; Privacy</a>
                            <a class="dropdown-item" href="javascript:void(0);">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-help-circle align-middle mr-1">
                                    <circle cx="12" cy="12" r="10"></circle>
                                    <path d="M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3"></path>
                                    <line x1="12" y1="17" x2="12.01" y2="17"></line>
                                </svg>
                                Help Center</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="javascript:void(0);">Log out</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="content">
            <div class="container-fluid p-0">

                <h1 class="h3 mb-3">古诗</h1>

                <div class="row">
                    <div class="col-12 col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title">梅花 / 梅</h5>
                                <h6 class="card-subtitle text-muted">【作者】王安石 【朝代】宋</h6>
                            </div>
                            <div class="card-body text-center">
                                <div class="mb-3">
                                    <form class="form-horizontal">
                                        <div class="form-group">
                                            <input type="text" class="form-control " readonly value="墙角数枝梅，">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" readonly value="凌寒独自开。">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control " readonly value="遥知不是雪，">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" readonly value="为有暗香来。">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-12 col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <h5 class="card-title">Rounded Buttons</h5>
                                <h6 class="card-subtitle text-muted">Rounded Bootstrap buttons.</h6>
                            </div>
                            <div class="card-body text-center">
                                <div class="mb-3">
                                    <button class="btn btn-pill btn-primary">Primary</button>
                                    <button class="btn btn-pill btn-secondary">Secondary</button>
                                    <button class="btn btn-pill btn-success">Success</button>
                                    <button class="btn btn-pill btn-danger">Danger</button>
                                    <button class="btn btn-pill btn-warning">Warning</button>
                                    <button class="btn btn-pill btn-info">Info</button>
                                </div>
                                <div>
                                    <button class="btn btn-pill btn-primary" disabled="">Primary</button>
                                    <button class="btn btn-pill btn-secondary" disabled="">Secondary</button>
                                    <button class="btn btn-pill btn-success" disabled="">Success</button>
                                    <button class="btn btn-pill btn-danger" disabled="">Danger</button>
                                    <button class="btn btn-pill btn-warning" disabled="">Warning</button>
                                    <button class="btn btn-pill btn-info" disabled="">Info</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-12 col-lg-8 col-xxl-9 d-flex">
                        <div class="card flex-fill">
                            <div class="card-header">

                                <h5 class="card-title mb-0">Latest Projects</h5>
                            </div>
                            <table class="table table-hover my-0">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th class="d-none d-xl-table-cell">Start Date</th>
                                    <th class="d-none d-xl-table-cell">End Date</th>
                                    <th>Status</th>
                                    <th class="d-none d-md-table-cell">Assignee</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Project Apollo</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-success">Done</span></td>
                                    <td class="d-none d-md-table-cell">Vanessa Tucker</td>
                                </tr>
                                <tr>
                                    <td>Project Fireball</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-danger">Cancelled</span></td>
                                    <td class="d-none d-md-table-cell">William Harris</td>
                                </tr>
                                <tr>
                                    <td>Project Hades</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-success">Done</span></td>
                                    <td class="d-none d-md-table-cell">Sharon Lessman</td>
                                </tr>
                                <tr>
                                    <td>Project Nitro</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-warning">In progress</span></td>
                                    <td class="d-none d-md-table-cell">Vanessa Tucker</td>
                                </tr>
                                <tr>
                                    <td>Project Phoenix</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-success">Done</span></td>
                                    <td class="d-none d-md-table-cell">William Harris</td>
                                </tr>
                                <tr>
                                    <td>Project X</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-success">Done</span></td>
                                    <td class="d-none d-md-table-cell">Sharon Lessman</td>
                                </tr>
                                <tr>
                                    <td>Project Romeo</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-success">Done</span></td>
                                    <td class="d-none d-md-table-cell">Christina Mason</td>
                                </tr>
                                <tr>
                                    <td>Project Wombat</td>
                                    <td class="d-none d-xl-table-cell">01/01/2020</td>
                                    <td class="d-none d-xl-table-cell">31/06/2020</td>
                                    <td><span class="badge badge-warning">In progress</span></td>
                                    <td class="d-none d-md-table-cell">William Harris</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-12 col-lg-4 col-xxl-3 d-flex">
                        <div class="card flex-fill w-100">
                            <div class="card-header">

                                <h5 class="card-title mb-0">Monthly Sales</h5>
                            </div>
                            <div class="card-body d-flex w-100">
                                <div class="align-self-center chart chart-lg"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                                    <canvas id="chartjs-dashboard-bar" width="297" height="437" class="chartjs-render-monitor" style="display: block; height: 350px; width: 238px;"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xl-6 col-xxl-5 d-flex">
                        <div class="w-100">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title mb-4">Sales</h5>
                                            <h1 class="display-5 mt-1 mb-3">2.382</h1>
                                            <div class="mb-1">
                                                <span class="text-danger"> <i class="mdi mdi-arrow-bottom-right"></i> -3.65% </span>
                                                <span class="text-muted">Since last week</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title mb-4">Visitors</h5>
                                            <h1 class="display-5 mt-1 mb-3">14.212</h1>
                                            <div class="mb-1">
                                                <span class="text-success"> <i class="mdi mdi-arrow-bottom-right"></i> 5.25% </span>
                                                <span class="text-muted">Since last week</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title mb-4">Earnings</h5>
                                            <h1 class="display-5 mt-1 mb-3">$21.300</h1>
                                            <div class="mb-1">
                                                <span class="text-success"> <i class="mdi mdi-arrow-bottom-right"></i> 6.65% </span>
                                                <span class="text-muted">Since last week</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title mb-4">Orders</h5>
                                            <h1 class="display-5 mt-1 mb-3">64</h1>
                                            <div class="mb-1">
                                                <span class="text-danger"> <i class="mdi mdi-arrow-bottom-right"></i> -2.25% </span>
                                                <span class="text-muted">Since last week</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xl-6 col-xxl-7">
                        <div class="card flex-fill w-100">
                            <div class="card-header">

                                <h5 class="card-title mb-0">Recent Movement</h5>
                            </div>
                            <div class="card-body py-3">
                                <div class="chart chart-sm"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                                    <canvas id="chartjs-dashboard-line" style="display: block; height: 250px; width: 640px;" width="800" height="312" class="chartjs-render-monitor"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- /.row -->

            </div>
        </main>

        <footer class="footer">
            <div class="container-fluid">
                <div class="row text-muted">
                    <div class="col-6 text-left">
                        <p class="mb-0">
                            <a href="${request.contextPath}/sys/home" class="text-muted"><strong>AdminKit
                                ...</strong></a> ©
                        </p>
                    </div>
                    <div class="col-6 text-right">
                        <ul class="list-inline">
                            <li class="list-inline-item">
                                <a class="text-muted" href="javascript:void(0);">亚洲</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-muted" href="javascript:void(0);">中华人民共和国</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-muted" href="javascript:void(0);">上海</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-muted" href="javascript:void(0);">陆家嘴</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </div>

</div>


</body>


<script>
    $(function () {
        $('#datetimepicker-dashboard').datetimepicker({
            inline: true,
            sideBySide: false,
            format: 'L'
        });

        var ctx = document.getElementById('chartjs-dashboard-line').getContext("2d");
        var gradient = ctx.createLinearGradient(0, 0, 0, 225);
        gradient.addColorStop(0, 'rgba(215, 227, 244, 1)');
        gradient.addColorStop(1, 'rgba(215, 227, 244, 0)');
        // Line chart
        new Chart(document.getElementById("chartjs-dashboard-line"), {
            type: 'line',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "Sales ($)",
                    fill: true,
                    backgroundColor: gradient,
                    borderColor: window.theme.primary,
                    data: [
                        2115,
                        1562,
                        1584,
                        1892,
                        1587,
                        1923,
                        2566,
                        2448,
                        2805,
                        3438,
                        2917,
                        3327
                    ]
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                tooltips: {
                    intersect: false
                },
                hover: {
                    intersect: true
                },
                plugins: {
                    filler: {
                        propagate: false
                    }
                },
                scales: {
                    xAxes: [{
                        reverse: true,
                        gridLines: {
                            color: "rgba(0,0,0,0.0)"
                        }
                    }],
                    yAxes: [{
                        ticks: {
                            stepSize: 1000
                        },
                        display: true,
                        borderDash: [3, 3],
                        gridLines: {
                            color: "rgba(0,0,0,0.0)"
                        }
                    }]
                }
            }
        });

        // Bar chart
        new Chart(document.getElementById("chartjs-dashboard-bar"), {
            type: 'bar',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "This year",
                    backgroundColor: window.theme.primary,
                    borderColor: window.theme.primary,
                    hoverBackgroundColor: window.theme.primary,
                    hoverBorderColor: window.theme.primary,
                    data: [54, 67, 41, 55, 62, 45, 55, 73, 60, 76, 48, 79],
                    barPercentage: .75,
                    categoryPercentage: .5
                }]
            },
            options: {
                maintainAspectRatio: false,
                legend: {
                    display: false
                },
                scales: {
                    yAxes: [{
                        gridLines: {
                            display: false
                        },
                        stacked: false,
                        ticks: {
                            stepSize: 20
                        }
                    }],
                    xAxes: [{
                        stacked: false,
                        gridLines: {
                            color: "transparent"
                        }
                    }]
                }
            }
        });
    });
</script>
</html>