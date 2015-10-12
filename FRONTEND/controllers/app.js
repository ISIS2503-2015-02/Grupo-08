/**
 * Created by fabioespinosa on 9/15/15.
 */


var tbc = angular.module('tbc', ['ngRoute', 'ui.bootstrap']);






    tbc.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/login', {
            controller: 'appCtrl',
            templateUrl: 'partials/login-form.html',
        })
        .when('/home', {
            controller:'appCtrl',
            templateUrl: 'partials/main-page.html'
        })

        .otherwise({ redirectTo: '/login' });
    }])


    tbc.directive('mainPage', function(){
        return{
            restrict:'A',
            replace:true,
            templateUrl: 'partials/main-page.html',
            controller: 'appCtrl'
        };
    });

    tbc.directive('loginForm', function(){
        return{
            restrict:'A',
            replace:true,
            templateUrl: 'partials/login-form.html',
            controller: 'appCtrl',
            controllerAs: 'loginStatus'
        };
    });


    tbc.controller('appCtrl', ['$scope', function($scope) {
        $scope.addCompetitor=function(){
            console.log('name');
            $http.get('http://localhost:8080/competitors/add', JSON.stringify($scope.competitor)).success(function(data,headers){
                $scope.competitor={};
                $scope.toolbar.selectTab(2);
            });
        };
    }]);



tbc.controller("competitorCtrl", function($http, $scope) {

});