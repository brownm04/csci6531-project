angular.module('teamawesome').factory('GlobalSrv', ['$rootScope', function($rootScope) {
	var factory = {};
	
	$rootScope.$on('user.signin', function(ev, user) {
		factory.user = user;
	});
	
	$rootScope.$on('user.signout', function(ev) {
		delete factory.user;
	});
	
	return factory;
}]);