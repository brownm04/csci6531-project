angular.module('teamawesome.users').controller('RegisterCtrl', ['$scope', '$http', '$state', '$rootScope', function($scope, $http, $state, $rootScope) {
	$scope.submit = function() {
		console.log($scope.user);
		$http({
			method: 'POST',
			url: '/csci/rest/users/create',
			data: $scope.user
		}).success(function(data) {
			$rootScope.$broadcast('user.signin', data);
			$state.go('task-list');
		});
	};
}]);