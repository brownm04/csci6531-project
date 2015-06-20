window.bootstrap = function() {
  angular.bootstrap(document.documentElement, ['teamawesome']);
};

window.init = function() {
  window.bootstrap();
};

angular.element(document).ready(function() {
  window.init();
});

window.app = angular.module('teamawesome', ['ui.bootstrap', 'ui.router', 'teamawesome.users', 'teamawesome.tasks']);

window.app.config(['$urlRouterProvider', function($urlRouterProvider) {
  $urlRouterProvider.otherwise('/tasks/list');
}]);

window.app.config(function(ngQuickDateDefaultsProvider) {
  // Configure with icons from font-awesome
  return ngQuickDateDefaultsProvider.set({
    closeButtonHtml: "<i class='fa fa-times'></i>",
    buttonIconHtml: "<i class='fa fa-calendar'></i>",
    nextLinkHtml: "<i class='fa fa-chevron-right'></i>",
    prevLinkHtml: "<i class='fa fa-chevron-left'></i>"
  });
});
