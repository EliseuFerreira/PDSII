var departamentoModule = angular.module('departamentoModule',[]);
departamentoModule.controller("departamentoControl",function($scope,$http) {

	urlDepartamento = 'http://localhost:8080/Ticket/rs/departamento';


	$scope.pesquisarDepartamento = function(){
		$http.get(urlDepartamento).success(function(departamentos){
			$scope.departamentos = departamentos;
		}).error(function(erro){
		alert(erro);
	});

	}
	$scope.selecionaDepartamento = function(departamento){
		$scope.departamento = departamento;
	}


	$scope.salvar = function(){
		if($scope.departamento.codigo == ''){
			$http.post(urlDepartamento,$scope.departamento).success(function(departamento){
				$scope.departamentos.push($scope.departamento);
				$scope.novo();
			}).error(function (erro){
				alert(erro);

			});
		} else{
			$http.put(urlDepartamento,$scope.departamento).success(function(departamento){
				$scope.pesquisarDepartamento();
				$scope.novo();
			}).error(function (erro){
				alert(erro);

			});
		}
	}



	$scope.excluir = function(){
		if($scope.departamento.codigo == ''){
			alert('Selecione um departamento');
		}
		else{
			urlExcluir = urlDepartamento + "/" + $scope.departamento.codDepartamento;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarDepartamento();
				$scope.novo();
			}).error(function (erro){
				alert(erro);
			});
		}

	}

	$scope.novo = function(){
		$scope.departamento = "";
	}


	$scope.pesquisarDepartamento();

	});