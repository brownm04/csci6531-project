angular.module('teamawesome.tasks', ['ui.router', 'ui.bootstrap', 'ngQuickDate'])
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('task-list', {
      url: '/tasks/list',
      templateUrl: 'resources/js/tasks/partials/list.html',
      controller: 'TaskListCtrl'
    });
  }]);