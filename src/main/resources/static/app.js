'use strict';

angular.module('myApp', [ "ui.router" ])

.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/");
	$stateProvider.state("/", {
		url : '/',
		templateUrl : "partials/users.html"
	}).state("/deneme", {
		url : '/deneme',
		templateUrl : "partials/deneme.html"
	})
})

.controller('mainCtrl', function($scope, $http, getUsersService) {
	$scope.user = {};
	$scope.onlyNumber = /^[0-9]*$/;
	
	getUsersService.getUsers().then(function(response) {
		$scope.users = response.data;
	})
	
	$scope.createUser = function(user) {
		getUsersService.saveUser(user).then(function(response) {
			$scope.users = response.data;
		})
	};
	$scope.deleteUser = function(userId) {
		getUsersService.deleteUser(userId).then(function(response) {
			$scope.users = response.data;
		})
	};
	$scope.updateUser = function(userId,user) {
		getUsersService.updateUser(userId,user).then(function(response) {
			$scope.users = response.data;
		})
	};
	
	

})

.service('getUsersService', function($http) {
	this.getUsers = function() {
		return $http.get('/users');
	}
	this.saveUser = function(user) {
		return $http.post('/users/', user)
	}
	this.deleteUser = function(userId){
		return $http.delete('/users/'+userId)
	}
	this.updateUser = function(userId,user){
		return $http.put('/users/'+userId,user)
	}
})
