'use strict';

angular.module('myApp').service('UserService', ['$http', '$q', '$window', '$timeout', function ($http, $q, $window, $timeout) {

    var USER_LOGIN_URL = DOMIAN_NAME + '/login';

    this.login = function (user) {
        var deferred = $q.defer();
        $http.post(USER_LOGIN_URL, user).then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }
}]);
