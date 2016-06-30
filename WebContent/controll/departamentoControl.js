var departamentoModule = angular.module('departamentoModule',[]);

departamentoModule.controller("departamentoControl",function($scope,$http) {
	var urlDepartamento = 'http://localhost:8080/Ticket/rs/departamento';


	$scope.pesquisarDepartamento = function(){
		$http.get(urlDepartamento).success(function(departamentos){
			$scope.departamentos = departamentos;
		}).error(function(mensagemErro){
			$scope.mensagens.push('Erro ao pesquisar categorias '+mensagemErro);
	});

	}
	$scope.selecionaDepartamento = function(departamento){
		$scope.departamento = departamento;
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
			angular.forEach(listaErro, function(value, key){
			$scope.mensagens.push(value.message);
			});
	}



	$scope.salvar = function(){
		if($scope.departamento.codDepartamento == undefined || $scope.departamento.codDepartamento == ''){
			$http.post(urlDepartamento,$scope.departamento).success(function(departamento){
				$scope.departamentos.push(departamento);
				$scope.novo();
				$scope.mensagens.push('Departamento salvo com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);

			});
		} else{
			$http.put(urlDepartamento,$scope.departamento).success(function(departamento){
				$scope.pesquisarDepartamento();
				$scope.novo();
				$scope.mensagens.push('Departamento atualizado com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);

			});
		}
	}



	$scope.excluir = function(){
		if($scope.departamento.codDepartamento == ''){
			alert('Selecione um departamento');
		}
		else{
			urlExcluir = urlDepartamento + "/" + $scope.departamento.codDepartamento;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarDepartamento();
				$scope.novo();
			}).error(function (erro){
				$scope.mensagens.push('Erro ao excluir departamento: ' + erro);
			});
		}

	}

	$scope.novo = function(){
		$scope.departamento = {};
		$scope.mensagens = [];
	}	


	$scope.pesquisarDepartamento();

	});