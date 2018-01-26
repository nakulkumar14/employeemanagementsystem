
var app = angular.module('app',[]);
app.controller('LoginController',function($scope,$http){

    $scope.login = function(username,password){
        var user = {
            username:username,
            password:password
        }
        $http({
            url : "/login/authenticate",
            method : "POST",
            data : user
        }).success(function(response) {
            console.log("authenticate"+response);
        }).error(function(response) {
            console.log("error "+response);
        });
    };

    $scope.register = function () {
        console.log("register");
    };

});