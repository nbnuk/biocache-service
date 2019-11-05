<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %><%@ include file="/common/taglibs.jsp" %>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="description" content="sharing biodiversity knowledge" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Occurrence webservices | NBN Atlas</title>

    <style>
        .dropdown-menu li a {
            background-color: #1e73be !important;
            color: #fff !important;
        }
        .divider {
            background-color: #fff
        }
        .dropdown-menu {
            background-color: #1e73be !important;
        }
    </style>

    <link href="https://layout.nbnatlas.org/uk/commonui-bs3/css/bootstrap.min.css" rel="stylesheet" media="screen,print"/>
    <link href="https://layout.nbnatlas.org/uk/commonui-bs3/css/bootstrap-theme.min.css" rel="stylesheet" media="screen,print"/>
    <link href="https://layout.nbnatlas.org/uk/commonui-bs3/css/ala-styles.css" rel="stylesheet" media="screen,print"/>
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans|PT+Sans:400,700" rel="stylesheet" type="text/css">
    <link href="https://nbnatlas.org/shared/css-bs3/" type="text/css" rel="stylesheet" media="screen, projection, print" />

    <!-- Favicon -->
    <link href="https://layout.nbnatlas.org/uk/favicon.ico" rel="shortcut icon"  type="image/x-icon"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://layout.nbnatlas.org/uk/commonui-bs3/js/application.js"
            defer></script>
    <script type="text/javascript"
            src="https://layout.nbnatlas.org/uk/commonui-bs3/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- Navbar -->
<nav id="alatopnav" class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">
                <!-- <img alt="NBN Atlas" class="img-responsive" src="https://nbnatlas.org/wp-content/uploads/2017/01/AL_Logo-15-1440x363.png"> -->
            </a>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand font-xsmall" href="/">The NBN Atlas</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li >
                    <a href="https://nbnatlas.org/contact-us/">
                        Contact us
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li >
                    <a target="_blank" rel="noopener noreferrer" href="https://nbn.org.uk/join-or-donate/">Get involved</a>
                </li>

                <li class="dropdown font-xsmall">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        NBN Atlas Apps
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="https://spatial.nbnatlas.org/">Spatial portal</a></li>
                        <li ><a href="https://records.nbnatlas.org/">Occurrence search</a></li>
                        <li ><a href="https://species.nbnatlas.org/">Species</a></li>
                        <li ><a href="https://regions.nbnatlas.org/">Regions</a></li>
                        <li ><a href="https://records.nbnatlas.org/explore/your-area">Explore your area</a></li>

                        <li class="divider"></li>
                        <li><a href="https://registry.nbnatlas.org/">Collections</a></li>
                        <li><a href="https://lists.nbnatlas.org/">Traits, species lists</a></li>
                        <li><a href="http://registry.nbnatlas.org/datasets">Datasets browser</a></li>

                        <li class="divider"></li>
                        <li><a target="_blank" rel="noopener noreferrer" href="https://nbn.org.uk/join-or-donate/">Join or Donate</a></li>

                    </ul>
                </li>
                <li class="dropdown font-xsmall">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        Choose NBN Atlas
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="menu-item menu-nbn-atlas"><a href="https://nbnatlas.org/">NBN Atlas</a></li>
                        <li class="menu-item menu-nbn-atlas-isle-of-man"><a href="https://isleofman.nbnatlas.org/">NBN Atlas Isle of Man</a></li>
                        <li class="menu-item menu-nbn-atlas-northern-ireland"><a href="https://northernireland.nbnatlas.org/">NBN Atlas Northern Ireland</a></li>
                        <li class="menu-item menu-nbn-atlas-scotland"><a href="https://scotland.nbnatlas.org/">NBN Atlas Scotland</a></li>
                        <li class="menu-item menu-nbn-atlas-wales"><a href="https://wales.nbnatlas.org/">NBN Atlas Wales</a></li>
                        <li class="menu-item menu-france"><a target="_blank" rel="noopener noreferrer" href="http://www.gbif.fr/">France</a></li>
                        <li class="menu-item menu-spain"><a target="_blank" rel="noopener noreferrer" href="http://datos.gbif.es">Spain</a></li>
                        <li class="menu-item menu-portugal"><a href="http://dados.gbif.pt/">Portugal</a></li>
                        <li class="menu-item menu-australia"><a target="_blank" rel="noopener noreferrer" href="http://www.ala.org.au">Australia</a></li>
                        <li class="menu-item menu-argentina"><a href="http://datos.sndb.mincyt.gob.ar">Argentina</a></li>
                        <li class="menu-item menu-global-gbif"><a target="_blank" rel="noopener noreferrer" href="http://www.gbif.org">Global (GBIF)</a></li>
                    </ul>
                </li>

            </ul>
            <form class="navbar-form navbar-left" role="search" action="https://species.nbnatlas.org/search" method="get">
                <div class="form-group">
                    <input id="search" class="autocomplete form-control" title="Search" type="text" name="q" placeholder="Search the Atlas" autocomplete="off">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>

            <small>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown font-xsmall">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            User settings
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="https://auth.nbnatlas.org/cas/login?service=https://nbnatlas.org/">Log in</a></li>
                            <li><a href="https://auth.nbnatlas.org/userdetails/registration/createAccount">Register</a></li>
                        </ul>
                    </li>
                </ul>
            </small>

        </div>
        <!-- /.navbar-collapse --> </div>
    <!-- /.container-fluid --> </nav>

<div id="main" class="container dmbs-container">
<decorator:body/>
</div><!-- End container -->
</body>
</html>
