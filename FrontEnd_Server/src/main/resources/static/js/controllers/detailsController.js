crmApp.controller('detailsController',
    function loginController($scope, $http) {

        const contextPath = 'http://localhost:5555/api/v1/users';

        $scope.userDetails = null;

        $scope.loadDetails = function () {
            $http({
                method: 'GET',
                url: contextPath
            })
                .then(function (response) {
                    $scope.userDetails = response.data;
                });
        };

        $scope.saveDetails = function() {
            $http({
                method: 'POST',
                url: contextPath,
                data: $scope.userDetails
            });
        };

        $scope.loadDetails();
    }
)