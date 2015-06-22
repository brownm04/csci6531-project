<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="./resources/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/css/teamawesome.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/lib/font-awesome-4.1.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="./resources/lib/ng-quick-date/ng-quick-date-default-theme.css" />
	<link rel="stylesheet" type="text/css"
	href="./resources/lib/ng-quick-date/ng-quick-date.css" />
</head>
<body>
	<header data-ng-include="'./resources/js/header/partials/header.html'"
		data-role="navigation"></header>

	<script type="text/javascript"
		src="./resources/lib/angularjs/angular.js"></script>
	<script type="text/javascript"
		src="./resources/lib/angular-ui-bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
	<script type="text/javascript"
		src="./resources/lib/angular-ui-router/angular-ui-router.min.js"></script>
	<script type="text/javascript"
		src="./resources/lib/moment/moment.js"></script>
	<script type="text/javascript"
		src="./resources/lib/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="./resources/lib/ng-quick-date/ng-quick-date.min.js"></script>
	<script type="text/javascript"
		src="./resources/lib/angular-sanitize/sanitize.js"></script>

	<section class="container">
		<div data-ui-view></div>
	</section>

	<script type="text/javascript" src="./resources/js/app.js"></script>

	<script type="text/javascript"
		src="./resources/js/header/controllers/headerCtrl.js"></script>
	<script type="text/javascript"
		src="./resources/js/header/services/globalSrv.js"></script>

	<script type="text/javascript" src="./resources/js/users/users.js"></script>
	<script type="text/javascript"
		src="./resources/js/users/controllers/registerCtrl.js"></script>
	<script type="text/javascript"
		src="./resources/js/users/controllers/signInCtrl.js"></script>

	<script type="text/javascript" src="./resources/js/tasks/tasks.js"></script>
	<script type="text/javascript"
		src="./resources/js/tasks/controllers/taskListCtrl.js"></script>
	<script type="text/javascript"
		src="./resources/js/tasks/directives/taskItemDrv.js"></script>
	<script type="text/javascript"
		src="./resources/js/tasks/services/taskSrv.js"></script>
</body>
</html>