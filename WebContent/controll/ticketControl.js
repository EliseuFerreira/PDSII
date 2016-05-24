
var ticketModule = angular.module('ticketModule',[]);

ticketModule.controller("ticketControl",function($scope,$http) {


	urlTicket = 'http://localhost:8080/Ticket/rs/ticket';
	urlTecnico = 'http://localhost:8080/Ticket/rs/tecnico';
	


$scope.pesquisarTicket = function(){
	$http.get(urlTicket).success(function(tickets){
		$scope.tickets = tickets;
	}).error(function(erro){
	alert(erro);
});
}

$scope.pesquisarTecnico = function(){
	$http.get(urlTecnico).success(function(tecnicos){
		$scope.tecnicos = tecnicos;
	}).error(function(erro){
	alert(erro);
});

}

$scope.selecionaTicket = function(ticket){
	$scope.ticket = ticket;
}


$scope.salvar = function(){
	if($scope.ticket.codTicket == ''){
		$http.post(urlTicket,$scope.ticket).success(function(ticket){
			$scope.tickets.push($scope.ticket);
			$scope.novo();
		}).error(function (erro){
			alert(erro);

		});
	} else{
		$http.put(urlTicket,$scope.ticket).success(function(ticket){
			$scope.pesquisarTicket();
			$scope.novo();
		}).error(function (erro){
			alert(erro);

		});
	}
}



$scope.excluir = function(){
	if($scope.ticket.codigo == ''){
		alert('Selecione um ticket');
	}
	else{
		urlExcluir = urlTicket + "/" + $scope.ticket.codTicket;
		$http.delete(urlExcluir).success(function(){
			$scope.pesquisarTicket();
			$scope.novo();
		}).error(function (erro){
			alert(erro);
		});
	}

}

$scope.novo = function(){
	$scope.ticket = "";
	
}


$scope.pesquisarTicket();
$scope.pesquisarTecnico();

});