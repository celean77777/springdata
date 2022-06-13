angular.module('market-front', []).controller('appController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/springdata/';

     let pageNamber=0;
     let isLast = false;

  $scope.nextPage = function (){
      if(!isLast){
          $scope.loadProducts(pageNamber + 1);
      }

  }

    $scope.previousPage = function (){

        $scope.loadProducts(pageNamber - 1);

    }

    $scope.loadProducts = function (pageIndex=1) {
        $http({
            url: contextPath + 'products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            pageNamber=response.data.number + 1;
            isLast = response.data.last;
        });
    }


    $scope.showInfo = function (product) {
        alert(product.title);
    }

    $scope.delete = function (product){
        $http({
            url: contextPath + 'products/delete/' + product.id,
            method: 'GET'
        }).then(function (response) {
            console.log(response);
            $scope.loadProducts(1);
        });
    }

    $scope.loadProducts(1);



});