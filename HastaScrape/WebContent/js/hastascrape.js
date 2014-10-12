/*
 * Copyright 2013 Olivier Croisier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

var app = angular.module('hastascrapeApp', ['ngResource']);



// ============================== APPLICATION ==============================

app.config(function ($routeProvider, $locationProvider) {
	 $routeProvider.when('/rest/hastaScrapeList', {templateUrl: 'view/annunciMap.html', controller: 'AnnunciMapController'});
	 $routeProvider.otherwise({redirectTo: 'rest/hastaScrapeList'});
    $locationProvider.hashPrefix('!'); // Enable ajax crawling
});

// ============================== RESOURCES ==============================



app.factory('HastaScrape',  function ($resource) {
    return $resource(
        'rest/hastaScrapeList', {});
});

// ============================== CONTROLLERS ==============================

app.controller('AnnunciMapController', ['$scope', 'HastaScrape', '$location', function ($scope, HastaScrape, $location) {
    $scope.annunci = HastaScrape.query();
}]);






