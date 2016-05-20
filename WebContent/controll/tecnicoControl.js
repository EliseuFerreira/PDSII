
var tecnicoModule = angular.module('tecnicoModule',[]);

tecnicoModule.controller("tecnicoControl",function($scope,$http) {


	urlTecnico = 'http://localhost:8080/Ticket/rs/tecnico';
	urlDepartamento = 'http://localhost:8080/Ticket/rs/departamento';
	


$scope.pesquisarTecnico = function(){
	$http.get(urlTecnico).success(function(tecnicos){
		$scope.tecnicos = tecnicos;
	}).error(function(erro){
	alert(erro);
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
	if($scope.tecnico.codigo == ''){
		$http.post(urlTecnico,$scope.tecnico).success(function(tecnico){
			$scope.tecnicos.push($scope.tecnico);
			$scope.novo();
		}).error(function (erro){
			alert(erro);

		});
	} else{
		$http.put(urlTecnico,$scope.tecnico).success(function(tecnico){
			$scope.pesquisarTecnico();
			$scope.novo();
		}).error(function (erro){
			alert(erro);

		});
	}
}



$scope.excluir = function(){
	if($scope.tecnico.codigo == ''){
		alert('Selecione um tecnico');
	}
	else{
		urlExcluir = urlTecnico + "/" + $scope.tecnico.codTecnico;
		$http.delete(urlExcluir).success(function(){
			$scope.pesquisarTecnico();
			$scope.novo();
		}).error(function (erro){
			alert(erro);
		});
	}

}

$scope.novo = function(){
	$scope.tecnico = "";
}


$scope.pesquisarTecnico();
$scope.pesquisarDepartamento();

});