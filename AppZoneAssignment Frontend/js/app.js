'use strict';

var App = angular.module('myApp', ['ngAnimate', 'ui.bootstrap']);

var DOMIAN_NAME = 'http://localhost:8080/AppZoneAssignment';


function authenticateUser(){
    var userToken_ = sessionStorage.getItem("userToken");
    var userToken = JSON.parse(userToken_);
    if(userToken == null){
        window.location.href = './login.html';
    }else{
        userToken.username = window.atob(userToken.username);
        userToken.token = window.atob(userToken.token);
        return userToken;
    }
}