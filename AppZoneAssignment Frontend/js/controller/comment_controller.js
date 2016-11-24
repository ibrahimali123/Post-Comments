'use strict';

angular.module('myApp').controller('CommentController', ['$scope', 'CommentService', function ($scope, CommentService) {
    var self = this;

    var userToken = authenticateUser();
    fetchAllApprovedComments();
    fetchAllUnApprovedComments();

    var _user = { id:0}
    self.comment = {text : '' , user: ''};

    $scope.commentStatus = false;

    self.post = function() {
        _user.id = userToken.token;
        self.comment.user = _user;
        CommentService.post(self.comment).then(
            function (response) {
                $scope.commentStatus = true;
                self.comment.text = '';
            },
            function (errResponse) {
                $scope.commentStatus = false;
            }
            );
    }

    self.approve = function(comment_id) {
        CommentService.approve(comment_id).then(
            function (response) {
                fetchAllUnApprovedComments();
            },
            function (errResponse) {
            }
            );
    }

    function fetchAllApprovedComments() {
        CommentService.fetchAllApprovedComments().then(
         function (response) {
             $scope.approvedComments = response;
         },
         function (errResponse) {
             console.error('Error while fetching comments');
         }
         );
    }

    function fetchAllUnApprovedComments() {
        CommentService.fetchAllUnApprovedComments().then(
         function (response) {
            $scope.unApprovedComments = response;
         },
         function (errResponse) {
             console.error('Error while fetching comments');
         }
         );
    }
}]);
