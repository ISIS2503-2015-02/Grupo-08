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
        L.mapbox.accessToken = 'pk.eyJ1IjoiZmFiaW9lc3Bpbm9zYSIsImEiOiJjaWVtMGJ4a28wMDdnNHFrbjY1OWtxbXN6In0.nSjm5Xx8l3Hg4JqTjkdm0w';
        var map = L.mapbox.map('map', 'mapbox.streets').setView([4.69, -74.085], 13);


        $scope.getTranvias=function(){
            $http.get('https://exp2.diegorbaquero.com/tranvia').success(function(data,headers)
            {
                getTranviasFunction(data);
            }).error(function(data, headers){
                $http.get('https://exp2.diegorbaquero.com/tranvia').success(function(data,headers)
                {
                    getTranviasFunction(data);
                });
            });
        };
        $scope.getMobibus=function(){
            $http.get('https://exp2.diegorbaquero.com/mobibus').success(function(data,headers){
                getMobibusFunction(data);
            }).error(function(data, headers){
                $http.get('https://exp2.diegorbaquero.com/mobibus').success(function(data,headers){
                    getMobibusFunction(data);
                });
            });
        };

        getTranviasFunction=function(data){
            $scope.tranvias=data;
            var myLayer = L.mapbox.featureLayer().addTo(map);
            var features = [];
            angular.forEach($scope.tranvias, function(value, key) {
                features.push({
                    type: 'Feature',
                    geometry: {
                        type: 'Point',
                        coordinates: [
                            value.longitud,
                            value.latitud
                        ]
                    },
                    properties: {
                        title: 'Tranvia ' + value.id,
                        description: value.id + " " + value.latitud + " " + value.longitud,
                        'marker-size': 'small',
                        'marker-color': '#119911',
                        'marker-symbol': 'rail-metro'
                    }
                });
            });
            myLayer.setGeoJSON({
                type: 'FeatureCollection',
                features: features
            })
        };

        getMobibusFunction=function (data){
            $scope.mobibuses=data;
            var myLayer = L.mapbox.featureLayer().addTo(map);
            var features = [];
            angular.forEach($scope.mobibuses, function(value, key) {
                features.push({
                    type: 'Feature',
                    geometry: {
                        type: 'Point',
                        coordinates: [
                            value.longitud,
                            value.latitud
                        ]
                    },
                    properties: {
                        title: 'Mobibus ' + value.id,
                        description: value.id + " " + value.latitud + " " + value.longitud,
                        'marker-size': 'small',
                        'marker-color': '#111199',
                        'marker-symbol': 'bus'
                    }
                });
            });
            myLayer.setGeoJSON({
                type: 'FeatureCollection',
                features: features
            })
        };

        $scope.getVCubs=function(){
            $http.get('https://exp2.diegorbaquero.com/estacion').success(function(data,headers){
                $scope.vcubs=data;
            }).error(function(data, headers){
                $http.get('https://exp2.diegorbaquero.com/estacion').success(function(data,headers){
                    $scope.vcubs=data;
                });
            });
        };

        $scope.getTranviasFuncionando=function(){
            $http.get('https://exp2.diegorbaquero.com/tranviaCuenta').success(function(data,header){
                $scope.cantTranvias=data;
            }).error(function(data, headers) {
                $http.get('https://exp2.diegorbaquero.com/tranviaCuenta').success(function (data, headers) {
                    $scope.vcubs = data;
                });
            });
        };

        $scope.getMobibusesFuncionando=function(){
            $http.get('https://exp2.diegorbaquero.com/mobibusCuenta').success(function(data,header){
                $scope.cantMobibus=data;
            }).error(function(data, headers){
                $http.get('https://exp2.diegorbaquero.com/mobibusCuenta').success(function(data,header){
                    $scope.cantMobibus=data;
                });
            })
        };

        $scope.getVcubsFuncionando=function(){
            $http.get('https://exp2.diegorbaquero.com/estacionCuenta').success(function(data,header){
                $scope.cantVCubs=data;
            }).error(function(data, headers) {
                $http.get('https://exp2.diegorbaquero.com/estacionCuenta').success(function (data, headers) {
                    $scope.vcubs = data;
                });
            });
        };



        $scope.logged=false;

        $scope.ingresar = function(){
            console.log($scope.user);
            $http.get('https://exp2.diegorbaquero.com/login/'+$scope.user.user +'/'+$scope.user.password).success(function(data,headers)
            {
                ingresarFunction(data);
            }).error(function(data, headers){
                ingresarFunction(data);
            })
        };

        ingresarFunction=function(data){
            console.log(data);
            if(data==="false"){
                alert("Incorrecto");
            }
            else{
                $scope.logged=true;
                console.log("sis");
            }
        };



        $scope.inicializar = function(){
          $scope.logged=false;
        };

        $scope.inicializar();

        $scope.getTranvias();
        $scope.getMobibus();
        $scope.getVCubs();

        $scope.getTranviasFuncionando();
        $scope.getMobibusesFuncionando();
        $scope.getVcubsFuncionando();



        var modWidth=800;
        $("#map").css('width', '100%');
    }]);

