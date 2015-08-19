angular.module('haas', []).controller('HelloController', ['$scope', function($scope) {
    $scope.greetings = [
        {
            route: 'hello',
            label: 'Hello'
        },
        {
            route: 'hero',
            label: 'Hero'
        },
        {
            route: 'aloha',
            label: 'Aloha'
        }
    ];
}]);