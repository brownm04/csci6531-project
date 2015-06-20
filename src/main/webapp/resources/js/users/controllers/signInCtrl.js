angular.module('teamawesome.users').controller('SignInCtrl', ['$scope', '$http', '$rootScope', '$state', function($scope, $http, $rootScope, $state) {
	$scope.submit = function() {
		$http({
			method: 'POST',
			url: '/csci/rest/users/signin',
			data: $scope.user
		}).success(function(data) {
			$rootScope.$broadcast('user.signin', data);
			$state.go('task-list');
		});
	};
}]);