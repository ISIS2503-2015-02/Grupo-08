/**
 * Created by fabioespinosa on 9/15/15.
 */







var tbc = angular.module('tbc', []);

    tbc.directive('mainPage', function(){
        return{
            restrict:'E',
            templateUrl: 'partials/main-page.html',
            controller: 'appCtrl'
        };
    });

    tbc.directive('loginForm', function(){
        return{
            restrict:'E',
            templateUrl: 'partials/login-form.html',
            controller: 'appCtrl',
            controllerAs: 'loginStatus'
        };
    });

    tbc.directive('navUpSide', function(){
        return{
            templateUrl: 'partials/nav-up-side.html',
            controller: 'appCtrl'

        };
    });


    tbc.controller('appCtrl', ['$scope', function($scope) {
        this.model = {};
        this.model.logged;

        this.login=function(){
            return this.model.logged;
        };
        this.logging=function(){
            if ($scope.model.password==='bb'){
                this.logged=true;
                console.log(this.logged);
            }
            else{
                console.log($scope.model.password);
            }
        };

    }]);