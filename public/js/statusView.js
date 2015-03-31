$(document).ready(
		function() {
			$.getJSON("/monitoring/status/idps", function(idps) {
				$('#idps').html('<h3>Input Data Per Second = ' + idps + '</h3>');
			});
			$.getJSON("/monitoring/status/odps", function(odps) {
				$('#odps').html('<h3>Output Data Per Second = ' + odps + '</h3>');
			});
			$('#hostnameTable')
					.dataTable(
							{
								"iDisplayLength" : 50,
								"ajax" : {
									"url" : "/hostname/status",
									"dataSrc" : ""
								},
								"columns" : [
										{
											"data" : "status"
										},
										{
											"data" : "hostname",
											"render" : function(data, type,
													full, meta) {
												return '<a href="'
														+ locationUrl
														+ '/host/' + data
														+ '" target="_blank">'
														+ data + '</a>';
											}
										}, {
											"data" : "size"
										} ]
							});
		});