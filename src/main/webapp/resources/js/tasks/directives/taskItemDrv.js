angular.module('teamawesome.tasks').directive('taItem', function($http, $sce, GlobalSrv) {
	return {
		restrict: 'A',
		scope: {
			task: '='
		},
		link: function(scope, elem, attrs) {
			scope.userView = function() {
				$http.post('/csci/rest/viewlog/create', { 
					task: scope.task,
					user: GlobalSrv.user,
					dateViewed: Date.now()
				});
			};
			
			scope.trustedTask = $sce.trustAsHtml(scope.task.description);
		},
		template: '<div class="row">' +
			'<h5 data-ng-bind="task.category.category"></h5>' +
			'<div data-ng-bind-html="trustedTask" data-ng-click="userView()"></div>' +
			'<div data-ng-bind="task.payment"></div>' +
		'</div>'
	};
});