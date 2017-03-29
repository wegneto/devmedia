_.leadingzero = function(v) {
	if (v < 10) {
		return '0' + v;
	} else {
		return v;
	}
};

_.formatdate = function(v) {
	if (v) {
		var d = new Date(v);
		var date = [ _.leadingzero(d.getDate()),
				_.leadingzero(d.getMonth() + 1), d.getFullYear() ];
		var time = [ _.leadingzero(d.getHours()), _.leadingzero(d.getMinutes()) ];
		return date.join('/') + ' ' + time.join(':');
	} else {
		return v;
	}
};

_.status = function(v) {
	switch (v) {
	case 'A':
		return 'Em Atendimento';
		break;
	case 'C':
		return 'Cancelado';
		break;
	case 'F':
		return 'Finalizado';
		break;
	case 'N':
		return 'Novo';
		break;
	default:
		return v;
	}
};