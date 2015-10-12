/**
 * Created by fabioespinosa on 9/15/15.
 */


var tbc = angular.module('tbc', ['ngRoute']);






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




    tbc.directive('loginForm', function(){
        return{
            restrict:'A',
            replace:true,
            templateUrl: 'partials/login-form.html',
            controller: 'appCtrl',
            controllerAs: 'loginStatus'
        };
    });


    tbc.controller('appCtrl', ['$scope', '$http', function($scope, $http) {
        $scope.getTranvias=function(){
            $http.get('http://exp2.diegorbaquero.com/tranvia').success(function(data,headers){
                $scope.tranvias=data;

            });
        };
        $scope.getMobibus=function(){
            $http.get('http://exp2.diegorbaquero.com/mobibus').success(function(data,headers){
                $scope.mobibuses=data();
            });
        };


        $scope.getTranvias();
        $scope.getMobibus;
    }]);

//[{"id":"1","tiempoSalida":"2015-09-17 22:13:19","tiempoLlegada":"0000-00-00 00:00:00","linea":"B","longitud":"45.6","latitud":"12.3","emergencia":"1"}

tbc.controller("competitorCtrl", function($http, $scope) {

});