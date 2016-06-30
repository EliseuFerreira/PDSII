var ticketModule = angular.module('ticketModule',[]);

ticketModule.controller("ticketControl",function($scope,$http) {
 	urlTicket = 'http://localhost:8080/Ticket/rs/ticket';
	urlTecnico = 'http://localhost:8080/Ticket/rs/tecnico';

	$scope.pesquisarTicket = function(){
		$http.get(urlTicket).success(function(tickets){
			$scope.tickets = tickets;
		}).error(function(mensagemErro){
			$scope.mensagens.push('Erro ao pesquisar categorias '+mensagemErro);
	});

	}

	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
			angular.forEach(listaErro, function(value, key){
			$scope.mensagens.push(value.message);
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
		if($scope.ticket.codTicket == undefined || $scope.ticket.codTicket == ''){
			$http.post(urlTicket,$scope.ticket).success(function(ticket){
				$scope.tickets.push(ticket);
				$scope.novo();
				$scope.mensagens.push('Ticket salvo com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
	
			});
		} else{
			$http.put(urlTicket,$scope.ticket).success(function(ticket){
				$scope.pesquisarTicket();
				$scope.novo();
				$scope.mensagens.push('Ticket atualizado com sucesso');
			}).error(function (erro){
				$scope.montaMensagemErro(erro.parameterViolations);
	
			});
		}
	}
	
	
	$scope.excluir = function(){
		if($scope.ticket.codTicket == ''){
			alert('Selecione um ticket');
		}
		else{
			urlExcluir = urlTicket + "/" + $scope.ticket.codTicket;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarTicket();
				$scope.novo();
			}).error(function (erro){
				$scope.mensagens.push('Erro ao excluir ticket: ' + erro);
			});
		}
	
	}
$scope.novo = function(){
	$scope.ticket = "";
	$scope.mensagens = [];
}

$scope.pesquisarTicket();
$scope.pesquisarTecnico();

});