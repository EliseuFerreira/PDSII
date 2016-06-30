
var tecnicoModule = angular.module('tecnicoModule',[]);

tecnicoModule.controller("tecnicoControl",function($scope,$http) {
	urlTecnico = 'http://localhost:8080/Ticket/rs/tecnico';
	urlDepartamento = 'http://localhost:8080/Ticket/rs/departamento';
	


	$scope.pesquisarTecnico = function(){
		$http.get(urlTecnico).success(function(tecnicos){
			$scope.tecnicos = tecnicos;
		}).error(function(mensagemErro){
			$scope.mensagens.push('Erro ao pesquisar categorias '+mensagemErro);
	});

	}

	$scope.pesquisarDepartamento = function(){
		$http.get(urlDepartamento).success(function(departamentos){
			$scope.departamentos = departamentos;
		}).error(function(erro){
		alert(erro);
	});

	}

	$scope.selecionaTecnico = function(tecnico){
		$scope.tecnico = tecnico;
	}
	
	
	$scope.salvar = function(){
		if($scope.tecnico.codTecnico == undefined || $scope.tecnico.codTecnico == ''){
			$http.post(urlTecnico,$scope.tecnico).success(function(tecnico){
				$scope.tecnicos.push(tecnico);
				$scope.novo();
				$scope.mensagens.push('Tecnico salvo com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
	
			});
		} else{
			$http.put(urlTecnico,$scope.tecnico).success(function(tecnico){
				$scope.pesquisarTecnico();
				$scope.novo();
				$scope.mensagens.push('Tecnico atualizado com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
	
			});
		}
	}
	
	
	
	$scope.excluir = function(){
		if($scope.tecnico.codTecnico == ''){
			alert('Selecione um tecnico');
		}
		else{
			urlExcluir = urlTecnico + "/" + $scope.tecnico.codTecnico;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarTecnico();
				$scope.novo();
			}).error(function (erro){
				$scope.mensagens.push('Erro ao excluir tecnico: ' + erro);
			});
		}
	
	}
	
	$scope.novo = function(){
		$scope.tecnico = "";
		$scope.tecnico = {};
		$scope.mensagens = [];
	}
	
	
	$scope.pesquisarTecnico();
	$scope.pesquisarDepartamento();

});