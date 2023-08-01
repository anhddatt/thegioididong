var app = angular.module("myapp", ["ngRoute"]);
app.controller("myCtrl1", function ($scope, $rootScope, $routeParams, $http) {
    $scope.scrollToTop = function () {
        window.scrollTo(0, 0);
    }
});
app.config(function ($routeProvider) {
    $routeProvider
        .when("/detail/:url", {
            templateUrl: "sanphamchitiet.html?" + Math.random(),
            controller: "myCtrl1"
        })
        .when("admin/account", {
            templateUrl: "views/admin/_account.jsp" + Math.random(),
            controller: "myCtrl1"
        })
        .when("/find", {
            templateUrl: "timkiem.html?" + Math.random(),
            controller: "myCtrl1"
        })
        .otherwise({
            templateUrl: "views/admin/_account.jsp",
            controller: "myCtrl1"
        })


});