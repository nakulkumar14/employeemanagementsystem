app.controller('UserProfileController',function($scope,$http,$window) {
    // $scope.customers = [];

    $scope.loadData = function(){
        $http.get('../employee/getEmployeeById/1').then(function(data){
            console.log("data : "+data)
            // $scope.customers = data;
        })
    }

    //call loadData when controller initialized
    $scope.loadData();
});