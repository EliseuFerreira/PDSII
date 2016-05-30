var ticketModule = angular.module('ticketModule',[]);

ticketModule.controller("ticketControl",function($scope,$http) {
 

	urlTicket = 'http://localhost:8080/Ticket/rs/ticket';
	urlTecnico = 'http://localhost:8080/Ticket/rs/tecnico';

$scope.pesquisarTicket = function(){
	$http.get(urlTicket).success(function(tickets){
		$scope.tickets = tickets;
		$scope.total = $scope.tickets.length;
		}).error(function(erro){
	alert(erro);
		});
}

// Criei esta função para limitar a lista de Tickets
function carregarLista() {
	$scope.limite = $scope.valor;
    if($scope.limite > $scope.total){
    	$scope.limite = $scope.total;
    }else{
    	$scope.limite = $scope.valor;
    }

    if($scope.limite == null || $scope.limite <5){
    	$scope.limite = 5;
    }

};

$scope.carregaMais = function() {
    carregarLista();
};


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