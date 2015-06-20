angular.module('teamawesome.users', ['ui.router', 'ui.bootstrap'])
	.config(['$stateProvider', function($stateProvider) {
		$stateProvider
			.state('register', {
				url: '/register',
				templateUrl: 'resources/js/users/partials/register.html',
				controller: 'RegisterCtrl'
			})
			.state('signIn', {
				url: '/signIn',
				templateUrl: 'resources/js/users/partials/signIn.html',
				controller: 'SignInCtrl'
			});
	}]);