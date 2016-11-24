'use strict';

angular.module('myApp').service('CommentService', ['$http', '$q', function ($http, $q) {

 var COMMENT_URL = DOMIAN_NAME + '/comment';

 this.post = function (comment) {
    var deferred = $q.defer();
    $http.post(COMMENT_URL + '/save', comment).then(
        function (response) {
            deferred.resolve(response.data);
        },
        function (errResponse) {
            deferred.reject(errResponse);
        }
        );
    return deferred.promise;
}

this.approve = function (id) {
    var deferred = $q.defer();
    $http.post(COMMENT_URL + '/approve', id).then(
        function (response) {
            deferred.resolve(response.data);
        },
        function (errResponse) {
            deferred.reject(errResponse);
        }
        );
    return deferred.promise;
}

this.fetchAllApprovedComments = function () {
    var deferred = $q.defer();
    $http.get(COMMENT_URL + '/approvedComments').then(
        function (response) {
            deferred.resolve(response.data);
        },
        function (errResponse) {
            deferred.reject(errResponse);
        }
        );
    return deferred.promise;
}

this.fetchAllUnApprovedComments = function () {
    var deferred = $q.defer();
    $http.get(COMMENT_URL + '/unApprovedComments').then(
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
