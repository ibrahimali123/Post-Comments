'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
	var self = this;

	self.user = {username : '' , password: ''};
	$scope.loignStatus = true;

	self.login = function() {
		UserService.login(self.user).then(
			function (response) { 
				var userToken_ = { username: window.btoa(response.username), token: window.btoa(response.token) };
				sessionStorage.setItem("userToken", JSON.stringify(userToken_));
				window.location.href = './home.html';
			},
			function (errResponse) {
				$scope.loignStatus = false;
			}
			);
	}
}]);
