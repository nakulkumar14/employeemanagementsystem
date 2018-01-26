var app = angular.module('app',[]);
app.controller('LoginController',function($scope,$growl,$http){

    $scope.login = function(username,password){
        var user = {
            username:username,
            password:password
        }
        $http({
            url : "/login/authenticate",
            method : "POST",
            data : user
        }).success(function(data) {
            growl.info(data);
            console.log("authenticate"+data);
        }).error(function(data, status, headers, config) {
            growl.error("Unable to send for picking");
            console.log("authenticate"+error);
        });
    };

});