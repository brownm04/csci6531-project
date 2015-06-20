angular.module('teamawesome').controller('HeaderCtrl', ['$scope', '$rootScope', 'GlobalSrv', function($scope, $rootScope, GlobalSrv) {
	$scope.user = GlobalSrv.user;
	
	$scope.$on('user.signin', function(ev, user) {
		$scope.user = user;
	});
	
	$scope.signOut = function() {
		delete $scope.user;
		$rootScope.$broadcast('user.signout');
	};
}]);