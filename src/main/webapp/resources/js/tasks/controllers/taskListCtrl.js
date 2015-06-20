angular.module('teamawesome.tasks').controller('TaskListCtrl', function($scope, TaskSrv, $modal, GlobalSrv, $rootScope) {

	function getAllTasks() {
		TaskSrv.findAll().success(function(data) {
			$scope.tasks = data;
		});
	}
	getAllTasks();
	
	$scope.user = GlobalSrv.user;
	
	$rootScope.$on('user.signin', function(ev, user) {
		$scope.user = user;
	});
	
	$rootScope.$on('user.signout', function(ev) {
		delete $scope.user;
	});

	$scope.create = function() {
		var modalInstance = $modal.open({
			templateUrl: 'taskCreateModal.html',
			controller: TaskCreateModalCtrl
		});
		
		modalInstance.result.then(function(task) {
			getAllTasks();
		});
	};
	
	var TaskCreateModalCtrl = function($scope, TaskSrv, $http, GlobalSrv, $modalInstance) {
		$http.get('/csci/rest/category/all').success(function(data) {
		    $scope.categories = data;
		    
		    if (typeof $scope.task === 'undefined' || !$scope.task)
		    	$scope.task = {};
		    $scope.task.category = data[0];
		});
	
		$scope.submit = function() {
			$scope.task.postedBy = GlobalSrv.user;
			
			TaskSrv.create($scope.task).then(function(data) {
				$modalInstance.close(data);
			});
		};
		
		$scope.cancel = function() {
			$modalInstance.dismiss('cancel');
		};
	};
});