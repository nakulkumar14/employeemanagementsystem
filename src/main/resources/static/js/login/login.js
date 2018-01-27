
var app = angular.module('app',[]);
app.controller('LoginController',function($scope,$http,$window){

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
            if(response.response == "SUCCESS"){
                // $location.path("/employee/getAllEmployees");
                // $window.location.href = "/employee/getAllEmployees";
                $window.location.href = "login.html";
            }else{
                document.getElementById("error").innerHTML = response.response;
            }
        }).error(function(response) {
            console.log("error "+response);
            document.getElementById("error").innerHTML = response.response;
        });
    };

    $scope.register = function () {
        console.log("register");
    };

});