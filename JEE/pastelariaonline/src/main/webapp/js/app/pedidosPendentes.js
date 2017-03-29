var tabelaTemplate = '<p align="center">' + '<table id="pedidos">' + '<thead>'
		+ '<tr>' + '<th>ID do pedido</th>' + '<th>Data do pedido</th>'
		+ '<th>Sabor</th>' + '<th>Quantidade</th>' + '<th>Cliente</th>'
		+ '<th>Telefone</th>' + '<th>E-mail</th>' + '<th>Status</th>'
		+ '<th>Atendente</th>' + '<th>Data do atendimento</th>' + '</tr>'
		+ '</thead>' + '<tbody>' + '<% _.each(pedidos, function(pedido) { %>'
		+ '<tr>' + '<td><%= pedido.id %></td>'
		+ '<td><%= _.formatdate(pedido.dataPedido) %></td>'
		+ '<td><%= pedido.itens[0].sabor %></td>'
		+ '<td><%= pedido.itens[0].quantidade %></td>'
		+ '<td><%= pedido.cliente %></td>' + '<td><%= pedido.telefone %></td>'
		+ '<td><%= pedido.email %></td>'
		+ '<td><%= _.status(pedido.status) %></td>'
		+ '<td><%= pedido.atendente %></td>'
		+ '<td><%= _.formatdate(pedido.dataAtendimento) %></td>' + '</tr>'
		+ '<% }); %>' + '</tbody>' + '</table>' + '</p>';

function montarTabela(json) {
	if (json) {
		$('#container').empty();
		var template = _.template(tabelaTemplate, json);
		$('#container').append(template);
	} else {
		console.log('JSON invalido');
	}
}

function atender(id, status) {
	console.log('Iniciando o atendimento do pedido ' + id);

	$.ajax({
		url : './atendimento',
		type : 'POST',
		accepts : 'application/json',
		data : 'id=' + id,
		timeout : 10000
	}).done(function(data, textStatus, jqXHR) {
		alert('Pedido em processo de atendimento');
		console.log('Pedido em processo de atendimento');
	}).fail(function(data, textStatus, jqXHR) {
		alert('Ocorreu um erro ao atender o pedido: ' + jqXHR);
		console.log('Ocorreu um erro ao atender o pedido: ' + jqXHR);
	}).always(function(data, textStatus, jqXHR) {
		console.log('Finalizando requisição de atendimento do pedido');
	});
}

$(document)
		.ready(
				function() {
					(function() {
						$
								.ajax({
									url : './pedidos',
									type : 'GET',
									accepts : 'application/json',
									timeout : 10000
								})
								.done(
										function(data, textStatus, jqXHR) {
											montarTabela(data);
											console.log('Pedidos consultados com sucesso');
										})
								.fail(
										function(data, textStatus, jqXHR) {
											console.log('Ocorreu um erro ao buscar os pedidos cadastrados: '
															+ jqXHR);
										})
								.always(
										function(data, textStatus, jqXHR) {
											console.log('Finalizando busca de pedidos');
										});
					})();
				});